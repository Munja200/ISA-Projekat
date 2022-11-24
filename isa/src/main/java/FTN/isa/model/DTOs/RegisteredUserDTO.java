package FTN.isa.model.DTOs;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;

public class RegisteredUserDTO {
	private long Id;
	
	private boolean deleted;
	
	private Person person;
	
	public RegisteredUserDTO() {}
	
	public RegisteredUserDTO(RegisteredUser registeredUser) {
		super();
		Id = registeredUser.getId();
		this.deleted =  registeredUser.isDeleted();
		this.person =  registeredUser.getPerson();
	}
	
	public RegisteredUserDTO(long id, boolean deleted, Person person) {
		super();
		Id = id;
		this.deleted = deleted;
		this.person = person;
	}
	
	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
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
}
