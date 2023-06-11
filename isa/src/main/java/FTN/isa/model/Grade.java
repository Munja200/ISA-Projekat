package FTN.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

}
