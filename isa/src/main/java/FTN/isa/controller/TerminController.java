package FTN.isa.controller;

import java.util.ArrayList;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Center;
import FTN.isa.model.Termin;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.model.DTOs.TerminDTO;
import FTN.isa.service.TerminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/termini")
public class TerminController {

	@Autowired
	private TerminService terminService;

	//"api/termini/{id}"
	@Operation(summary = "Get termini", description = "Get termini", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found termini by center id",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = Termin.class))),
			@ApiResponse(responseCode = "404", description = "termini not found", content = @Content)
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TerminDTO>> getAllbyTerminiByCenterId(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") Long id) {		
		
        List<Termin> termini = terminService.getTerminiByCenterId(id);
		List<TerminDTO> terminiDTO = new ArrayList<TerminDTO>();

        for(Termin t : termini){
        	terminiDTO.add(new TerminDTO(t));
		}

		return new ResponseEntity<List<TerminDTO>>(terminiDTO, HttpStatus.OK);
	}
}
