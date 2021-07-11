package it.uniroma3.siw.spring.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Tavoli;

public interface TavoliRepository extends CrudRepository<Tavoli, Long>{
	
	public Optional<Tavoli> findByNumero(String numero);
	
	public List<Tavoli> findByPosti(Integer posti);
}
