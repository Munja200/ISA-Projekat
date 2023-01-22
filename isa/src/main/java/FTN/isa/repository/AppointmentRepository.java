package FTN.isa.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.Appointment;


public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {

	@Query(value="select * from appointment a where a.id = ?1",nativeQuery = true)
	public Appointment findById(long id);
	
	@Query(value="select * from appointment a where a.registered_user_id is null AND a.center_id = :center_id AND a.start_time > :start_time ",nativeQuery = true)
	Page<Appointment> findAllFree(Pageable pageable, @Param(value = "center_id") long center_id, @Param(value = "start_time") LocalDateTime start_time);

	@Query(value="select * from appointment a where a.registered_user_id = :registered_user_id AND a.start_time > :start_time ",nativeQuery = true)
	Page<Appointment> findAllUsersAppointment(Pageable pageable, @Param(value = "registered_user_id") long registered_user_id, @Param(value = "start_time") LocalDateTime start_time);



	@Query(value="select * from appointment a where a.registered_user_id = :registered_user_id AND a.start_time < :start_time order by a.start_time DESC ",nativeQuery = true)
	List<Appointment> findAllOldUsersAppointment(@Param(value = "registered_user_id") long registered_user_id, @Param(value = "start_time") LocalDateTime start_time);

	
	
	@SuppressWarnings("unchecked")
	public Appointment save(Appointment registeredUser);

}
 