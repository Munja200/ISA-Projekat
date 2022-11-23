package FTN.isa.model.DTOs;

import FTN.isa.model.Center;
import FTN.isa.model.Person;

public class AdministratorCenterDTO {
	
	private long id;
	
	private boolean deleted;
	
	private Person person;
	
	private String centerId;

	public AdministratorCenterDTO() {}

	public AdministratorCenterDTO(long id, boolean deleted, Person person, String centerId) {
		super();
		this.id = id;
		this.deleted = deleted;
		this.person = person;
		this.centerId = centerId;
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

	public String getCenterId() {
		return centerId;
	}

	public void setCenterId(String centerId) {
		this.centerId = centerId;
	}
}
