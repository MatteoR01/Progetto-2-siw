package it.uniroma3.siw.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Tavoli {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private boolean prenotato;
	
	@Column(nullable = false, length = 3)
	private String numero;
	
	@Column(nullable = false)
	private int posti;
	
	@ManyToOne
	private Ristorante ristorante;
	
	@ManyToOne
	private Cliente clienti;
	
	private List<Prenotazione> prenotazioni;
	

	public Tavoli() {
		this.prenotazioni = new ArrayList<>();
	}
	
	public Tavoli(String numero, Integer posti, boolean prenotato) {
		this();
		this.numero = numero;
		this.posti = posti;
		this.prenotato = prenotato;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isPrenotato() {
		return prenotato;
	}

	public void setPrenotato(boolean prenotato) {
		this.prenotato = prenotato;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getPosti() {
		return posti;
	}

	public void setPosti(int posti) {
		this.posti = posti;
	}

	public Ristorante getRistorante() {
		return ristorante;
	}

	public void setRistorante(Ristorante ristorante) {
		this.ristorante = ristorante;
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}


}
