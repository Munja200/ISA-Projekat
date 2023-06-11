package FTN.isa.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class RadnoVreme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column (name="vreme_otvaranja")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime vremeOtvaranja;
	
	@Column (name="vreme_zatvaranja")
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime vremeZatvaranja;
	
	public RadnoVreme() {
	}

	public RadnoVreme(long id, LocalDateTime vremeOtvaranja, LocalDateTime vremeZatvaranja, Center center) {
		super();
		Id = id;
		this.vremeOtvaranja = vremeOtvaranja;
		this.vremeZatvaranja = vremeZatvaranja;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public LocalDateTime getVremeOtvaranja() {
		return vremeOtvaranja;
	}

	public void setVremeOtvaranja(LocalDateTime vremeOtvaranja) {
		this.vremeOtvaranja = vremeOtvaranja;
	}

	public LocalDateTime getVremeZatvaranja() {
		return vremeZatvaranja;
	}

	public void setVremeZatvaranja(LocalDateTime vremeZatvaranja) {
		this.vremeZatvaranja = vremeZatvaranja;
	}
	    
}
