package FTN.isa.model.DTOs;

import javax.persistence.JoinColumn;
import javax.validation.Valid;

import FTN.isa.model.Complaint;

public class ComplaintDTO {
	
	private long id;
	
	@Valid
	private PersonDTO person;
	
	private String complaint;
	
	private String answer;

	public ComplaintDTO() {
		super();
	}
	
	public ComplaintDTO(Complaint complaint) {
		super();
		id = complaint.getId();
		this.person = new PersonDTO(complaint.getPerson());
		this.complaint = complaint.getComplaint();
		this.answer = complaint.getAnswer();
	}
	
	public ComplaintDTO(long id, @Valid PersonDTO personDTO, String complaint, String answer) {
		super();
		this.id = id;
		this.person = personDTO;
		this.complaint = complaint;
		this.answer = answer;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PersonDTO getPerson() {
		return person;
	}

	public void setPerson(PersonDTO person) {
		this.person = person;
	}

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}
}
