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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class AdministratorCenter {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "deleted")
	private boolean deleted;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	@OneToMany(mappedBy = "administratorCenter", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Examination> examinations = new HashSet<Examination>(); 
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "center_id", referencedColumnName = "id")
	private Center center;
	
	public AdministratorCenter(long id, boolean deleted, Person person, Center center) {
		super();
		Id = id;
		this.deleted = deleted;
		this.person = person;
		this.center = center;
	}

	public void addExam(Examination exam) {
		examinations.add(exam);
		exam.setAdministratorCenter(this);
	}

	public void removeExam(Examination exam) {
		examinations.remove(exam);
		exam.setAdministratorCenter(null);
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

	public Set<Examination> getExaminations() {
		return examinations;
	}

	public void setExaminations(Set<Examination> examinations) {
		this.examinations = examinations;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}
	
	
}
