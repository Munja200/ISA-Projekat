package FTN.isa.modelDTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import FTN.isa.model.Address;

public class RegisteredUserDTO {

	 private long id;
	  private String name;
	  private String surname;
	  private String password;
	  @JsonProperty
	  private Address address;
	  private String jmbg;
	  private String occupation;
	  private String gender;
	  
	public RegisteredUserDTO(String name, String surname, String password, Address address, String jmbg,
			String occupation, String gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.address = address;
		this.jmbg = jmbg;
		this.occupation = occupation;
		this.gender = gender;
	}

	public RegisteredUserDTO(long id, String name, String surname, String password, Address address, String jmbg,
			String occupation, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.address = address;
		this.jmbg = jmbg;
		this.occupation = occupation;
		this.gender = gender;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
