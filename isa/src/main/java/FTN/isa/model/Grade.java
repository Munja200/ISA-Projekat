package FTN.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Grade {
	
	


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "personId", nullable = false)
	private long personId;
	
	@Column(name = "centerId", nullable = false)
	private long centerId;
	
	
	@Min(0)
	@Max(10)
	@Column(name = "score", nullable = false)
	private float score;


	public Grade(long id, long personId, long centerId, @Min(0) @Max(10) float score) {
		super();
		Id = id;
		this.personId = personId;
		this.centerId = centerId;
		this.score = score;
	}


	public Grade(Grade grade) {
	    super();
	    this.Id = grade.getId();
	    this.personId = grade.getPersonId();
	    this.centerId = grade.getCenterId();
	    this.score = grade.getScore();
	}



	public Grade() {
		super();
	}


	public long getId() {
		return Id;
	}


	public void setId(long id) {
		Id = id;
	}


	public long getPersonId() {
		return personId;
	}


	public void setPersonId(long personId) {
		this.personId = personId;
	}


	public long getCenterId() {
		return centerId;
	}


	public void setCenterId(long centerId) {
		this.centerId = centerId;
	}


	public float getScore() {
		return score;
	}


	public void setScore(float score) {
		this.score = score;
	}
	
	

}
