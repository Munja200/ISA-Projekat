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
public class RadnoVreme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column (name="vreme_otvaranja")
	private LocalDateTime vremeOtvaranja;
	
	@Column (name="vreme_zatvaranja")
	private LocalDateTime vremeZatvaranja;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "center_id", referencedColumnName = "id")
	@Valid
	private Center center;
	
	public RadnoVreme() {
	}

	public RadnoVreme(long id, LocalDateTime vremeOtvaranja, LocalDateTime vremeZatvaranja, Center center) {
		super();
		Id = id;
		this.vremeOtvaranja = vremeOtvaranja;
		this.vremeZatvaranja = vremeZatvaranja;
		this.center = center;
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

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	    
}
