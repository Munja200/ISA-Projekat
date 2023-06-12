package FTN.isa.controller;

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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Center;
import FTN.isa.model.Grade;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.service.CenterService;
import FTN.isa.service.GradeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/grades")
public class GradeController {
	
	@Autowired
	private GradeService gradeService;
	
	@PreAuthorize("hasRole('USER')")
	//"api/grades/add"
	@Operation(summary = "Submit new grade", description = "Submit new grade", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class)) }),
			@ApiResponse(responseCode = "409", description = "Not possible to submit new grade",
					content = @Content)
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<Grade> createGrade(@RequestBody @Valid Grade grade)  {
		Grade g = new Grade(grade);
		try {
			gradeService.create(g);
			return new ResponseEntity<Grade>(g, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Grade>(g, HttpStatus.CONFLICT);
		}
	}
	
	//api/grades/update/{id}
	@PreAuthorize("hasRole('USER')")
	@Operation(summary = "Update grade", description = "Update grade", method="POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found grade by id",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public boolean updateCenter(@PathVariable("id") long id, @RequestBody @Valid Grade grade) {
		Grade grade1 = new Grade(grade);
	    return gradeService.updateGrade(id, grade1);
	}
	
	//api/grades/findByCenter/{centerId}
		@Operation(summary = "Get grade for center", description = "Get grade for center")
		@ApiResponses(value = {
		        @ApiResponse(responseCode = "200", description = "Successful operation",
		                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Grade.class))),
		        @ApiResponse(responseCode = "404", description = "grade not found", content = @Content)
		})
		@GetMapping(value = "/findByCenter/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Grade> findGradeByCenterId(@Parameter(name = "centerId", description = "ID of the center", required = true)
	    @PathVariable("centerId") Long centerId) {
			
		    Grade grade = gradeService.findGradeByCenterId(centerId);
		    return new ResponseEntity<Grade>(grade, HttpStatus.OK);
		
		}
		
		//api/grades/findByCenterAndPerson/{centerId}/{personId}
		@Operation(summary = "Get grade for center and person", description = "Get grade for center and person")
		@ApiResponses(value = {
		        @ApiResponse(responseCode = "200", description = "Successful operation",
		                content = @Content(mediaType = "application/json", schema = @Schema(implementation = Grade.class))),
		        @ApiResponse(responseCode = "404", description = "Grade not found", content = @Content)
		})
		@GetMapping(value = "/findByCenterAndPerson/{centerId}/{personId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<Grade> findGradeByCenterAndPersonId(
		        @Parameter(name = "centerId", description = "ID of the center", required = true)
		        @PathVariable("centerId") Long centerId,
		        @Parameter(name = "personId", description = "ID of the person", required = true)
		        @PathVariable("personId") Long personId) {

		    Grade grade = gradeService.findGradeByCenterAndPersonId(centerId, personId);
		    return new ResponseEntity<Grade>(grade, HttpStatus.OK);
		}




}
