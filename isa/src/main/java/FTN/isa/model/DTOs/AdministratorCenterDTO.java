package FTN.isa.model.DTOs;

import javax.validation.Valid;

import FTN.isa.model.AdministratorCenter;
import FTN.isa.model.Center;
import FTN.isa.model.Person;

public class AdministratorCenterDTO {
	
	private long id;
	
	private boolean deleted;
	
	@Valid
	private Person person;
	
	private long centerId;

	public AdministratorCenterDTO() {}

	public AdministratorCenterDTO(long id, boolean deleted, Person person, long centerId) {
		super();
		this.id = id;
		this.deleted = deleted;
		this.person = person;
		this.centerId = centerId;
	}
	
	public AdministratorCenterDTO(AdministratorCenter ac) {
		super();
		this.id = ac.getId();
		this.person = ac.getPerson();
		this.centerId = ac.getCenter().getId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public long getCenterId() {
		return centerId;
	}

	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}
}
