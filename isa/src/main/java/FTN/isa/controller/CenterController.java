package FTN.isa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.dto.CenterDTO;
import FTN.isa.model.Center;
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
					     array = @ArraySchema(schema = @Schema(implementation = CenterDTO.class))))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAll() {
		List<Center> questions = centerService.findAll();
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}

}
