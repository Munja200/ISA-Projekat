package FTN.isa.model.DTOs;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import FTN.isa.model.Address;

public class RegisteredUserUpdateDTO {
    
	private long Id;
    private String name;
    private String surname;
    private String phonNumber;
    private String jmbg;
    private String gender;
    private String occupation;
    private String informationAboutCompany;
    private Date dateOfBirth;
    private String bloodType;
    private Address address;
    
    public RegisteredUserUpdateDTO() { }
    
	public RegisteredUserUpdateDTO(long id, String name, String surname, String phonNumber, String jmbg, String gender,
			String occupation, String informationAboutCompany, Date dateOfBirth, String bloodType, Address address) {
		super();
		Id = id;
		this.name = name;
		this.surname = surname;
		this.phonNumber = phonNumber;
		this.jmbg = jmbg;
		this.gender = gender;
		this.occupation = occupation;
		this.informationAboutCompany = informationAboutCompany;
		this.dateOfBirth = dateOfBirth;
		this.bloodType = bloodType;
		this.address = address;
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
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
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
