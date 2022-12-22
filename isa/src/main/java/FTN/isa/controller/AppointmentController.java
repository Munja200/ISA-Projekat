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

import FTN.isa.model.Appointment;
import FTN.isa.model.DTOs.AppointmentDTO;
import FTN.isa.service.AppointmentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping(value = "api/appointment")
public class AppointmentController {

	@Autowired
	private AppointmentService appointmentService;

	@Operation(summary = "Get free appointment by page", description = "Get free appointment by page", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found free appointments by page number",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentDTO.class))),
			@ApiResponse(responseCode = "404", description = "appointments not found", content = @Content)
	})
	@GetMapping(value = "/free/{page}/{id_centra}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AppointmentDTO>> getAllbyPage(@Parameter(name="page", description = "Number of a page to return", required = true) @PathVariable("page") int page,@Parameter(name="id_centra", description = "Number of a page to return", required = true) @PathVariable("id_centra") int id_centra) {		
			Pageable appointmentsPage =  PageRequest.of(page, 10);	

		Page<Appointment> appointments = appointmentService.findAllFree(appointmentsPage,id_centra);
		List<AppointmentDTO> appointmentDtos = new ArrayList<AppointmentDTO>();
		for(Appointment a : appointments){
			appointmentDtos.add(new AppointmentDTO(a));
		}
		return new ResponseEntity<List<AppointmentDTO>>(appointmentDtos, HttpStatus.OK);
	}

	

	
}