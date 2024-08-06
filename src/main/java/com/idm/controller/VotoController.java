package com.idm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.idm.service.VotoService;
import com.idm.vo.VotoVO;

@Controller
public class VotoController {

    @Autowired
    VotoService votoService;

    @PostMapping("/votaTreno")
    public String votaTreno(@RequestParam("trenoId") Integer trenoId,
                            @RequestParam("utenteId") Integer utenteId,
                            @RequestParam("voto") Integer voto,
                            RedirectAttributes redirectAttributes) {

        VotoVO nuovoVotoVo = new VotoVO();
        nuovoVotoVo.setTrenoId(trenoId);
        nuovoVotoVo.setUtenteId(utenteId);
        nuovoVotoVo.setVoto(voto);

        votoService.creaVoto(nuovoVotoVo);
        redirectAttributes.addFlashAttribute("message", "Voto registrato con successo!");

        return "redirect:/order";
    }
}
