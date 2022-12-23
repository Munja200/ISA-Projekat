package FTN.isa.model.DTOs;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import FTN.isa.model.Address;
import FTN.isa.model.Role;

public class AdminDTO {
	//@Pattern(regexp="^\\w{3,20}$")
	private String name;
	
	//@Pattern(regexp="^\\w{3,20}$")
	private String surname;
	
	//@Pattern(regexp="^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
	private String email;
	
	private String password;
	
	//@Pattern(regexp="^[\\+]{1}[\\(]{1}[0-9]{3}[\\)]{1}[0-9]{2}[\\/]{1}[0-9]{3}[\\-]{1}[0-9]{3,6}")
	private String phonNumber;
	
	//@Pattern(regexp="[0-9]{13}")
	private String jmbg;
	
	//@Pattern(regexp="\\bMale\\b|\\bFemale\\b|\\bOther\\b")
	private String gender;
	
	private String occupation;
	
	private String informationAboutCompany;

	private Date dateOfBirth;
	
	//@Pattern(regexp="\\bA\\b(\\+|\\-){1}|\\bB\\b(\\+|\\-){1}|\\bO\\b(\\+|\\-){1}|\\bAB\\b(\\+|\\-){1}")
	private String bloodType;//
	
	//@Valid
	private Address address;

	public AdminDTO() {
		super();
	}
	
	public AdminDTO(String name, String surname, String email, String password, String phonNumber,
			String jmbg, String gender, String occupation, String informationAboutCompany, Date dateOfBirth, List<Role> roles, boolean enabled,
			Timestamp lastPasswordResetDate, String bloodType, Address address) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phonNumber = phonNumber;
		this.jmbg = jmbg;
		this.gender = gender;
		this.occupation = occupation;
		this.informationAboutCompany = informationAboutCompany;
		this.dateOfBirth = dateOfBirth;
		this.bloodType = bloodType;
		this.address = address;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonNumber() {
		return phonNumber;
	}

	public void setPhonNumber(String phonNumber) {
		this.phonNumber = phonNumber;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getInformationAboutCompany() {
		return informationAboutCompany;
	}

	public void setInformationAboutCompany(String informationAboutCompany) {
		this.informationAboutCompany = informationAboutCompany;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
}
