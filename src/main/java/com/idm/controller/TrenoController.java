package com.idm.controller;

import java.util.Collections;
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
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.exception.CargoException;
import com.idm.exception.LocomotivaException;
import com.idm.exception.RistoranteException;
import com.idm.exception.StringaException;
import com.idm.service.TrenoService;
import com.idm.service.UtenteService;
import com.idm.service.TrenoFilterService;
import com.idm.vo.TrenoVO; 



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

		String error = trenoFilterService.validateAndBuildFilter(filter, utenteStr, lunghezzaMin, lunghezzaMax, 
				prezzoMin, prezzoMax, pesoMin, pesoMax, siglaContains);
		if (error != null) {
			model.addAttribute("error", error);
			return "filter";
		}

		List<TrenoVO> treni = trenoFilterService.filterTreniVOWithErrorHandling(filter);
        if (treni == null) {
            model.addAttribute("error", "Nessun risultato trovato per i criteri di ricerca selezionati.");
        } else {
            model.addAttribute("treni", treni);
        }

		return "filter"; 
	}

}




