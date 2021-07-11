package it.uniroma3.siw.spring.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

public class Prenotazione {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Tavoli tavolo;
	
	@Column
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	private LocalDateTime oraPrenotazione;
	
	@ManyToOne
	private Cliente booker;
	
	public Prenotazione() {
		
	}
	
	public Prenotazione(LocalDateTime oraPrenotazione) {
		this();
		this.oraPrenotazione = oraPrenotazione;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Tavoli getTavolo() {
		return tavolo;
	}

	public void setTavoli(Tavoli tavolo) {
		this.tavolo = tavolo;
	}

	public LocalDateTime getOraPrenotazione() {
		return oraPrenotazione;
	}

	public void setOraPrenotazione(LocalDateTime oraPrenotazione) {
		this.oraPrenotazione = oraPrenotazione;
	}

	public Cliente getBooker() {
		return booker;
	}

	public void setBooker(Cliente booker) {
		this.booker = booker;
	}
	
	@Override
	public String toString() {
		return "Prenotazione [id=" + id + ", tavolo=" + tavolo + ", ora della prenotazione=" + oraPrenotazione + ", booker=" + booker + "]";
	}
}
