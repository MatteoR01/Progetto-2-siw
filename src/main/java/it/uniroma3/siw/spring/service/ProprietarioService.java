package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Proprietario;
import it.uniroma3.siw.spring.model.Ristorante;
import it.uniroma3.siw.spring.repository.ProprietarioRepository;

@Service
public class ProprietarioService {
	@Autowired
	private ProprietarioRepository proprietarioRepository; 
	
	@Transactional
	public Proprietario inserisci(Proprietario Proprietario) {
		return proprietarioRepository.save(Proprietario);
	}

	@Transactional
	public List<Proprietario> trovaPerNome(String nome) {
		return proprietarioRepository.findByNome(nome);
	}
	
	@Transactional
	public List<Proprietario> trovaPerNomeOCognome(String nome, String cognome) {
		return proprietarioRepository.findByNomeOrCognome(nome, cognome);
	}
	
	@Transactional
	public List<Proprietario> tutti() {
		return (List<Proprietario>) proprietarioRepository.findAll();
	}

	@Transactional
	public Proprietario ProprietarioPerId(Long id) {
		Optional<Proprietario> optional = proprietarioRepository.findById(id);
		if (optional.isPresent())
			return optional.get();
		else 
			return null;
	}

	@Transactional
	public boolean alreadyExists(Proprietario Proprietario) {
		List<Proprietario> curatori = this.proprietarioRepository.findByNome(Proprietario.getNome());
		if (curatori.size() > 0)
			return true;
		else 
			return false;
	}

	@Transactional
	public void aggiungiRistorante(final Proprietario proprietario, final List<Ristorante> ristorante) {
		proprietario.addRistorante(ristorante);
		this.proprietarioRepository.save(proprietario);
	}
}
