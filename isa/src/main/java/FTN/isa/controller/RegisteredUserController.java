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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.RegisteredUser;
import FTN.isa.model.DTOs.RegisteredUserDTO;
import FTN.isa.model.DTOs.RegisteredUserUpdateDTO;
import FTN.isa.service.RegisteredUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/registeredUsers")
public class RegisteredUserController {
	@Autowired
	private RegisteredUserService registeredUserService;

	//"api/registeredUsers/{id}"
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
	
	//"api/registeredUsers/{name}/{surname}/{id}"
	@Operation(summary = "Get registered users by name and surname", description = "Get registered users by name and surname", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisteredUserDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/{name}/{surname}/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegisteredUserDTO>> getAllByNameSurname(
			@Parameter(name="name", description = "Name of user (none to ignore)", required = false) @PathVariable("name") String name,
			@Parameter(name="surname", description = "Surname of user (none to ignore)", required = false) @PathVariable("surname") String surname,
			@Parameter(name="id", description = "Number of a page to return (pages not working)", required = false) @PathVariable("id") int id) {
		Pageable pageable =  PageRequest.of(id, 10);	
		Page<RegisteredUser> questions = null;
		List<RegisteredUserDTO> registeredUserDTOs = new ArrayList<RegisteredUserDTO>();
		
		if(!name.equals("none") && !surname.equals("none"))
			questions = registeredUserService.findAllByNameSurname(pageable, name, surname);
		else if(name.equals("none") && surname.equals("none")){
			questions = registeredUserService.findAll(pageable);
		}else{
			if(!name.equals("none"))
				questions = registeredUserService.findAllByName(pageable, name);
			if (!surname.equals("none"))
				questions = registeredUserService.findAllBySurname(pageable, surname);
		}
		
		if(questions != null)
			for(RegisteredUser u : questions){
				registeredUserDTOs.add(new RegisteredUserDTO(u));
			}
		
		return new ResponseEntity<List<RegisteredUserDTO>>(registeredUserDTOs, HttpStatus.OK);
	}
	
	//"api/registeredUsers/oneRegisteredUser/{id}"
	@PreAuthorize("hasRole('USER')")
	@Operation(summary = "Get registered person by id", description = "Get registered person by id", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found registered person by id",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisteredUser.class))),
			@ApiResponse(responseCode = "404", description = "registered person not found", content = @Content)
	})
	@GetMapping(value = "/oneRegisteredUser/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RegisteredUser> getRegisteredPerson(@Parameter(name="id", description = "ID of a registered person to return", required = true) @PathVariable("id") Long id) {
		RegisteredUser registeredUser = registeredUserService.getById(id);

		if (registeredUser == null) {
			return new ResponseEntity<RegisteredUser>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<RegisteredUser>(registeredUser, HttpStatus.OK);
	}
	
	//"api/registeredUsers/oneRegisteredUser/{id}"
	@PreAuthorize("hasRole('USER')")
	@Operation(summary = "Update registered person", description = "Update registered person", method="POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisteredUserUpdateDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/updateRegisteredUser/{id}", method = RequestMethod.POST)
	public boolean updateRegisteredUser(@PathVariable("id") long id, @RequestBody @Valid RegisteredUserUpdateDTO registeredUserUpdateDTO) {
		RegisteredUser registerUser = new RegisteredUser(registeredUserUpdateDTO);
	    return registeredUserService.updateRegisteredUser(id, registerUser);
	}
	
	//"api/registeredUsers/findByCenter/{centerId}/person/{personId}"
	@PreAuthorize("hasRole('ADMIN_CENTER')")
		@Operation(summary = "Get registered users by center id", description = "Get registered users by center id", method = "GET")
		@ApiResponses(value = {
		    @ApiResponse(responseCode = "200", description = "found registered users by center id",
		            content = @Content(mediaType = "application/json", schema = @Schema(implementation = RegisteredUserDTO.class))),
		    @ApiResponse(responseCode = "404", description = "registered users not found", content = @Content)
		})
	@GetMapping(value = "/findByCenter/{centerId}/person/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RegisteredUserDTO>> getRegisteredUsersByCenterAndPersonId(
	        @Parameter(name = "centerId", description = "ID of the center", required = true)
	        @PathVariable("centerId") Long centerId,
	        @Parameter(name = "personId", description = "ID of the person", required = true)
	        @PathVariable("personId") Long personId) {

	    List<RegisteredUserDTO> registeredUsers = registeredUserService.findByCenterAndPersonId(centerId, personId);

	    if (registeredUsers.isEmpty()) {
	        return ResponseEntity.notFound().build();
	    }

	    return new ResponseEntity<List<RegisteredUserDTO>>(registeredUsers, HttpStatus.OK);
	}


	
	
}
