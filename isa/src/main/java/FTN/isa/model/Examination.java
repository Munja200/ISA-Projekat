package FTN.isa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.Valid;

@Entity
public class Examination {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "administrator_center_id")
	@Valid
	private AdministratorCenter administratorCenter;
	
	@Column(name = "deleted")
	private boolean deleted;

	public Examination() {}
	
	public Examination(long id, AdministratorCenter administratorCenter) {
		super();
		Id = id;
		this.administratorCenter = administratorCenter;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public AdministratorCenter getAdministratorCenter() {
		return administratorCenter;
	}

	public void setAdministratorCenter(AdministratorCenter administratorCenter) {
		this.administratorCenter = administratorCenter;
	}
	
	//private Set<MedicalEquipment> medicalEquipments = new HashSet<>();
	
	//private Set<Report> reports = new HashSet<>();
	
	

}
