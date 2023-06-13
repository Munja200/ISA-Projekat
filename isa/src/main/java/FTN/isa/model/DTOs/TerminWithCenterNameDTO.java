package FTN.isa.model.DTOs;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import FTN.isa.model.Termin;

public class TerminWithCenterNameDTO {

	private Long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime pocetakTermina;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime krajTermina;
	private int trajanje;
	private Long center;
	private String centerName;
	private Long korisnikId;
		
	public TerminWithCenterNameDTO() {}
	
	public TerminWithCenterNameDTO(Termin t) {
		super();
		this.id = t.getId();
		this.pocetakTermina = t.getPocetakTermina();
		this.krajTermina = t.getKrajTermina();
		this.trajanje = t.getTrajanje();
		this.center = t.getCenter().getId();
		this.centerName = t.getCenter().getName();
		this.korisnikId = t.getKorisnikId();
	} 

	public TerminWithCenterNameDTO(Long id, LocalDateTime pocetakTermina, LocalDateTime krajTermina, int trajanje,
			Long center, String centerName, Long korisnikId) {
		super();
		this.id = id;
		this.pocetakTermina = pocetakTermina;
		this.krajTermina = krajTermina;
		this.trajanje = trajanje;
		this.center = center;
		this.centerName = centerName;
		this.korisnikId = korisnikId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getPocetakTermina() {
		return pocetakTermina;
	}

	public void setPocetakTermina(LocalDateTime pocetakTermina) {
		this.pocetakTermina = pocetakTermina;
	}

	public LocalDateTime getKrajTermina() {
		return krajTermina;
	}

	public void setKrajTermina(LocalDateTime krajTermina) {
		this.krajTermina = krajTermina;
	}

	public int getTrajanje() {
		return trajanje;
	}

	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}

	public Long getCenter() {
		return center;
	}

	public void setCenter(Long center) {
		this.center = center;
	}

	public String getCenterName() {
		return centerName;
	}

	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}

	public Long getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Long korisnikId) {
		this.korisnikId = korisnikId;
	}
	
}
