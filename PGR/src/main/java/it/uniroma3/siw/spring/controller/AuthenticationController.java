package it.uniroma3.siw.spring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.controller.session.SessionData;
import it.uniroma3.siw.spring.controller.validator.ClienteValidator;
import it.uniroma3.siw.spring.controller.validator.CredentialsValidator;
import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.service.CredentialsService;

@Controller
public class AuthenticationController {
	
	@Autowired
	CredentialsService credentialsService;
	
	@Autowired
	ClienteValidator clienteValidator;
	
	@Autowired
	CredentialsValidator credentialsValidator;
	
	@Autowired
	SessionData sessionData;
	
	@RequestMapping(value = {"/clienti/register"}, method = RequestMethod.GET)
	public String showRegisterForm(Model model) {
		model.addAttribute("clienteForm", new Cliente());
		model.addAttribute("credentialsForm", new Credentials());
		
		return registerCliente(null, null, null, null, null);
	}
	
	@RequestMapping(value = {"/clienti/register"}, method = RequestMethod.POST)
	public String registerCliente(@Valid @ModelAttribute("clienteForm") Cliente cliente,BindingResult clienteBindingResult, @Valid @ModelAttribute("credentialsForm") Credentials credentials, BindingResult credentialsBindingResult, Model model) {
		
		this.clienteValidator.validate(cliente, clienteBindingResult);
		this.credentialsValidator.validate(credentials, credentialsBindingResult);
		
		if(!clienteBindingResult.hasErrors() && !credentialsBindingResult.hasErrors()) {
			credentials.setCliente(cliente);
			credentialsService.saveCredentials(credentials);
			return "registrationSuccesful";
		}
		return "registerCliente";
	}
}
