package FTN.isa.model.DTOs;

import javax.persistence.Column;

public class BloodDTO {
	
	private long id;
	
	private String bloodType;
	
	private int quantity;
	
	public BloodDTO() {}

	public BloodDTO(long id, String bloodType, int quantity) {
		super();
		this.id = id;
		this.bloodType = bloodType;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	
	
	

}
