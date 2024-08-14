package com.idm.controller;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idm.entity.Factory;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.entity.Voto;
import com.idm.exception.CargoException;
import com.idm.exception.LocomotivaException;
import com.idm.exception.RistoranteException;
import com.idm.exception.StringaException;
import com.idm.service.TrenoFilterService;
import com.idm.service.TrenoService;
import com.idm.service.UtenteService;
import com.idm.service.VotoService;
import com.idm.vo.TrenoVO;
import com.idm.vo.VotoVO;


@Controller	
public class TrenoController {

	@Autowired
	private TrenoService trenoService;
		
	@Autowired
	private TrenoFilterService trenoFilterService;
	
	@Autowired
	private UtenteService utenteService;

	@GetMapping("/home")
	public String showHome(@ModelAttribute("treno") TrenoVO trenoVo,HttpSession session, Model model){
		Utente utente = (Utente) session.getAttribute("utente");
		model.addAttribute("utente", utente);
		return "home";
	}
	
	@GetMapping("/details")
	public String showDatails(HttpSession session, @ModelAttribute("voto") VotoVO votoVo, Model model){
	    Utente utente = (Utente) session.getAttribute("utente");
	    TrenoVO trenoVo = (TrenoVO) session.getAttribute("treno");
	    model.addAttribute("utente", utente);
	    model.addAttribute("treno", trenoVo);
	    return "details";
	}
	
	@GetMapping("/order")
	public String ordina(
			@RequestParam(required = false) String ordinamento,
			@RequestParam(required = false) String direction,
			Model model) {

		if (ordinamento == null || ordinamento.isEmpty()) {
			ordinamento = "compagnia"; 
		}
		if (direction == null || direction.isEmpty()) {
			direction = "ASC"; 
		}


		List<TrenoVO> treni = trenoService.retriveWithOrderVO(ordinamento, direction);

		model.addAttribute("treni",treni);
		model.addAttribute("ordinamento", ordinamento); 
		model.addAttribute("direction", direction); 
		model.addAttribute("voto", new VotoVO());
		return "order"; 
	}
		
	
	@GetMapping("/filter")
	public String filter(
	    @RequestParam(name = "lunghezzaMin", required = false) Integer lunghezzaMin,
	    @RequestParam(name = "lunghezzaMax", required = false) Integer lunghezzaMax,
	    @RequestParam(name = "prezzoMin", required = false) Integer prezzoMin,
	    @RequestParam(name = "prezzoMax", required = false) Integer prezzoMax,
	    @RequestParam(name = "pesoMin", required = false) Integer pesoMin,
	    @RequestParam(name = "pesoMax", required = false) Integer pesoMax,
	    @RequestParam(name = "siglaContains", required = false) String siglaContains,
	    @RequestParam(name = "utente", required = false) String utenteStr,
	    Model model) {

	    TrenoFilter filter = new TrenoFilter();

	    // Controlla e imposta i parametri
	    if (utenteStr != null && !utenteStr.isEmpty()) {
	        Utente utente = utenteService.findByUsername(utenteStr);
	        if (utente == null) {
	            model.addAttribute("error", "Nessun utente trovato con l'username fornito.");
	            return "order"; 
	        } else {
	            filter.setUtenteIds(Collections.singletonList(utente.getId()));
	        }
	    }

	    if (lunghezzaMin != null && lunghezzaMin >= 0) {
	        filter.setLunghezzaMin(lunghezzaMin);
	    }
	    if (lunghezzaMax != null && lunghezzaMax >= 0) {
	        filter.setLunghezzaMax(lunghezzaMax);
	    }
	    if (prezzoMin != null && prezzoMin >= 0) {
	        filter.setPrezzoMin(prezzoMin);
	    }
	    if (prezzoMax != null && prezzoMax >= 0) {
	        filter.setPrezzoMax(prezzoMax);
	    }
	    if (pesoMin != null && pesoMin >= 0) {
	        filter.setPesoMin(pesoMin);
	    }
	    if (pesoMax != null && pesoMax >= 0) {
	        filter.setPesoMax(pesoMax);
	    }
	    if (siglaContains != null && !siglaContains.isEmpty()) {
	        filter.setSiglaContains(siglaContains);
	    }

	    if (prezzoMin != null && prezzoMax != null && prezzoMin > prezzoMax) {
	        model.addAttribute("error", "Il prezzo minimo non può essere maggiore del prezzo massimo.");
	        return "order"; 
	    }
	    if (pesoMin != null && pesoMax != null && pesoMin > pesoMax) {
	        model.addAttribute("error", "Il peso minimo non può essere maggiore del peso massimo.");
	        return "order"; 
	    }
	    if (lunghezzaMin != null && lunghezzaMax != null && lunghezzaMin > lunghezzaMax) {
	        model.addAttribute("error", "La lunghezza minima non può essere maggiore della lunghezza massima.");
	        return "order"; 
	    }

	    List<TrenoVO> treni = trenoFilterService.filterTreniVO(filter);
	    if (siglaContains != null && !siglaContains.isEmpty() && treni.isEmpty()) {
	        model.addAttribute("error", "Nessun treno trovato con la sigla specificata.");
	    } else {
	        model.addAttribute("treni", treni);
	    }

	    return "order"; 
	}
	
