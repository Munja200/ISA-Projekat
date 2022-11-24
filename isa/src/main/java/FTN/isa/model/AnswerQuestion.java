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

@Entity
public class AnswerQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name = "answer", nullable = false)
	private boolean answer;

	@Column(name = "deleted")
	private boolean deleted;
	
	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	private QuestionForm questionForm;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "question_id")
	private Question question;
	
	public AnswerQuestion() {}
	
	public AnswerQuestion(int id, boolean answer, Question question) {
		super();
		Id = id;
		this.answer = answer;
		this.question = question;
	}
 
	public AnswerQuestion(int id, boolean answer, boolean deleted, QuestionForm questions, Question question) {
		super();
		Id = id;
		this.answer = answer;
		this.deleted = deleted;
		this.questionForm = questions;
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

	public QuestionForm getQuestions() {
		return questionForm;
	}

	public void setQuestions(QuestionForm questions) {
		this.questionForm = questions;
	}
	
	
	
}
