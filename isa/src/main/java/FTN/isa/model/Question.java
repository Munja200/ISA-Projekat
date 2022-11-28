package FTN.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;

@Entity
public class Question {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@Column(name = "question", nullable = false)
	private String question;
	
	@Column(name = "exactValue", nullable = false)
	private boolean exactValue;
	
	public Question() {}
	
	public Question(int id, String question, boolean exactValue) {
		super();
		Id = id;
		this.question = question;
		this.exactValue = exactValue;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public boolean isExactValue() {
		return exactValue;
	}

	public void setExactValue(boolean exactValue) {
		this.exactValue = exactValue;
	}
	
	
}
