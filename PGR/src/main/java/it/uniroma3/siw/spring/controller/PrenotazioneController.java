package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.uniroma3.siw.spring.repository.TavoliRepository;
import it.uniroma3.siw.spring.service.ClienteService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.TavoliService;


@Controller
public class PrenotazioneController {
	
	@Autowired
	TavoliRepository tavoliRepository;
	
	@Autowired
	TavoliService tavoliService;
	
	@Autowired
	ClienteService clienteService;
	
	@Autowired
	CredentialsService credentialsService;
}
