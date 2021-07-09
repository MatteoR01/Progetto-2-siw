package it.uniroma3.siw.spring.model;

import java.time.LocalDate;
import javax.persistence.*;

@Entity
public class Prenotazione {
	
	public Prenotazione() {
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private LocalDate data;
	
	@Column(nullable = false)
	private int numeroPersone;
	
	@ManyToOne
	private Ristorante ristorante;
	
	@ManyToOne
	private Cliente clienti;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public int getNumeroPersone() {
		return numeroPersone;
	}

	public void setNumeroPersone(int numeroPersone) {
		this.numeroPersone = numeroPersone;
	}
}
