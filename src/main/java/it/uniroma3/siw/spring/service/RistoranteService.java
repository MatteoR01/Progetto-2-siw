package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.repository.RistoranteRepository;
import it.uniroma3.siw.spring.model.Proprietario;
import it.uniroma3.siw.spring.model.Ristorante;

@Service
public class RistoranteService {

    @Autowired
    private RistoranteRepository ristoranteRepository;

    @Transactional
    public Ristorante inserisci(Ristorante ristorante) {
        return ristoranteRepository.save(ristorante);
    }

    @Transactional
    public List<Ristorante> tutti() {
        return (List<Ristorante>) ristoranteRepository.findAll();
    }

    @Transactional
    public Ristorante ristorantePerId(Long id) {
        Optional<Ristorante> optional = ristoranteRepository.findById(id);
        if(optional.isPresent()) return optional.get();
        else return null;
    }

    @Transactional
    public boolean alreadyExists(Ristorante ristorante) {
        List<Ristorante> ristoranti = this.ristoranteRepository.findByNome(ristorante.getNome());
        if(ristoranti.size() > 0) return true;
        else return false;
    }

    public void aggiugiProprietario(Ristorante ristorante, Proprietario proprietario) {
        ristorante.setProprietario(proprietario);
        this.ristoranteRepository.save(ristorante);
    }

    @Transactional
    public void eliminaRistorante(Ristorante ristorante) {
        ristoranteRepository.delete(ristorante);
    }
}