package FTN.isa.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.AdministratorCenter;
import FTN.isa.model.Center;
import FTN.isa.model.Person;
import FTN.isa.model.DTOs.AdministratorCenterDTO;
import FTN.isa.service.AdministratorCenterService;
import FTN.isa.service.CenterService;
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
@RequestMapping(value = "api/administratorCenters")
public class AdministratorCenterController {
	@Autowired
	private PersonService personService;
	@Autowired
	private AdministratorCenterService administratorCenterService;
	@Autowired
	private CenterService centerService;
	
	@Operation(summary = "Get all administratorCenters", description = "Get all administratorCenters", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					     content = @Content(mediaType = "application/json", 
					     array = @ArraySchema(schema = @Schema(implementation = AdministratorCenter.class))))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<AdministratorCenter>> getAll() {
		List<AdministratorCenter> administratorCenters = administratorCenterService.findAll();
		return new ResponseEntity<List<AdministratorCenter>>(administratorCenters, HttpStatus.OK);
	}
	
	//"api/administratorCenters/add"
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Register new administratorCenter", description = "Register new administratorCenter", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = AdministratorCenterDTO.class)) }),
			@ApiResponse(responseCode = "409", description = "Not possible to register new person when given id is not null",
					content = @Content)
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<AdministratorCenterDTO> registerPerson(@RequestBody @Valid AdministratorCenterDTO administratorCenterDTO)  {
		try {
			personService.create(administratorCenterDTO.getPerson());
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AdministratorCenter administratorCenter = new AdministratorCenter(
				administratorCenterDTO.getId(),
				administratorCenterDTO.isDeleted(),
				administratorCenterDTO.getPerson(),
				centerService.findById(administratorCenterDTO.getCenterId())
				);
		administratorCenterService.create(administratorCenter);
		return new ResponseEntity<AdministratorCenterDTO>(administratorCenterDTO, HttpStatus.CREATED);
	}
	
	
}