	@PostMapping("/selectDetails")
	public String selectTreno(@RequestParam("id") Integer id, HttpSession session) {
	    Treno treno = trenoService.find(id);
	    TrenoVO trenoVo = new TrenoVO();
	    BeanUtils.copyProperties(treno, trenoVo);
	    session.setAttribute("treno", trenoVo);
	    return "redirect:/details";
	}
	@PostMapping("/newTrain")
	public String creaTreno(@RequestParam Factory compagnia, @RequestParam String sigla, HttpSession session, Model model) {
		Utente utente = (Utente) session.getAttribute("utente");
		Treno treno;
		try {
			if (utente == null) {
				treno = trenoService.createTrenoProva(sigla, compagnia);
				model.addAttribute("treno", treno);
				return "home";
			} else {
				treno = trenoService.createTreno(sigla, compagnia, utente);
				session.setAttribute("utente", utente);
				model.addAttribute("treno", treno);
				return "redirect:/order";
			}   
		} catch (StringaException | LocomotivaException | CargoException | RistoranteException e) {
			model.addAttribute("errorMessage", e.getMessage());
			model.addAttribute("errorSigla", e.getSigla());
			model.addAttribute("errorSuggerimento", e.getSuggerimento());
			model.addAttribute("errorSiglaSuggerita", e.getSiglaSuggerita());
			return "home";
		}
	}

	@PostMapping("/eliminaTreno")
	public String eliminaTreno(@RequestParam Integer trenoId, HttpSession session, Model model) {
		Utente utente = (Utente) session.getAttribute("utente");
		if (utente == null) {
			model.addAttribute("errorMessage", "Devi essere loggato per eliminare un treno.");
			return "home";
		}

		try {
			Treno treno = trenoService.find(trenoId);

			if (treno.getUtente().getId() != utente.getId()) {
				model.addAttribute("errorMessage", "Non hai il permesso di eliminare questo treno.");
				return "order";
			}

			trenoService.delete(trenoId);
			return "redirect:/order";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Errore durante l'eliminazione del treno.");
			return "order";
		}
	}

	@PostMapping("/modificaTreno")
	public String modificaTreno(@RequestParam Integer trenoId, @RequestParam String sigla, @RequestParam Factory compagnia, HttpSession session, Model model) {
		Utente utente = (Utente) session.getAttribute("utente");
		Treno treno;

		try {
			Treno trenoAggiornato= trenoService.createTrenoProva(sigla, compagnia);

			treno = trenoService.find(trenoId);
			treno.setSigla(trenoAggiornato.getSigla());
			treno.setCompagnia(trenoAggiornato.getCompagnia());
			treno.setPrezzo(trenoAggiornato.getPrezzo());
			treno.setLunghezza(trenoAggiornato.getLunghezza());
			treno.setPeso(trenoAggiornato.getPeso());


			treno = trenoService.update(treno, trenoId);
			model.addAttribute("treno", treno);

			return "redirect:/order";

		} catch (StringaException | LocomotivaException | CargoException | RistoranteException e) {
			model.addAttribute("errorMessage", e.getMessage());
			model.addAttribute("errorSigla", e.getSigla());
			model.addAttribute("errorSuggerimento", e.getSuggerimento());
			model.addAttribute("errorSiglaSuggerita", e.getSiglaSuggerita());
			model.addAttribute("treni", trenoService.retrive()); 

			return "order"; 

		}
	}

	@PostMapping("/duplicaTreno")
	public String duplicaTreno(@RequestParam Integer trenoId, HttpSession session, Model model ) {
	    Utente utente = (Utente) session.getAttribute("utente");

	    try {
	        
	        Treno trenoOriginale = trenoService.find(trenoId);
	        if (trenoOriginale == null) {
	            model.addAttribute("errorMessage", "Treno non trovato.");
	            return "order";
	        }

	      
	        Treno trenoDuplicato = new Treno();
	        trenoDuplicato.setSigla(trenoOriginale.getSigla());
	        trenoDuplicato.setCompagnia(trenoOriginale.getCompagnia());
	        trenoDuplicato.setPrezzo(trenoOriginale.getPrezzo());
	        trenoDuplicato.setLunghezza(trenoOriginale.getLunghezza());
	        trenoDuplicato.setPeso(trenoOriginale.getPeso());

	        trenoDuplicato = trenoService.createTreno(trenoDuplicato.getSigla(), trenoDuplicato.getCompagnia(), utente);

	        trenoDuplicato = trenoService.update(trenoDuplicato, trenoDuplicato.getId());

	       
	        model.addAttribute("treno", trenoDuplicato);
	        return "redirect:/order";
	        
	    } catch (Exception e) {
	        model.addAttribute("errorMessage", "Impossibile duplicare il treno: " + e.getMessage());
	        return "order";
	    }
	}
	
	
	
}



