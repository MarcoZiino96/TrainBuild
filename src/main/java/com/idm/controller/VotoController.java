package com.idm.controller;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idm.entity.Treno;
import com.idm.entity.Utente;
import com.idm.entity.Voto;
import com.idm.service.TrenoService;
import com.idm.service.UtenteService;
import com.idm.service.VotoService;
import com.idm.vo.VotoVO;

@Controller
public class VotoController {

	@Autowired
	VotoService votoService;

	@Autowired
	UtenteService utenteService;

	@Autowired
	TrenoService trenoService;

	@PostMapping("/votaTreno")
	public String votaTreno(@RequestParam("trenoId") Integer trenoId,
			@RequestParam("utenteId") Integer utenteId,
			@RequestParam("voto") Integer voto,
			Model model) {

		//		Utente utente = utenteService.find(utenteId);
		//		Treno treno = trenoService.find(trenoId);

		//		if(utente == null || treno == null) {
		//			throw new RuntimeException("utente o treno non trovato");
		//		}
		//			

		//		System.err.println(utente);
		//		System.err.println(treno);



		//		try {

		//Voto votoEsistente = votoService.votoEsistente(utente.getId(), treno.getId());

		//if(votoEsistente==null) {

		Voto nuovoVotoVo = new Voto();
		nuovoVotoVo.setTreno(trenoService.find(trenoId));
		nuovoVotoVo.setUtente(utenteService.find(utenteId));
		nuovoVotoVo.setVoto(voto);
		votoService.creaVoto(nuovoVotoVo);

		model.addAttribute("message", "Voto registrato con successo!");

		//}else {
		//				votoEsistente.setVoto(voto);
		//				votoService.updateVoto(votoEsistente);
		//				model.addAttribute("message","Voto modificato con successo");
		//}

		//} catch (Exception e) {
		//			model.addAttribute("error", "Errore durante il salvataggio del voto: " + e.getMessage());
		//			e.printStackTrace(); 
		//		}


		return "redirect:/order";
	}

}

