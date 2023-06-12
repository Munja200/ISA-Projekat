package FTN.isa.model.DTOs;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;

import FTN.isa.model.Address;
import FTN.isa.model.AdministratorCenter;
import FTN.isa.model.Center;
import FTN.isa.model.RadnoVreme;

public class CenterDTO {
	
	private long id;
	
	@Pattern(regexp="^[A-Z]{1}[a-z]{0,29}$")
	private String name;
	
	@Valid
	private Address address;
	
	private String description;
	
	@Min(0)
	@Max(10)
	private float averageRating;
	
	private boolean deleted;
	
	private List<RadnoVreme> radnoVreme;
	
	private List<AdministratorCenterDTO> admins;

	
	public CenterDTO() {}
	
	public CenterDTO(Center c) {
		super();
		this.id = c.getId();
		this.name = c.getName();
		this.address = c.getAddress();
		this.description = c.getDescription();
		this.averageRating = c.getAverageRating();
		this.deleted = c.isDeleted();
		this.radnoVreme = c.getRadnoVreme();
		
		List<AdministratorCenterDTO> lista = new ArrayList<>();
		
		for(AdministratorCenter ac : c.getAdministratorCenters()) {
			AdministratorCenterDTO acd = new AdministratorCenterDTO(ac);
			lista.add(acd);
		}
		
		this.admins = lista;
	}
	
	
	public CenterDTO(long id, String name, Address address, String description, float averageRating, boolean deleted, List<RadnoVreme> radnoVreme, List<AdministratorCenterDTO> admins ) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.description = description;
		this.averageRating = averageRating;
		this.deleted = deleted;
		this.radnoVreme = radnoVreme;
		this.admins = admins;
	}

	
	
	public List<RadnoVreme> getRadnoVreme() {
		return radnoVreme;
	}

	public void setRadnoVreme(List<RadnoVreme> radnoVreme) {
		this.radnoVreme = radnoVreme;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public  List<AdministratorCenterDTO> getAdmins() {
		return admins;
	}

	public void setAdmins( List<AdministratorCenterDTO> admins) {
		this.admins = admins;
	}
	
	
}
