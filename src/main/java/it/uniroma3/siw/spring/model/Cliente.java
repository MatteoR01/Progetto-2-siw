package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Cliente {
	
	public Cliente() {
		this.prenotazioniCliente =  new ArrayList<>();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cognome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	@Column(nullable = false)
	private String telefono;
	
	@OneToMany(mappedBy = "clienti")
	private List<Prenotazione> prenotazioniCliente;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioniCliente;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioniCliente = prenotazioni;
	}
}
