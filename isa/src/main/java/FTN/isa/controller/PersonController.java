package FTN.isa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Person;
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
	public ResponseEntity<Person> getGreeting(@Parameter(name="id", description = "ID of a person to return", required = true) @PathVariable("id") Long id) {
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
	public ResponseEntity<Person> registerPerson(@RequestBody @Valid Person person)  {
		Person savedPerson= null;
		try {
			savedPerson = personService.create(person);
			return new ResponseEntity<Person>(savedPerson, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Person>(savedPerson, HttpStatus.CONFLICT);
		}
	}

}
