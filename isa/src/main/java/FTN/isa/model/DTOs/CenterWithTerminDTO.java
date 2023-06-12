package FTN.isa.model.DTOs;


public class CenterWithTerminDTO {

	private Long id;
	
	private CenterDTO centerDTO;
	
	private TerminDTO terminDTO;

	
	public CenterWithTerminDTO() {
	}
	

	public CenterWithTerminDTO(Long id, CenterDTO centerDTO, TerminDTO terminDTO) {
		super();
		this.id = id;
		this.centerDTO = centerDTO;
		this.terminDTO = terminDTO;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public CenterDTO getCenterDTO() {
		return centerDTO;
	}


	public void setCenterDTO(CenterDTO centerDTO) {
		this.centerDTO = centerDTO;
	}


	public TerminDTO getTerminDTO() {
		return terminDTO;
	}


	public void setTerminDTO(TerminDTO terminDTO) {
		this.terminDTO = terminDTO;
	}


}
