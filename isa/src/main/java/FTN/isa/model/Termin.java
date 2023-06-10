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
import javax.validation.Valid;
@Entity
public class Termin {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long Id;
		
		@Column(name = "pocetak_termina")
		 private LocalDateTime pocetakTermina;
		
		@Column(name = "kraj_termina")
		private LocalDateTime krajTermina;
		
		@Column(name = "trajanje")
		private int trajanje;
		
		@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
		@JoinColumn(name = "center_id", referencedColumnName = "id")
		@Valid
		private Center center;
		

		public Termin() {
		}

		public Termin(long id, LocalDateTime pocetakTermina, LocalDateTime krajTermina, int trajanje,
				@Valid Center center) {
			super();
			Id = id;
			this.pocetakTermina = pocetakTermina;
			this.krajTermina = krajTermina;
			this.trajanje = trajanje;
			this.center = center;
		}

		public long getId() {
			return Id;
		}

		public void setId(long id) {
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

		public Center getCenter() {
			return center;
		}

		public void setCenter(Center center) {
			this.center = center;
		}


}
