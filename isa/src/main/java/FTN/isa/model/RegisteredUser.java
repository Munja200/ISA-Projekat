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

import FTN.isa.model.DTOs.RegisteredUserUpdateDTO;

@Entity
public class RegisteredUser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "deleted")
	private boolean deleted;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	@OneToMany(mappedBy = "registeredUser", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<QuestionForm> questionForms = new HashSet<QuestionForm>();

	
	public RegisteredUser() {}
	
	public RegisteredUser(long id, boolean deleted, Person person) {
		super();
		Id = id;
		this.deleted = deleted;
		this.person= person;
	}
	
	public RegisteredUser(RegisteredUserUpdateDTO reg) {
		super();
		this.Id = reg.getId();
		this.person = new Person();
		this.person.setName(reg.getName());
		this.person.setSurname(reg.getSurname());
		this.person.setPhonNumber(reg.getPhonNumber());
		this.person.setJmbg(reg.getJmbg());
		this.person.setGender(reg.getGender());
		this.person.setOccupation(reg.getOccupation());
		this.person.setInformationAboutCompany(reg.getInformationAboutCompany());
		this.person.setDateOfBirth(reg.getDateOfBirth());
		this.person.setBloodType(reg.getBloodType());
		this.person.setAddress(reg.getAddress());
	}

	public void addQuestionForm(QuestionForm exam) {
		questionForms.add(exam);
		exam.setRegisteredUser(this.person);
	}

	public void removeQuestionForm(QuestionForm exam) {
		questionForms.remove(exam);
		exam.setRegisteredUser(null);
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

	public Set<QuestionForm> getQuestionForms() {
		return questionForms;
	}

	public void setQuestionForms(Set<QuestionForm> questionForms) {
		this.questionForms = questionForms;
	}
	
	//private Set<Complaint> complaints = new HashSet<>();
	
	//private MedicalRecord medicalRecord;
	
	//private Set<Appointment> appointments = new HashSet<>();
	
	//private Set<Review> reviews = new HashSet<>();
	
	
	
}
