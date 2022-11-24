package FTN.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Center;
import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.model.DTOs.RegisteredUserDTO;
import FTN.isa.service.CenterService;
import FTN.isa.service.RegisteredUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/registeredUser")
public class RegisteredUserController {
	@Autowired
	private RegisteredUserService registeredUserService;

	//"api/registeredUser/{id}"
	@Operation(summary = "Get registered users", description = "Get registered users", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisteredUserDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegisteredUserDTO>> getAllbyPage(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {		
			Pageable registeredUsers =  PageRequest.of(id, 10);	

		Page<RegisteredUser> questions = registeredUserService.findAll(registeredUsers);
		List<RegisteredUserDTO> registeredUserDTOs = new ArrayList<RegisteredUserDTO>();
		for(RegisteredUser u : questions){
			registeredUserDTOs.add(new RegisteredUserDTO(u));
		}
		return new ResponseEntity<List<RegisteredUserDTO>>(registeredUserDTOs, HttpStatus.OK);
	}
	
	//"api/registeredUser/{name}/{surname}/{id}"
	@Operation(summary = "Get registered users by name and surname", description = "Get registered users by name and surname", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisteredUserDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/{name}/{surname}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegisteredUserDTO>> getAllbyName(
			@Parameter(name="name", description = "Name of user (none to ignore)", required = false) @PathVariable("name") String name,
			@Parameter(name="surname", description = "Surname of user (none to ignore)", required = false) @PathVariable("surname") String surname,
			@Parameter(name="id", description = "Number of a page to return (pages not working)", required = false) @PathVariable("id") int id) {
		
		List<RegisteredUser> questions = null;
		List<RegisteredUserDTO> registeredUserDTOs = new ArrayList<RegisteredUserDTO>();
		if(!name.equals("none") && !surname.equals("none"))
			questions = registeredUserService.findAllByNameSurname(name, surname);
		else {
			if(!name.equals("none"))
				questions = registeredUserService.findAllByName(name);
			if (!surname.equals("none"))
				questions = registeredUserService.findAllBySurname(surname);
		}
		if(questions != null)
			for(RegisteredUser u : questions){
				registeredUserDTOs.add(new RegisteredUserDTO(u));
			}
		
		return new ResponseEntity<List<RegisteredUserDTO>>(registeredUserDTOs, HttpStatus.OK);
	}
}
