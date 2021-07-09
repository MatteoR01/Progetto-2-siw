package it.uniroma3.siw.spring.controller.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Ristorante;
import it.uniroma3.siw.spring.service.RistoranteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RistoranteValidator implements Validator{

    @Autowired
    private RistoranteService ristoranteService;

    private static final Logger logger = LoggerFactory.getLogger(RistoranteValidator.class);

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descrizione", "required");

        if(!errors.hasErrors()) {
            logger.debug("confermato. Valori non nulli!");
            if(this.ristoranteService.alreadyExists((Ristorante)o)) {
                logger.debug("è un duplicato!");
                errors.reject("duplicato");
            }
        }
    }
    
    @Override
    public boolean supports(Class<?> ClasseA) {
        return Ristorante.class.equals(ClasseA);
    }

    
}
