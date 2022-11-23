package FTN.isa.dto;

import FTN.isa.model.Address;
import FTN.isa.model.Center;

public class CenterDTO {
	
	private long Id;
	private String name;
	private Address address;
	private String description;
	private float averageRating;
	private boolean deleted;
	
	
	public CenterDTO(Center c) {
		super();
		this.Id = c.getId();
		this.name = c.getName();
		this.address = c.getAddress();
		this.description = c.getDescription();
		this.averageRating = c.getAverageRating();
		this.deleted = c.isDeleted();
	}
	
	public CenterDTO(long id, String name, Address address, String description, float averageRating, boolean deleted) {
		super();
		Id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageRating = averageRating;
		this.deleted = deleted;
	}
	public long getId() {
		return Id;
	}
	public void setId(long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getAverageRating() {
		return averageRating;
	}
	public void setAverageRating(float averageRating) {
		this.averageRating = averageRating;
	}
	public boolean isDeleted() {
		return deleted;
	}
	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
