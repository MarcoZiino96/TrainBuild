package com.idm.controller;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.idm.entity.Factory;
import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.exception.CargoException;
import com.idm.exception.LocomotivaException;
import com.idm.exception.RistoranteException;
import com.idm.exception.StringaException;
import com.idm.service.TrenoService;
import com.idm.vo.TrenoVO;

@Controller
public class TrenoController {

	@Autowired
	private TrenoService trenoService;

	@GetMapping("/home")
	public String showHome(@ModelAttribute("treno") TrenoVO trenoVo, HttpSession session, Model model){
		Utente utente = (Utente) session.getAttribute("utente");
		model.addAttribute("utente", utente);
		return "home";
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

	@GetMapping("/order")
	public String ordina(@RequestParam(required = false) String ordinamento, @RequestParam(required = false) String direction, Model model) {
		if (ordinamento == null || ordinamento.isEmpty()) {
			ordinamento = "compagnia"; 
		}
		if (direction == null || direction.isEmpty()) {
			direction = "ASC"; 
		}

		List<TrenoVO> treni = trenoService.retriveWithOrderVO(ordinamento, direction);

		model.addAttribute("treni", treni);
		model.addAttribute("ordinamento", ordinamento); 
		model.addAttribute("direction", direction); 
		return "order";
	}

	@GetMapping("/gestioneTreni")
	public String gestioneTreni(HttpSession session, Model model) {
		Utente utente = (Utente) session.getAttribute("utente");
		if (utente == null) {
			model.addAttribute("errorMessage", "Devi essere loggato per gestire i treni.");
			return "home";
		}
		List<Treno> treni = trenoService.retrive();
		model.addAttribute("treni", treni);
		return "gestioneTreni";  
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
				return "gestioneTreni";
			}

			trenoService.delete(trenoId);
			return "redirect:/gestioneTreni";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Errore durante l'eliminazione del treno.");
			return "gestioneTreni";
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

			return "redirect:/gestioneTreni";

		} catch (StringaException | LocomotivaException | CargoException | RistoranteException e) {
			model.addAttribute("errorMessage", e.getMessage());
			model.addAttribute("errorSigla", e.getSigla());
			model.addAttribute("errorSuggerimento", e.getSuggerimento());
			model.addAttribute("errorSiglaSuggerita", e.getSiglaSuggerita());
			model.addAttribute("treni", trenoService.retrive()); 

			return "gestioneTreni"; 

		}
	}

	@PostMapping("/duplicaTreno")
	public String duplicaTreno(@RequestParam Integer trenoId, HttpSession session, Model model ) {
		Utente utente = (Utente) session.getAttribute("utente");

		try {

			Treno trenoOriginale = trenoService.find(trenoId);
			if (trenoOriginale == null) {
				model.addAttribute("errorMessage", "Treno non trovato.");
				return "gestioneTreni";
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
			return "redirect:/gestioneTreni";

		} catch (Exception e) {
			model.addAttribute("errorMessage", "Impossibile duplicare il treno: " + e.getMessage());
			return "gestioneTreni";
		}
	}

	@PostMapping("/invertiTreno")
	public String invertiTreno(@RequestParam Integer trenoId, HttpSession session, Model model) {
		Utente utente = (Utente) session.getAttribute("utente");

		try {
			Treno trenoOriginale = trenoService.find(trenoId);
			if (trenoOriginale == null) {
				model.addAttribute("errorMessage", "Treno non trovato.");
				return "redirect:/gestioneTreni"; 
			}

			String sigla = trenoOriginale.getSigla();


			if (sigla.startsWith("H") || sigla.startsWith("h")) {

				String siglaInversa;
				
				siglaInversa = sigla.substring(0, 1) + new StringBuilder(sigla.substring(1)).reverse().toString();


				if (sigla.endsWith("H") || sigla.endsWith("h")) {

					siglaInversa = new StringBuilder(sigla).reverse().toString();
				}


				trenoOriginale.setSigla(siglaInversa);
				trenoService.update(trenoOriginale, trenoId);

				model.addAttribute("successMessage", "La sigla è stata invertita con successo.");
			} else {
				model.addAttribute("errorMessage", "La sigla non inizia con 'H' o 'h'.");
			}

		} catch (Exception e) {
			model.addAttribute("errorMessage", "Impossibile invertire il treno: " + e.getMessage());
		}

		return "redirect:/gestioneTreni"; 
	}


}


