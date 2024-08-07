package com.idm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.idm.entity.Utente;
import com.idm.service.UtenteService;

@RestController
@RequestMapping("/utente")

public class UtenteRestJsonController {
	
	@Autowired
	UtenteService utenteService;
	
	
	@GetMapping(path = {"/all"}, produces = {"application/json"})
	@ResponseBody
	public List<Utente> getAll(){
		return utenteService.getAllUsers();
	}

}
