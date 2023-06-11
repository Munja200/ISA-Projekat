package FTN.isa.model;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.model.DTOs.PersonDTO;


@Entity
public class Person implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "name", nullable = false)
	@Pattern(regexp="^\\w{3,20}$")
	private String name;
	
    @Column(name = "username")
    private String username;
	
	@Column(name = "surname", nullable = false)
	private String surname;
	
	@Pattern(regexp="^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	//@JsonIgnore
	@Column(name = "password", unique = false, nullable = false)
	private String password;
	
	@Pattern(regexp="^[\\+]{1}[\\(]{1}[0-9]{3}[\\)]{1}[0-9]{2}[\\/]{1}[0-9]{3}[\\-]{1}[0-9]{4,6}")
	@Column(name = "phonNumber", unique = true, nullable = false)
	private String phonNumber;
	
	@Pattern(regexp="[0-9]{13}")
	@Column(name = "jmbg", unique = true, nullable = false)
	private String jmbg;
	
	@Pattern(regexp="\\bMale\\b|\\bFemale\\b|\\bOther\\b")
	@Column(name = "gender", nullable = false)
	private String gender;
	
	@Column(name = "occupation", nullable = false)
	private String occupation;
	
	@Column(name = "informationAboutCompany", nullable = false)
	private String informationAboutCompany;
	
	@Column(name = "dateOfBirth", nullable = false)
	private Date dateOfBirth;
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<Role> roles;
	
    @Column(name = "enabled")
    private boolean enabled=true;

    @Column(name = "last_password_reset_date")
    private Timestamp lastPasswordResetDate;
	
	@Pattern(regexp="\\bA\\b(\\+|\\-){1}|\\bB\\b(\\+|\\-){1}|\\bO\\b(\\+|\\-){1}|\\bAB\\b(\\+|\\-){1}")
	@Column(name = "bloodType", nullable = false)	
	private String bloodType;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	@Valid
	private Address address;
	
	@Column (name="isFirstLogin")
    private boolean firstLogin;
	
	public Person() {}
	
	
	
	public Person(long id, @Pattern(regexp = "^\\w{3,20}$") String name, String username, String surname,
			@Pattern(regexp = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$") String email, String password,
			@Pattern(regexp = "^[\\+]{1}[\\(]{1}[0-9]{3}[\\)]{1}[0-9]{2}[\\/]{1}[0-9]{3}[\\-]{1}[0-9]{4,6}") String phonNumber,
			@Pattern(regexp = "[0-9]{13}") String jmbg,
			@Pattern(regexp = "\\bMale\\b|\\bFemale\\b|\\bOther\\b") String gender, String occupation,
			String informationAboutCompany, Date dateOfBirth, List<Role> roles, boolean enabled,
			Timestamp lastPasswordResetDate,
			@Pattern(regexp = "\\bA\\b(\\+|\\-){1}|\\bB\\b(\\+|\\-){1}|\\bO\\b(\\+|\\-){1}|\\bAB\\b(\\+|\\-){1}") String bloodType,
			@Valid Address address, boolean firstLogin) {
		super();
		Id = id;
		this.name = name;
		this.username = username;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.phonNumber = phonNumber;
		this.jmbg = jmbg;
		this.gender = gender;
		this.occupation = occupation;
		this.informationAboutCompany = informationAboutCompany;
		this.dateOfBirth = dateOfBirth;
		this.roles = roles;
		this.enabled = enabled;
		this.lastPasswordResetDate = lastPasswordResetDate;
		this.bloodType = bloodType;
		this.address = address;
		this.firstLogin = firstLogin;
	}



	public Person(PersonDTO personDTO) {
		Id = personDTO.getId();
		this.name = personDTO.getName();
		this.surname = personDTO.getSurname();
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
	
    public Timestamp getLastPasswordResetDate() {
        return lastPasswordResetDate;
    }

    public void setLastPasswordResetDate(Timestamp lastPasswordResetDate) {
        this.lastPasswordResetDate = lastPasswordResetDate;
    }

	public void setPassword(String password) {
		Timestamp now = new Timestamp(new Date().getTime());
        this.setLastPasswordResetDate(now);
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
	
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    
    public List<Role> getRoles() {
       return this.roles;
    }
    
    public String getRolesString() {
    	String roles = "";
    	for (Role role : this.roles) {
			roles += role.getName() + "";
		}
       return roles;
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

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@JsonIgnore
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

	public boolean isFirstLogin() {
		return firstLogin;
	}

	public void setFirstLogin(boolean firstLogin) {
		this.firstLogin = firstLogin;
	}
	
}
