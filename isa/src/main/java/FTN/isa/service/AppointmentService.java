package FTN.isa.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.Appointment;
import FTN.isa.model.QuestionForm;
import FTN.isa.model.RegisteredUser;
import FTN.isa.repository.AppointmentRepository;
import FTN.isa.repository.QuestionFormRepository;
import FTN.isa.repository.RegisteredUserRepository;

@Service
public class AppointmentService {
	
		@Autowired
		private AppointmentRepository appointmentRepository;
		
		@Autowired
		private QuestionFormRepository questionFormRepository;
		
		@Autowired
		private RegisteredUserRepository userRepository;
		
		public Page<Appointment> findAllFree(Pageable pageable,int id_centra) {
			   LocalDateTime now = LocalDateTime.now();  
			return appointmentRepository.findAllFree(pageable,id_centra, now);
		}
	
		public boolean setAppointmentFree(long appointmentId) {
			Appointment appointment = appointmentRepository.findById(appointmentId);
			LocalDateTime now = LocalDateTime.now(); 
			LocalDateTime noww = convertToLocalDateTimeViaMilisecond(appointment.getStart());
			noww = noww.minusHours(24);
			if(!now.isBefore(noww)) {
				return false;
			}
			appointment.setUser(null);
			
			appointmentRepository.save(appointment);
			return true;
		}
		
		public boolean setAppointmentForUser(long appointmentId, long registerUserId) {
			Appointment appointment = appointmentRepository.findById(appointmentId);
			RegisteredUser user = userRepository.getOne(registerUserId);
			LocalDateTime now = LocalDateTime.now(); 
			Set<QuestionForm> forms =  questionFormRepository.findAllForUser(registerUserId);
			
			List<Appointment> appointments =  appointmentRepository.findAllOldUsersAppointment(registerUserId,now);
			if(!appointments.isEmpty()) {
				Appointment a = appointments.get(0);
				LocalDateTime dat = LocalDateTime.now();
				dat = dat.minusMonths(6);
				if(!dat.isBefore(convertToLocalDateTimeViaMilisecond(a.getStart()))) {
					return false;
				}
			}
			
			for (Appointment appointment2 : appointments) {
				if(appointment.getStart().equals(appointment2.getStart()) && appointment.getCenter().getId() == appointment2.getCenter().getId()) {
					return false;
				}
			}
			
			if(forms.isEmpty()) {
				return false;
			}
			appointment.setUser(user);
			
			appointmentRepository.save(appointment);
			return true;
		}
		
		public LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
		    return Instant.ofEpochMilli(dateToConvert.getTime())
		      .atZone(ZoneId.systemDefault())
		      .toLocalDateTime();
		}
		
		public List<Appointment> getAllAppointmentsByCenter(long centerAdministratorID){
			return appointmentRepository.getAllAppointmentsByCenter(centerAdministratorID);
		}

}
