package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import it.uniroma3.siw.spring.model.Tavoli;
import it.uniroma3.siw.spring.repository.TavoliRepository;

public class TavoliService {
	
	@Autowired
	private TavoliRepository tavoliRepository;
	
	@Transactional
	public Tavoli getTavolo(Long id) {
		Optional<Tavoli> result = this.tavoliRepository.findById(id);
		return result.orElse(null);
	}
	
	@Transactional
	public Tavoli getTavolo(String numero) {
		Optional<Tavoli> result = this.tavoliRepository.findByNumero(numero);
		return result.orElse(null);
	}
	
	@Transactional
	public Tavoli saveTavolo(Tavoli Tavoli) {
		return this.tavoliRepository.save(Tavoli);
	}
	
	@Transactional
	public List<Tavoli> findAllTavoli() {
		Iterable<Tavoli> iterable = this.tavoliRepository.findAll();
		ArrayList<Tavoli> list = new ArrayList<>();
		for(Tavoli tavoli : iterable)
			list.add(tavoli);
		return list;
	}
	
	public List<Tavoli> retrieveTavoliByPosti(Integer posti) {
		Iterable<Tavoli> iterable = this.tavoliRepository.findByPosti(posti);
		ArrayList<Tavoli> list = new ArrayList<>();
		for(Tavoli tavoli : iterable) 
			list.add(tavoli);
		return list;
	}
}
