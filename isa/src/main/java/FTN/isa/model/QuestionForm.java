package FTN.isa.model;

import java.util.Date;
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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class QuestionForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;	
	
	@Column(name = "deleted")
	private boolean deleted;

	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "registered_user_id", referencedColumnName = "id")
	private Person registeredUser;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<AnswerQuestion> questions = new HashSet<AnswerQuestion>();
	
	public QuestionForm() {}
	
	public QuestionForm(int id, boolean deleted, Person registeredUser, Date date, Set<AnswerQuestion> questions) {
		super();
		Id = id;
		this.deleted = deleted;
		this.registeredUser = registeredUser;
		this.date = date;
		this.questions = questions;
	}

	public QuestionForm(int id, boolean deleted, Person registeredUser, Date date) {
		super();
		Id = id;
		this.deleted = deleted;
		this.registeredUser = registeredUser;
		this.date = date;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Person getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(Person registeredUser) {
		this.registeredUser = registeredUser;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Set<AnswerQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(Set<AnswerQuestion> questions) {
		this.questions = questions;
	}
	
	
}
