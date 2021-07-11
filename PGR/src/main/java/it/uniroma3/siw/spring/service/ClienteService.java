package it.uniroma3.siw.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Cliente;
import it.uniroma3.siw.spring.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
    public Cliente getCliente(Long id) {
        Optional<Cliente> result = this.clienteRepository.findById(id);
        return result.orElse(null);
    }
	
	@Transactional
    public Cliente saveCliente(Cliente Cliente) {
        return this.clienteRepository.save(Cliente);
    }

    @Transactional
    public List<Cliente> getAllClientes() {
        List<Cliente> result = new ArrayList<>();
        Iterable<Cliente> iterable = this.clienteRepository.findAll();
        for(Cliente Cliente : iterable)
            result.add(Cliente);
        return result;
    }
}
