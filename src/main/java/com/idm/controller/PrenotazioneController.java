package com.idm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	
	
	@PostMapping("/prenota")
	public String prenotaPosto(@ModelAttribute("prenotazione") PrenotazioneVO prenotazioneVO, Model model ){
		
		try{		
			prenotazioneService.creaPrenotazione(prenotazioneVO);
			model.addAttribute("messaggio", "Posto prenotato con successo.");	
		}catch(IllegalStateException e) {	
			model.addAttribute("errorMessage", e.getMessage());
		}
		
		List<TrenoVO> treni = trenoService.findTreniConVagonePasseggeri();
	    model.addAttribute("treni", treni);
	    return "prenota";
		
	}

}
