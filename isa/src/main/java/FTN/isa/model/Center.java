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

import FTN.isa.model.DTOs.CenterDTO;

@Entity
public class Center {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "averageRating", nullable = false)
	private float averageRating;
	
	@OneToMany(mappedBy = "center", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AdministratorCenter> administratorCenters = new HashSet<AdministratorCenter>();
	

	@Column(name = "deleted")
	private boolean deleted;
	//private Set<Blood> bloods = new HashSet<>();

	
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
	
}
