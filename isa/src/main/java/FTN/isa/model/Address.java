package FTN.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@Min(0)
	@Max(1000)
	@Column(name = "latitude", nullable = false)
	private int latitude;
	
	@Min(0)
	@Max(1000)
	@Column(name = "longitude", nullable = false)
	private int longitude;
	
	@Pattern(regexp="^([A-Z]{1}[a-z]{0,20}\\s)*([A-Z]{1}[a-z]{0,20})$")
	@Column(name = "street", nullable = false)
	private String street;
	
	@Pattern(regexp="^[1-9A-Za-z\\/]+$")
	@Column(name = "number", nullable = false)
	private String number;
	
	@Pattern(regexp="^([A-Z]{1}[a-z]{0,20}\\s)*([A-Z]{1}[a-z]{0,20})$")
	@Column(name = "city", nullable = false)
	private String city;
	
	@Pattern(regexp="^([A-Z]{1}[a-z]{0,20}\\s)*([A-Z]{1}[a-z]{0,20})$")
	@Column(name = "country", nullable = false)
	private String country;
	
	
	public Address() {}
	

	public Address(long id, int latitude, int longitude, String street, String number, String city, String country) {
		super();
		Id = id;
		this.latitude = latitude;
		this.longitude = longitude;
		this.street = street;
		this.number = number;
		this.city = city;
		this.country = country;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public int getLatitude() {
		return latitude;
	}

	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}

	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	} 
	
	
}
