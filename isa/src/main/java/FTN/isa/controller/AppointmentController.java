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

	

	
	@Operation(summary = "Get free appointment by page sorted", description = "Get free appointment by page sorted", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found free appointments by page number sorted",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentDTO.class))),
			@ApiResponse(responseCode = "404", description = "appointments not found", content = @Content)
	})
	@GetMapping(value = "/free/sort/{page}/{id_centra}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AppointmentDTO>> getAllbyPageSort(@Parameter(name="page", description = "Number of a page to return", required = true) @PathVariable("page") int page,@Parameter(name="id_centra", description = "Number of a page to return", required = true) @PathVariable("id_centra") int id_centra) {		
		Pageable appointmentsPage =  PageRequest.of(page, 10, Sort.by("start_time"));	

		Page<Appointment> appointments = appointmentService.findAllFree(appointmentsPage,id_centra);
		List<AppointmentDTO> appointmentDtos = new ArrayList<AppointmentDTO>();
		for(Appointment a : appointments){
			appointmentDtos.add(new AppointmentDTO(a));
		}
		return new ResponseEntity<List<AppointmentDTO>>(appointmentDtos, HttpStatus.OK);
	}
	
		
	@Operation(summary = "Get free appointment by page sorted", description = "Get free appointment by page sorted", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "found free appointments by page number sorted",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentDTO.class))),
			@ApiResponse(responseCode = "404", description = "appointments not found", content = @Content)
	})
	@GetMapping(value = "/free/sortDesc/{page}/{id_centra}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AppointmentDTO>> getAllbyPageSortDesc(@Parameter(name="page", description = "Number of a page to return", required = true) @PathVariable("page") int page,@Parameter(name="id_centra", description = "Number of a page to return", required = true) @PathVariable("id_centra") int id_centra) {		
		Pageable appointmentsPage =  PageRequest.of(page, 10, Sort.by("start_time").descending());	

		Page<Appointment> appointments = appointmentService.findAllFree(appointmentsPage,id_centra);
		List<AppointmentDTO> appointmentDtos = new ArrayList<AppointmentDTO>();
		for(Appointment a : appointments){
			appointmentDtos.add(new AppointmentDTO(a));
		}
		
		return new ResponseEntity<List<AppointmentDTO>>(appointmentDtos, HttpStatus.OK);
	}
	

	
	@Operation(summary = "Set free appointment for user", description = "Set free appointment for user", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Set free appointment for user",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentDTO.class))),
			@ApiResponse(responseCode = "404", description = "appointments not found", content = @Content)
	})
	@GetMapping(value = "/setAppointmentUser/{appointmentId}/{registerUserId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> setFreebyUser(@Parameter(name="appointmentId", description = "Appointment id", required = true) @PathVariable("appointmentId") long appointmentId,@Parameter(name="registerUserId", description = "User id", required = true) @PathVariable("registerUserId") long registerUserId) {		
		//setAppointmentForUser(long appointmentId, long registerUserId) {
		if(appointmentService.setAppointmentForUser(appointmentId, registerUserId)) {
			return new ResponseEntity<>(HttpStatus.OK);		
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
}
	
	
	@Operation(summary = "Set appointment on free", description = "Set appointment on free", method="GET")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Set appointment on free by appointment id",
					content = @Content(mediaType = "application/json", schema = @Schema(implementation = AppointmentDTO.class))),
			@ApiResponse(responseCode = "404", description = "appointments not found", content = @Content)
	})
	@GetMapping(value = "/setFree/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> setAppointmentFree(@Parameter(name="id", description = "id for appointment", required = true) @PathVariable("id") long id) {		
		
		if(appointmentService.setAppointmentFree(id)) {
			return new ResponseEntity<>(HttpStatus.OK);		
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}

	
}