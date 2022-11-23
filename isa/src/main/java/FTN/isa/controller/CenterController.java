package FTN.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Center;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.service.CenterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/centers")
public class CenterController {
	
	@Autowired
	private CenterService centerService;
	
	@Operation(summary = "Get all centers", description = "Get all centers", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					     content = @Content(mediaType = "application/json", 
					     array = @ArraySchema(schema = @Schema(implementation = Center.class))))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Center>> getAll() {
		List<Center> centers = centerService.findAll();
		return new ResponseEntity<List<Center>>(centers, HttpStatus.OK);
	}
	
	@Operation(summary = "Get all centers for managers", description = "Get all centers for managers", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					     content = @Content(mediaType = "application/json", 
					     array = @ArraySchema(schema = @Schema(implementation = CenterDTO.class))))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/allForAdministratorRegistration", method = RequestMethod.GET)
	public ResponseEntity<List<CenterDTO>> getAllForManagerRegistration() {
		List<Center> centers = centerService.findAll();
		List<CenterDTO> centerDTOs = new ArrayList<CenterDTO>();
		for(Center center : centers) {
			if(!center.isDeleted()) {
				centerDTOs.add(new CenterDTO(
						center.getId(),
						center.getName(),
						center.getAddress(),
						center.getDescription(),
						center.getAverageRating(),
						center.isDeleted()
						));
			}
		}
		return new ResponseEntity<List<CenterDTO>>(centerDTOs, HttpStatus.OK);
	}
	
	@Operation(summary = "Register new center", description = "Register new center", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201", description = "Created",
					content = { @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class)) }),
			@ApiResponse(responseCode = "409", description = "Not possible to register new person when given id is not null",
					content = @Content)
	})
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<CenterDTO> registerPerson(@RequestBody CenterDTO centerDTO)  {
		Center center = new Center(
				centerDTO.getId(),
				centerDTO.getName(),
				centerDTO.getAddress(),
				centerDTO.getDescription(),
				centerDTO.getAverageRating(),
				centerDTO.isDeleted()
				);
		try {
			centerService.create(center);
			return new ResponseEntity<CenterDTO>(centerDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CenterDTO>(centerDTO, HttpStatus.CONFLICT);
		}
	}

}
