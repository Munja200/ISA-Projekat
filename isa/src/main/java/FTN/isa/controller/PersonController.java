package FTN.isa.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.DTOs.PersonDTO;
import FTN.isa.model.DTOs.RegisteredUserUpdateDTO;
import FTN.isa.service.EmailService;
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
@RequestMapping(value = "api/persons")
@Validated
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@Autowired
	private EmailService mailService;
	
	@Operation(summary = "Get all persons", description = "Get all persons", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					     content = @Content(mediaType = "application/json", 
					     array = @ArraySchema(schema = @Schema(implementation = Person.class))))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Person>> getAll() {
		List<Person> questions = personService.findAll();
		return new ResponseEntity<List<Person>>(questions, HttpStatus.OK);
	}
	
	
	@Operation(summary = "Get person by id", description = "Get person by id", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found person by id",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "404", description = "person not found", content = @Content)
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> getPersonById(@Parameter(name="id", description = "ID of a person to return", required = true) @PathVariable("id") Long id) {
		Person greeting = personService.getById(id);

		if (greeting == null) {
			return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<Person>(greeting, HttpStatus.OK);
	}
	
	
	
	@Operation(summary = "Register new person", description = "Register new person", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class)) }),
			@ApiResponse(responseCode = "409", description = "Not possible to register new person when given id is not null",
					content = @Content)
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> registerPerson(@RequestBody Person person,HttpServletRequest request) throws UnsupportedEncodingException, MessagingException  {
		RegisteredUser savedPerson= null;
		try {
			savedPerson = personService.create(person);
			mailService.sendNotificaitionAsync(savedPerson,getSiteURL(request));
			return new ResponseEntity<Person>(savedPerson.getPerson(), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Person>(savedPerson.getPerson(), HttpStatus.CONFLICT);
		}
	}
	
	
	private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    } 
	
	@Operation(summary = "Get person by id", description = "Get person by id", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found person by id",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "404", description = "person not found", content = @Content)
	})
	@GetMapping(value = "/verify/{code}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Person> verifyUser(@Parameter(name="code", description = "ID of a person to return", required = true) @PathVariable("code") String code) { 
		System.out.println("usao je"); 
		Person pom = personService.verify(code);
		return new ResponseEntity<Person>(pom, HttpStatus.OK);
		//	return "verify_success";
	//	} else {
	//		return "templates/verify_fail";
		
	} 
	
	@PreAuthorize("hasRole('ADMIN_CENTER')")
	@Operation(summary = "Get person by username", description = "Get person by username", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found person by username",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
			@ApiResponse(responseCode = "404", description = "person not found", content = @Content)
	})
	@GetMapping("/username/{username}")
    public ResponseEntity<Person> getUserByUsername(@Parameter(name="username", description = "username of a person to return", required = true) @PathVariable("username") String username) {
            Person person = personService.findByUsername(username);
            if (person != null) {
                return new ResponseEntity<Person>(person, HttpStatus.OK);
            } else {
                return ResponseEntity.notFound().build();
            }
    }
	
	//"api/persons/updateRegisteredUserate/{id}"
		@PreAuthorize("hasRole('ADMIN_CENTER')")
		@Operation(summary = "Update registered person", description = "Update registered person", method="POST")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200", description = "found centers by page number",
						content = @Content(mediaType = "application/json", schema = @Schema(implementation = Person.class))),
				@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
		})
		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		@RequestMapping(value = "/updateRegisteredUser/{id}", method = RequestMethod.POST)
		public Person updateRegisteredPerson(@PathVariable("id") long id, @RequestBody @Valid Person person) {
			//Person person1 = new Person(person);
		    return personService.updateRegisteredPerson(id, person);
		}
	
}
