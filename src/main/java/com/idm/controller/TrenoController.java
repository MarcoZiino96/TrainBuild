package com.idm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.idm.entity.Factory;
import com.idm.entity.Treno;
import com.idm.entity.TrenoFilter;
import com.idm.entity.Utente;
import com.idm.service.TrenoFilterService;
import com.idm.service.TrenoService;
import com.idm.service.impl.TrenoFilterServiceImpl;
import com.idm.vo.TrenoVO;
import com.idm.vo.UtenteVO;


	@Controller	
	public class TrenoController {
		
		@Autowired
		private TrenoService trenoService;
		
		@Autowired
		private TrenoFilterServiceImpl trenoFilterServiceImpl;
		
		@GetMapping("/home")
		public String showHome(@ModelAttribute("treno") TrenoVO trenoVo,HttpSession session, Model model){
			Utente utente = (Utente) session.getAttribute("utente");
			model.addAttribute("utente", utente);
			return "home";
		}
		
		
		@PostMapping("/newTrain")
		public String creaTreno(@RequestParam Factory compagnia,@RequestParam String sigla,HttpSession session,Model model){
			
			Utente utente = (Utente)session.getAttribute("utente");
			
			
			if(utente == null) {
				Treno treno = trenoService.createTrenoProva( sigla, compagnia);
				model.addAttribute("treno", treno);
				return "home";	
			}
			
			Treno treno = trenoService.createTreno( sigla, compagnia, utente);
			model.addAttribute("treno", treno);
			session.setAttribute("utente", utente);
			return "redirect:/order";	
			
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
	        @RequestParam(name = "lunghezzaMin", defaultValue = "0") int lunghezzaMin,
	        @RequestParam(name = "lunghezzaMax", defaultValue = "0") int lunghezzaMax,
	        @RequestParam(name = "prezzoMin", defaultValue = "0") int prezzoMin,
	        @RequestParam(name = "prezzoMax", defaultValue = "0") int prezzoMax,
	        @RequestParam(name = "siglaContains", defaultValue = "") String siglaContains,
	        @RequestParam(name = "utente", defaultValue = "") String utente,
	        Model model) {
			
			

	        TrenoFilter filter = new TrenoFilter();
	        filter.setLunghezzaMin(lunghezzaMin);
	        filter.setLunghezzaMax(lunghezzaMax);
	        filter.setPrezzoMin(prezzoMin);
	        filter.setPrezzoMax(prezzoMax);
	        filter.setSiglaContains(siglaContains);
	        filter.setUtente(utente);

	        List<TrenoVO> treni = trenoFilterServiceImpl.filterTreniVO(filter);
	        model.addAttribute("treni", treni);

	        return "filter"; 
	    }

	}



