package it.uniroma3.siw.spring.start;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Proprietario;
import it.uniroma3.siw.spring.model.Tavoli;
import it.uniroma3.siw.spring.service.ClienteService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.ProprietarioService;

public class Inizializzazione implements ApplicationListener<ContextRefreshedEvent>  {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CredentialsService credentialService;
	
	@Autowired
	private ProprietarioService proprietarioService;
	
	@Autowired
	private TavoliService tavoliService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		Cliente cliente1 = new Cliente();
		cliente1.setNome("cliente1");
		cliente1.setCognome("cliente1");
		clienteService.saveCliente(cliente1);
		
		Credentials credentials1 = new Credentials();
		credentials1.setUsername("admin");
		credentials1.setRole("ADMIN");
		credentials1.setPassword("admin");
		credentials1.setCliente(cliente1);
		credentialService.saveCredentials2(credentials1);
		
		Cliente cliente2 = new Cliente();
		cliente2.setNome("cliente2");
		cliente2.setCognome("cliente2");
		clienteService.saveCliente(cliente2);
		
		Credentials credentials2 = new Credentials();
		credentials2.setUsername("cliente");
		credentials2.setPassword("cliente");
		credentials2.setRole("DEFAULT");
		credentials2.setCliente(cliente2);
		credentialService.saveCredentials2(credentials2);

		Proprietario proprietario1 = new Proprietario();
		proprietario1.setNome("Marco");
		proprietario1.setCognome("Giorgi");
		proprietario1.setEmail("m.giorgi@oscinnovation.com");
		proprietarioService.inserisci(proprietario1);
		
		Proprietario proprietario2=new Proprietario();
		proprietario2.setNome("Matteo");
		proprietario2.setCognome("Recchi");
		proprietario2.setEmail("mat.recchi@stud.uniroma3.it");
		proprietarioService.inserisci(proprietario2);
		
		Tavoli tavolo1 = new Tavoli();
		tavolo1.setPosti(2);
		tavoli
	}

}
