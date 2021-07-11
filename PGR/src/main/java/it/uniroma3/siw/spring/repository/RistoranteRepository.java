package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Ristorante;

public interface RistoranteRepository extends CrudRepository<Ristorante, Long> {
	
	public List<Ristorante> findByNome(String nome);
}
