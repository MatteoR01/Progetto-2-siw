package it.uniroma3.siw.spring.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.model.Tavoli;
import it.uniroma3.siw.spring.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	PrenotazioneRepository prenotazioneRepository;
	
	@Transactional
	public Prenotazione getPrenotazione(Long id) {
		Optional<Prenotazione> result = this.prenotazioneRepository.findById(id);
		return result.orElse(null);
	}

	@Transactional
	public void deletePrenotazione(Prenotazione prenotazione) {
		this.prenotazioneRepository.delete(prenotazione);
	}
	
	@Transactional
	public Prenotazione savePrenotazione(Prenotazione prenotazione) {
		return this.prenotazioneRepository.save(prenotazione);
	}
	
	@Transactional
	public List<Prenotazione> retrievePrenotazionesByTavoli(Tavoli tavolo) { 
		Iterable<Prenotazione> iterable = this.prenotazioneRepository.findByTavoli(tavolo);
		ArrayList<Prenotazione> list = new ArrayList<>();
		for(Prenotazione Prenotazione : iterable)
			list.add(Prenotazione);
		return list;
	} 
	
	@Transactional
	public List<Prenotazione> retrievePrenotazionesByBooker(Cliente booker) {
		Iterable<Prenotazione> iterable = this.prenotazioneRepository.findByBooker(booker);
		ArrayList<Prenotazione> list = new ArrayList<>();
		for(Prenotazione Prenotazione : iterable)
			list.add(Prenotazione);
		return list;
	}
	
	public List<Prenotazione> retrievePrenotazioneByOra(LocalDateTime oraPrenotazione) {
		Iterable<LocalDateTime> iterable = Prenotazione.getOraPrenotazione(oraPrenotazione);
		ArrayList<LocalDateTime> list = new ArrayList<>();
		for(LocalDate date : iterable)
			list.add(date);
		return list;
	}
}