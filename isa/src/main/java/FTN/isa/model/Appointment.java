package FTN.isa.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;


@Entity
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long Id;
		
	@Column(name = "start_time", nullable = false)
	private Date start;

	@Column(name = "end_time", nullable = false)
	private Date end;
	
	@Column(name = "enabled")
    private boolean enabled=true;
	
	@Column(name = "text", nullable = false)
	private String text;

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "registered_user_id", referencedColumnName = "id")
	private RegisteredUser user;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "center_id", referencedColumnName = "id")
	private Center center;

	@Version
	private Integer version;
	

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Appointment(long id, Date start, Date end, boolean enabled, String text, RegisteredUser user,
			Center center) {
		super();
		Id = id;
		this.start = start;
		this.end = end;
		this.enabled = enabled;
		this.text = text;
		this.user = user;
		this.center = center;
	}

	public Center getCenter() {
		return center;
	}

	public void setCenter(Center center) {
		this.center = center;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}


	public Appointment() {
		super();
	}


	


}
