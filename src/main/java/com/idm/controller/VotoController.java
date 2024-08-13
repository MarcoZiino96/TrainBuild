package com.idm.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.idm.entity.Voto;
import com.idm.service.VotoService;
import com.idm.vo.VotoVO;

@Controller
public class VotoController {

	@Autowired
	VotoService votoService;

	@PostMapping("/voto")
	public String voto(@ModelAttribute("voto") VotoVO votoVo, Model model) {
		Voto voto = votoService.salvaOUpdateVoto(votoVo);
		model.addAttribute("voto", voto);
		model.addAttribute("successSave", "voto salvato con successo!!");
			return "redirect:/order";
	}

}

