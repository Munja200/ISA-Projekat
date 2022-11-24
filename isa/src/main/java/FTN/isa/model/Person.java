package FTN.isa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "password", unique = true, nullable = false)
	private String password;
	
	@Column(name = "phonNumber", unique = true, nullable = false)
	private String phonNumber;
	
	@Column(name = "jmbg", unique = true, nullable = false)
	private String jmbg;
	
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "occupation", nullable = false)
	private String occupation;
	
	@Column(name = "informationAboutCompany", nullable = false)
	private String informationAboutCompany;
	
	@Column(name = "dateOfBirth", nullable = false)
	private Date dateOfBirth;
	
	@Column(name = "role", nullable = false)
	private Role role;
	
	@Column(name = "bloodType", nullable = false)	
	private String bloodType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;
	
	public Person() {}
	
	public Person(String name, String surname, String email, String password, String phonNumber, String jmbg,
			String gender, String occupation, String informationAboutCompany, Date dateOfBirth, Role role,
			String bloodType, Address address) {
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
		this.role = role;
		this.bloodType = bloodType;
		this.address = address;
	}
	
	public Person(long id, String name, String surname, String email, String password, String phonNumber, String jmbg,
			String gender, String occupation, String informationAboutCompany, Date dateOfBirth, Role role,
			String bloodType, Address address) {
		super();
		Id = id;
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
		this.role = role;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
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
