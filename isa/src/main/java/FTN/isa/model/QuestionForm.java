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

@Entity
public class QuestionForm {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;	
	
	@Column(name = "deleted")
	private boolean deleted;

	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "registered_user_id", referencedColumnName = "id")
	private RegisteredUser registeredUser;
	
	@Column(name = "date", nullable = false)
	private Date date;
	
	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	@JoinTable(name = "answering", joinColumns = @JoinColumn(name = "answer_question_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "question_form_id", referencedColumnName = "id"))
	private Set<AnswerQuestion> questions = new HashSet<AnswerQuestion>();

	public QuestionForm() {}
	
	public QuestionForm(int id, boolean deleted, RegisteredUser registeredUser, Date date) {
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

	public RegisteredUser getRegisteredUser() {
		return registeredUser;
	}

	public void setRegisteredUser(RegisteredUser registeredUser) {
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
