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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
public class AnswerQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name = "answer", nullable = false)
	private boolean answer;

	@Column(name = "deleted")
	private boolean deleted;
	
	//@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	//@Valid
	//private QuestionForm questionForm;
	
	//@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.DETACH})
	//@JoinTable(name = "answering", joinColumns = @JoinColumn(name = "answer_question_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "question_form_id", referencedColumnName = "id"))
	//@Valid
	//private Set<QuestionForm> questions = new HashSet<QuestionForm>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "question_id")
	@Valid
	private Question question;
	
	public AnswerQuestion() {}
	
	public AnswerQuestion(int id, boolean answer, Question question) {
		super();
		Id = id;
		this.answer = answer;
		this.question = question;
	}
 
	public AnswerQuestion(int id, boolean answer, boolean deleted, Question question) {
		super();
		Id = id;
		this.answer = answer;
		this.deleted = deleted;
		this.question = question;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public boolean isAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
	
}
