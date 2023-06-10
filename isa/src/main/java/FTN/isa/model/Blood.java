package FTN.isa.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity 
public class Blood {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Column(name = "bloodType", nullable = false)
	private String bloodType;
	
	@Column(name = "quantity", nullable = false)
	private int quantity;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "center_id", referencedColumnName = "id")
	private Center center;

	public Blood() {}
	
	public Blood(long id, String bloodType, int quantity, Center center) {
		super();
		Id = id;
		this.bloodType = bloodType;
		this.quantity = quantity;
		this.center = center;
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	
	

}
