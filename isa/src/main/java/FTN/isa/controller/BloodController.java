package FTN.isa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Blood;
import FTN.isa.model.Person;
import FTN.isa.model.DTOs.BloodDTO;
import FTN.isa.service.BloodService;
import FTN.isa.service.CenterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/bloods")
public class BloodController {
	

	@Autowired
	private BloodService bloodService;
	

	@PreAuthorize("hasRole('ADMIN_CENTER')")
    @Operation(summary = "Get all bloods for center", description = "Get all bloods for center")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = Blood.class))),
            @ApiResponse(responseCode = "404", description = "registered users not found", content = @Content)
    })
    @GetMapping(value = "/allBloodCenter/{centerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BloodDTO>> getAllBloodForCenter(@Parameter(name = "centerId", description = "ID of the center", required = true)
    @PathVariable("centerId") Long centerId) {

    	List<BloodDTO> bloodList = bloodService.findByCenterId(centerId);

        return new ResponseEntity<List<BloodDTO>>(bloodList, HttpStatus.OK);
    }
	
	
	//"api/bloods/changeBlood/{centerId}/{quantity}/{bloodType}"
			@PreAuthorize("hasRole('ADMIN_CENTER')")
			@Operation(summary = "Update blood", description = "Update blood", method="POST")
			@ApiResponses(value = {
					@ApiResponse(responseCode = "200", description = "found bloods",
							content = @Content(mediaType = "application/json", schema = @Schema(implementation = Blood.class))),
					@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
			})
			@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
			@RequestMapping(value = "/changeBlood/{centerId}/{quantity}/{bloodType}", method = RequestMethod.POST)
			public boolean updateBlood(@PathVariable("centerId") long centerId, @PathVariable("quantity") int quantity,
					@PathVariable("bloodType") String bloodType) {
				
			    return bloodService.updateBlood(centerId, quantity, bloodType);
			}
    

}
