package it.uniroma3.siw.spring.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.model.Tavoli;

@Repository
public interface PrenotazioneRepository extends CrudRepository<Prenotazione, Long>{
	
	public List<Prenotazione> findByBooker(Cliente booker);
	
	public List<Prenotazione> findByTavoli(Tavoli tavolo);
	
	public List<Prenotazione> findByOra(LocalDateTime oraPrenotazione);
}
