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
		Treno treno;

		try {
			treno = trenoService.find(trenoId);
			Treno trenoDuplicato = trenoService.createTreno(treno.getSigla(), treno.getCompagnia(), utente);
			trenoDuplicato = trenoService.update(trenoDuplicato, trenoDuplicato.getId());
			model.addAttribute("treno", trenoDuplicato);
			return "redirect:/order";
		} catch (Exception e) {
			model.addAttribute("errorMessage", "Impossibile duplicare il treno: " + e.getMessage());
			return "order";
		}
	}


}


