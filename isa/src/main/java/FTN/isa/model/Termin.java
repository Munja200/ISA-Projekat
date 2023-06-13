package FTN.isa.model;
import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PostLoad;
import javax.persistence.Transient;
import javax.validation.Valid;

@Entity
public class Termin {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long Id;
		
		@Column(name = "pocetak_termina")
		 private LocalDateTime pocetakTermina;
		
		@Column(name = "kraj_termina")
		private LocalDateTime krajTermina;
		
		@Column(name = "trajanje")
		private int trajanje;
		
		@Column(name = "korisnik_id")
		private Long korisnikId;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "center_id")
		private Center center;
		
	    @Transient
	    private Long centerId;
	    
	    @OneToOne(cascade = CascadeType.ALL)
		@JoinColumn(name = "report_id", referencedColumnName = "id")
	    @Valid
		private Report report;

	    
	    @PostLoad
	    private void populateCenterId() {
	        if (center != null) {
	            this.centerId = center.getId();
	        }
	    }

		public Termin() {
		}
		
		
		/*
		public Termin(TerminDTO terminDTO) {
		    Id = terminDTO.getId();
		    this.pocetakTermina = terminDTO.getPocetakTermina();
		    this.krajTermina = terminDTO.getKrajTermina();
		    this.trajanje = terminDTO.getTrajanje();
		    
		    Center center = new Center();
		    center.setId(terminDTO.getCenter());
		    this.center = center;
		}
		
		*/

		public Termin(Long id, LocalDateTime pocetakTermina, LocalDateTime krajTermina, int trajanje, Long korisnikId,
				Center center, Long centerId, @Valid Report report) {
			super();
			Id = id;
			this.pocetakTermina = pocetakTermina;
			this.krajTermina = krajTermina;
			this.trajanje = trajanje;
			this.korisnikId = korisnikId;
			this.center = center;
			this.centerId = centerId;
			this.report = report;
		}
		
		

		public Long getId() {
			return Id;
		}

		public void setId(Long id) {
			Id = id;
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

		public Long getKorisnikId() {
			return korisnikId;
		}

		public void setKorisnikId(Long korisnikId) {
			this.korisnikId = korisnikId;
		}

		public Center getCenter() {
			return center;
		}

		public void setCenter(Center center) {
			this.center = center;
		}

		public Long getCenterId() {
			return centerId;
		}

		public void setCenterId(Long centerId) {
			this.centerId = centerId;
		}

		public Report getReport() {
			return report;
		}

		public void setReport(Report report) {
			this.report = report;
		}

		

		
	


}
