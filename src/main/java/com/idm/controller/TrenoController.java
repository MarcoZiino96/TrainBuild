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
import com.idm.service.impl.TrenoServiceImpl;
import com.idm.vo.TrenoVO;

@Controller    
public class TrenoController {
    
    @Autowired
    private TrenoServiceImpl trenoServiceImpl;
    
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
                treno = trenoServiceImpl.createTrenoProva(sigla, compagnia);
            } else {
                treno = trenoServiceImpl.createTreno(sigla, compagnia, utente);
                session.setAttribute("utente", utente);
            }
            model.addAttribute("treno", treno);
            return "redirect:/order";
        } catch (StringaException | LocomotivaException | CargoException | RistoranteException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "home";
        }
    }
    
    @GetMapping("/order")
    public String ordina(@RequestParam(required = false) String ordinamento,
                         @RequestParam(required = false) String direction,
                         Model model) {

        if (ordinamento == null || ordinamento.isEmpty()) {
            ordinamento = "compagnia"; 
        }
        if (direction == null || direction.isEmpty()) {
            direction = "ASC"; 
        }

        List<TrenoVO> treni = trenoServiceImpl.retriveWithOrderVO(ordinamento, direction);

        model.addAttribute("treni", treni);
        model.addAttribute("ordinamento", ordinamento); 
        model.addAttribute("direction", direction); 
        return "order"; 
    }
}
