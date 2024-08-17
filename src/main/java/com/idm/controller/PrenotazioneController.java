package com.idm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.idm.service.PrenotazioneService;
import com.idm.vo.PrenotazioneVO;

@Controller
public class PrenotazioneController {
	
	@Autowired
	PrenotazioneService prenotazioneService;
	
	
	
	@PostMapping("/prenota")
	public String prenotaPosto(@ModelAttribute PrenotazioneVO prenotazioneVO, Model model ){
		
		try{		
			prenotazioneService.creaPrenotazione(prenotazioneVO);
			model.addAttribute("messaggio", "Posto prenotato con successo.");
			
			return "prenota";
			
		}catch(IllegalStateException e) {	
			model.addAttribute("errorMessage", e.getMessage());
			return "prenota";
		}
		
	}

}
