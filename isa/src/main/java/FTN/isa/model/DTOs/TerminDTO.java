package FTN.isa.model.DTOs;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import FTN.isa.model.QuestionForm;
import FTN.isa.model.Report;
import FTN.isa.model.Termin;

public class TerminDTO {

	private Long id;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime pocetakTermina;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime krajTermina;
	private int trajanje;
	private Long center;
	private Long korisnikId;
	private Report report;
  	private QuestionForm questionForm;

		
	public TerminDTO() {}
	
	public TerminDTO(Long id, LocalDateTime pocetakTermina, LocalDateTime krajTermina, int trajanje, Long center,
			Long korisnikId, Report report, QuestionForm questionForm) {
		super();
		this.id = id;
		this.pocetakTermina = pocetakTermina;
		this.krajTermina = krajTermina;
		this.trajanje = trajanje;
		this.center = center;
		this.korisnikId = korisnikId;
		this.report = report;
		this.questionForm = questionForm;

	}
	
	
	public TerminDTO(Termin t) {
		super();
		this.id = t.getId();
		this.pocetakTermina = t.getPocetakTermina();
		this.krajTermina = t.getKrajTermina();
		this.trajanje = t.getTrajanje();
		this.center = t.getCenter().getId();
		this.korisnikId = t.getKorisnikId();
		this.report = t.getReport();
		this.questionForm = t.getQuestionForm();
	} 
	
	

	public Long getKorisnikId() {
		return korisnikId;
	}

	public void setKorisnikId(Long korisnikId) {
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

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}

	public QuestionForm getQuestionForm() {
		return questionForm;
	}

	public void setQuestionForm(QuestionForm questionForm) {
		this.questionForm = questionForm;
	}
	
	
	
	
	
}
