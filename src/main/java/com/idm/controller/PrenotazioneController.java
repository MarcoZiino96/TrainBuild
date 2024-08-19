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

import com.idm.entity.Prenotazione;
import com.idm.entity.Utente;
import com.idm.service.PrenotazioneService;
import com.idm.service.TrenoService;
import com.idm.vo.PrenotazioneVO;
import com.idm.vo.TrenoVO;

@Controller
public class PrenotazioneController {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	@Autowired
	TrenoService trenoService;
	
	
	@GetMapping("/miePrenotazioni")
	public String miePrenotazioni(HttpSession session, Model model){	
		Utente utente = (Utente)session.getAttribute("utente");
		List<Prenotazione> prenotazioni = prenotazioneService.prenotazioniutenteById(utente.getId());
		model.addAttribute("prenotazioni",prenotazioni);
		model.addAttribute("utente", utente);
		return "miePrenotazioni";
	}
	
	@PostMapping("/prenota")
	public String prenotaPosto(@ModelAttribute("prenotazione") PrenotazioneVO prenotazioneVO,@RequestParam int trenoId, Model model ){
		
		try{		
			prenotazioneService.creaPrenotazione(prenotazioneVO, trenoId);
			return "redirect:/miePrenotazioni";
		}catch(IllegalStateException e) {	
			model.addAttribute("errorMessage", e.getMessage());
			List<TrenoVO> treni = trenoService.findTreniConVagonePasseggeri();
		    model.addAttribute("treni", treni);
		    return "prenota";
		}	
	}

}
