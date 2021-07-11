package it.uniroma3.siw.spring.controller.validator;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.PrenotazioneService;

@Component
public class PrenotazioneValidator implements Validator {

	@Autowired
	PrenotazioneService prenotazioneService;
	
	@Override
	public void validate(Object o, Errors errors) {
		Prenotazione prenotazione = (Prenotazione) o;
		LocalDateTime oraPrenotazione = prenotazione.getOraPrenotazione();
		
		if(oraPrenotazione.isEmpty() || oraPrenotazione==null)
			errors.rejectValue("checkin", "duplicate");
	}

	public boolean supports(Class<?> clazz) {
		return Cliente.class.equals(clazz);
	}
}