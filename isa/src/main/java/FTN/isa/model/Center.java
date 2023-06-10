package FTN.isa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import FTN.isa.model.DTOs.CenterDTO;

@Entity
public class Center {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "name", nullable = false)
	@Pattern(regexp="^[A-Z]{1}[a-z]{0,29}$")
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Min(0)
	@Max(10)
	@Column(name = "averageRating", nullable = false)
	private float averageRating;
	
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Valid
	private Set<AdministratorCenter> administratorCenters = new HashSet<AdministratorCenter>();
	
	@Column(name = "deleted")
	private boolean deleted;
	//private Set<Blood> bloods = new HashSet<>();
	
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "radno_vreme")
	private Set<RadnoVreme> radnoVreme;

	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Column(name = "termini")
	private Set<Termin> termini;

	public Center() {}
	
	public Center(CenterDTO centerDTO) {
		Id = centerDTO.getId();
		this.name = centerDTO.getName();
		this.address = centerDTO.getAddress();
		this.description = centerDTO.getDescription();
		this.averageRating = centerDTO.getAverageRating();
		this.deleted = centerDTO.isDeleted();
	}
	
	public Center(long id, String name, Address address, String description, float averageRating, boolean deleted) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageRating = averageRating;
		this.deleted = deleted;

	}
	

	public Center(long id, @Pattern(regexp = "^[A-Z]{1}[a-z]{0,29}$") String name, Address address, String description,
			float averageRating, Set<AdministratorCenter> administratorCenters, boolean deleted,
			Set<RadnoVreme> radnoVreme, Set<Termin> termini) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageRating = averageRating;
		this.administratorCenters = administratorCenters;
		this.deleted = deleted;
		this.radnoVreme = radnoVreme;
		this.termini = termini;
	}

	public void addAdministratorCenter(AdministratorCenter exam) {
		administratorCenters.add(exam);
		exam.setCenter(this);
	}

	public void removeAdministratorCenter(AdministratorCenter exam) {
		administratorCenters.remove(exam);
		exam.setCenter(null);
	}

	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public float getAverageRating() {
		return averageRating;
	}


	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}


	public Set<AdministratorCenter> getAdministratorCenters() {
		return administratorCenters;
	}


	public void setAdministratorCenters(Set<AdministratorCenter> administratorCenters) {
		this.administratorCenters = administratorCenters;
	}


	public boolean isDeleted() {
		return deleted;
	}


	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Set<RadnoVreme> getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(Set<RadnoVreme> radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public Set<Termin> getTermini() {
		return termini;
	}

	public void setTermini(Set<Termin> termini) {
		this.termini = termini;
	}
	
	
	
}
