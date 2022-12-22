package FTN.isa.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Complaint;
import FTN.isa.model.Person;
import FTN.isa.model.DTOs.ComplaintDTO;
import FTN.isa.service.ComplaintService;
import FTN.isa.service.PersonService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/complaint")
public class ComplaintController {
	@Autowired
	private ComplaintService complaintService;
	@Autowired
	private PersonService personService;
	
	@Operation(summary = "Get all complaints", description = "Get all complaints", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					     content = @Content(mediaType = "application/json", 
					     array = @ArraySchema(schema = @Schema(implementation = ComplaintDTO.class))))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/allByPage/{pageID}", method = RequestMethod.GET)
	public ResponseEntity<List<ComplaintDTO>> getAllByPage(@Parameter(name="pageID", description = "Page number", required = true) @PathVariable("pageID") int pageID) {
		Pageable pageable =  PageRequest.of(pageID, 10);
		Page<Complaint> complaints = complaintService.findAll(pageable);
		List<ComplaintDTO> complaintsDTO =  new ArrayList<ComplaintDTO>();
		for(Complaint c : complaints)
			complaintsDTO.add(new ComplaintDTO(c));
		return new ResponseEntity<List<ComplaintDTO>>(complaintsDTO, HttpStatus.OK);
	}
	
	@Operation(summary = "Get all complaints", description = "Get all complaints", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					     content = @Content(mediaType = "application/json", 
					     array = @ArraySchema(schema = @Schema(implementation = ComplaintDTO.class))))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/allByPageToAnswer/{pageID}", method = RequestMethod.GET)
	public ResponseEntity<List<ComplaintDTO>> getAllByPageToAnswer(@Parameter(name="pageID", description = "Page number", required = true) @PathVariable("pageID") int pageID) {
		Pageable pageable =  PageRequest.of(pageID, 10);
		Page<Complaint> complaints = complaintService.findAllToAnswer(pageable);
		List<ComplaintDTO> complaintsDTO =  new ArrayList<ComplaintDTO>();
		for(Complaint c : complaints)
			complaintsDTO.add(new ComplaintDTO(c));
		return new ResponseEntity<List<ComplaintDTO>>(complaintsDTO, HttpStatus.OK);
	}
	
	
	@Operation(summary = "Get answer", description = "Get answer", method="POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					     content = @Content(mediaType = "application/json", 
					     array = @ArraySchema(schema = @Schema(implementation = ComplaintDTO.class))))
	})
	@RequestMapping(value = "/answer", method = RequestMethod.POST)
	public ResponseEntity<ComplaintDTO> getAnswer(@RequestBody @Valid ComplaintDTO complaintDTO) {
		Complaint complaint = new Complaint();
		complaint.setId(complaintDTO.getId());
		complaint.setPerson(personService.getById(complaintDTO.getPerson().getId()));
		complaint.setComplaint(complaintDTO.getComplaint());
		complaint.setAnswer(complaintDTO.getAnswer());
		complaintService.save(complaint);
		return new ResponseEntity<ComplaintDTO>(complaintDTO, HttpStatus.OK);
	}
}
