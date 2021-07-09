package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import it.uniroma3.siw.spring.controller.validator.CredentialsValidator;
import it.uniroma3.siw.spring.service.ClienteService;
import it.uniroma3.siw.spring.service.CredentialsService;

@Controller
public class AuthenticationController {

    @Autowired
    private CredentialsService credentialsService;

    @Autowired 
    private ClienteService userService;

    @Autowired
    private CredentialsValidator credentialsValidator;
}