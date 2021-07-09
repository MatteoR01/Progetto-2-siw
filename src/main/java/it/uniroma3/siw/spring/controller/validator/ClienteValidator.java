package it.uniroma3.siw.spring.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Cliente;

import org.springframework.stereotype.Component;

@Component
public class ClienteValidator implements Validator{
    final Integer MAX_NAME_LENGTH = 20;
    final Integer MIN_NAME_LENGTH = 2;

    @Override
    public void validate(Object o, Errors errors) {
        Cliente user = (Cliente)o;
        String nome = user.getNome().trim();
        String cognome = user.getCognome().trim();

        if(nome.isEmpty())
            errors.rejectValue("nome", "required");
        else if(nome.length() < MIN_NAME_LENGTH || nome.length() > MAX_NAME_LENGTH)
            errors.rejectValue("nome", "size");
        
        if(cognome.isEmpty())
            errors.rejectValue("nome", "required");
        else if(cognome.length() < MIN_NAME_LENGTH || cognome.length() > MAX_NAME_LENGTH)
            errors.rejectValue("cognome", "size");
    }

    @Override
    public boolean supports(Class<?> classB) {
        return Cliente.class.equals(classB);
    }
}
