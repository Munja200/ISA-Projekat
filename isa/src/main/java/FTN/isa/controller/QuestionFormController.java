package FTN.isa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.QuestionForm;
import FTN.isa.service.QuestionFormService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/questionForms")
public class QuestionFormController {
	
	@Autowired
	private QuestionFormService questionService;
	
	@Operation(summary = "Create new answedrd form", description = "Create new answedrd form", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = QuestionForm.class)) }),
			@ApiResponse(responseCode = "409", description = "Not possible to create form when given id is not null",
					content = @Content)
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<QuestionForm> createQuestionForm(@RequestBody @Valid QuestionForm person)  {
		QuestionForm savedPerson= null;
		try {
			savedPerson = questionService.save(person);
			return new ResponseEntity<QuestionForm>(savedPerson, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<QuestionForm>(savedPerson, HttpStatus.CONFLICT);
		}
	}

}
