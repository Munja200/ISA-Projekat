package FTN.isa.service;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.Appointment;
import FTN.isa.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
		@Autowired
		private AppointmentRepository appointmentRepository;
		
		public Page<Appointment> findAllFree(Pageable pageable,int id_centra) {
			   LocalDateTime now = LocalDateTime.now();  
			return appointmentRepository.findAllFree(pageable,id_centra, now);
		}
	
}
