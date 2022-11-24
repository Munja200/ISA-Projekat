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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import FTN.isa.model.Center;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.service.CenterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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

	//"api/centers/{id}"
	@Operation(summary = "Get centers", description = "Get centers", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAllbyPage(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {		
			Pageable centerss =  PageRequest.of(id, 10);	

		Page<Center> questions = centerService.findAll(centerss);
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}
	
	//"api/centers/name/{id}"
	@Operation(summary = "Get centers sorted by name", description = "Get centers sorted by name", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/name/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAllbyName(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {
		Pageable sortedByName =  PageRequest.of(id, 10, Sort.by("name"));	
			
		Page<Center> questions = centerService.findAll(sortedByName);
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}
	
	//"api/centers/nameDes/{id}"
	@Operation(summary = "Get centers sorted desc by name", description = "Get centers sorted desc by name", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/nameDes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAllbyNameDes(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {
		Pageable sortedByNameDes = PageRequest.of(id, 10, Sort.by("name").descending());

		Page<Center> questions = centerService.findAll(sortedByNameDes);
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}
	
	//"api/centers/nameDes/allForAdministratorRegistration"
	@Operation(summary = "Get all centers for managers", description = "Get all centers for managers", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class)))
	})
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@RequestMapping(value = "/allForAdministratorRegistration", method = RequestMethod.GET)
	public ResponseEntity<List<CenterDTO>> getAllForManagerRegistration() {
		List<Center> centers = centerService.findAll();
		List<CenterDTO> centerDTOs = new ArrayList<CenterDTO>();
		for(Center center : centers) {
			if(!center.isDeleted()) {
				centerDTOs.add(new CenterDTO(center));
			}
		}
		return new ResponseEntity<List<CenterDTO>>(centerDTOs, HttpStatus.OK);
	}
	
	//"api/centers/add"
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
		Center center = new Center(centerDTO);
		try {
			centerService.create(center);
			return new ResponseEntity<CenterDTO>(centerDTO, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<CenterDTO>(centerDTO, HttpStatus.CONFLICT);
		}
	}

	//"api/centers/nameDes/city/{id}"
	@Operation(summary = "Get centers sorted by city", description = "Get centers sorted by city", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/city/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAllbyCity(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {
		Pageable sortedByCity =  PageRequest.of(id, 10, Sort.by("address.city"));	
	
		Page<Center> questions = centerService.findAll(sortedByCity);
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}
	
	//"api/centers/nameDes/cityDes/{id}"
	@Operation(summary = "Get centers sorted desc by city", description = "Get centers sorted desc by city", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/cityDes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAllbyCityDes(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {		
		Pageable sortedByCityDes = PageRequest.of(id, 10, Sort.by("address.city").descending());

		Page<Center> questions = centerService.findAll(sortedByCityDes);
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}

	//"api/centers/nameDes/averageRating/{id}"
	@Operation(summary = "Get centers sorted by averageRating", description = "Get centers sorted by averageRating", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/averageRating/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAllbyAverageRating(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {
		Pageable sortedByAverageRating =  PageRequest.of(id, 10, Sort.by("averageRating"));	
		
		Page<Center> questions = centerService.findAll(sortedByAverageRating);
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}
	
	//"api/centers/nameDes/averageRatingDes/{id}"
	@Operation(summary = "Get centers sorted desc by averageRating", description = "Get centers sorted desc by averageRating", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found centers by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = CenterDTO.class))),
			@ApiResponse(responseCode = "404", description = "centers not found", content = @Content)
	})
	@GetMapping(value = "/averageRatingDes/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CenterDTO>> getAllbyAverageRatingDes(@Parameter(name="id", description = "Number of a page to return", required = true) @PathVariable("id") int id) {
		Pageable sortedByAverageRatingDes = PageRequest.of(id, 10, Sort.by("averageRating").descending());
	
		Page<Center> questions = centerService.findAll(sortedByAverageRatingDes);
		List<CenterDTO> centers = new ArrayList<CenterDTO>();
		for(Center c : questions){
			centers.add(new CenterDTO(c));
		}
		return new ResponseEntity<List<CenterDTO>>(centers, HttpStatus.OK);
	}
}
