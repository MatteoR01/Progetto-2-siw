package it.uniroma3.siw.spring.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.service.ClienteService;

@Component
public class ClienteValidator implements Validator{
	
	final Integer MAX_NAME_LENGTH = 50;
	final Integer MIN_NAME_LENGTH = 2;
	
	@Autowired
	ClienteService clienteService;
	
	@Override
	public void validate(Object o, Errors errors) {
		
		Cliente cliente = (Cliente) o;
		String nome =  cliente.getNome().trim();
		String cognome = cliente.getCognome().trim();
		
		if (nome.isEmpty())
            errors.rejectValue("nome", "required");
        else if (nome.length() < MIN_NAME_LENGTH || nome.length() > MAX_NAME_LENGTH)
            errors.rejectValue("nome", "size");

        if (cognome.isEmpty())
            errors.rejectValue("cognome", "required");
        else if (cognome.length() < MIN_NAME_LENGTH || cognome.length() > MAX_NAME_LENGTH)
            errors.rejectValue("cognome", "size");
        System.out.println("Questo è l'errore che ho trovato!"+ errors);
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Cliente.class.equals(clazz);
    }
}
