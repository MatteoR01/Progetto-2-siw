package it.uniroma3.siw.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Proprietario;

public interface ProprietarioRepository extends CrudRepository<Proprietario, Long>{
	
	public List<Proprietario> findByNome(String nome);
	public List<Proprietario> findByNomeOrCognome(String nome, String cognome);
}
