package FTN.isa.model.DTOs;

import java.util.Date;

import FTN.isa.model.Appointment;

public class AppointmentDTO {
	private long id;
	
	private String text;
	private Date start;
	private Date end;
	
	public AppointmentDTO() {}
	
	public AppointmentDTO(Appointment a) {
		super();
		this.id = a.getId();
		this.text = a.getText();
		this.start = a.getStart();
		this.end = a.getEnd();
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
	
	

}
