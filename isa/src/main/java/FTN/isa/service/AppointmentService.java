package FTN.isa.service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import FTN.isa.model.Appointment;
import FTN.isa.model.QuestionForm;
import FTN.isa.model.RegisteredUser;
import FTN.isa.repository.AppointmentRepository;
import FTN.isa.repository.QuestionFormRepository;
import FTN.isa.repository.RegisteredUserRepository;

@Service
@Transactional(readOnly = true)
public class AppointmentService {
	
		@Autowired
		private AppointmentRepository appointmentRepository;
		
		@Autowired
		private QuestionFormRepository questionFormRepository;
		
		@Autowired
		private RegisteredUserRepository userRepository;
		
		private Logger logger = LoggerFactory.getLogger(this.getClass());

		
		public Page<Appointment> findAllFree(Pageable pageable,int id_centra) {
			   LocalDateTime now = LocalDateTime.now();  
			return appointmentRepository.findAllFree(pageable,id_centra, now);
		}
		
		@Transactional(readOnly = false)
		public Appointment save(Appointment appointment) {
			logger.info("> create");
			Appointment savedAppointment = appointmentRepository.save(appointment);
			logger.info("< create");
			return savedAppointment;
		}

		public Page<Appointment> findAllUsersAppointment(Pageable pageable,String registerUserId) {
			   LocalDateTime now = LocalDateTime.now();  
				RegisteredUser user = userRepository.getByUsername(registerUserId);

			   return appointmentRepository.findAllUsersAppointment(pageable,user.getId(), now);
		}

		public Appointment findById(long id) {
			
			Appointment product = appointmentRepository.findById(id).get();
			return product;
		}

		
	
		@Transactional(readOnly = false, propagation = Propagation.REQUIRED)		
		public boolean setAppointmentFree(long appointmentId) {
			Appointment appointment = appointmentRepository.findById(appointmentId).get();
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

		@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)		
		public boolean setAppointmentForUser(Appointment appointment, String registerUserId) {
			   logger.info("> update id:{}", appointment.getId());

			   RegisteredUser user = userRepository.getByUsername(registerUserId);
			LocalDateTime now = LocalDateTime.now(); 
			Set<QuestionForm> forms =  questionFormRepository.findAllForUser(user.getId());
			
			List<Appointment> appointments =  appointmentRepository.findAllOldUsersAppointment(user.getId(),now);
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
			
			this.save(appointment);
	        logger.info(appointment.getUser().getPerson().getUsername()+" " + appointment.getVersion());
	        logger.info("< update id:{}", appointment.getId());
			return true;
		}
		
		public LocalDateTime convertToLocalDateTimeViaMilisecond(Date dateToConvert) {
		    return Instant.ofEpochMilli(dateToConvert.getTime())
		      .atZone(ZoneId.systemDefault())
		      .toLocalDateTime();
		}

}
