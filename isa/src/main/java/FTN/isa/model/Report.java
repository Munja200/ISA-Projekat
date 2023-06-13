package FTN.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
public class Report {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "bloodType", nullable = false)
	private String bloodType;
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	public Report() {}

	public Report(long id, String bloodtype, String description, int quantity) {
		super();
		Id = id;
		this.bloodType = bloodtype;
		this.description = description;
		this.quantity = quantity;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
	


}
