package FTN.isa.model.DTOs;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import FTN.isa.model.Person;

@Entity
public class PersonDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name", nullable = false)
	@Pattern(regexp="^\\w{3,20}$")
	private String name;
	
	@Pattern(regexp="^\\w{3,20}$")
	@Column(name = "surname", nullable = false)
	private String surname;
	
	public PersonDTO() {}
	
	public PersonDTO(Person person) {
		super();
		id = person.getId();
		this.name = person.getName();
		this.surname = person.getSurname();
	}
	
	public PersonDTO(long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
