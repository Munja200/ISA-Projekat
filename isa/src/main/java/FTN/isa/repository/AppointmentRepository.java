package FTN.isa.repository;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.Appointment;

public interface AppointmentRepository extends PagingAndSortingRepository<Appointment, Long> {

	@Query(value="select * from appointment a where a.registered_user_id is null AND a.center_id = :center_id AND a.start_time > :start_time ",nativeQuery = true)
	Page<Appointment> findAllFree(Pageable pageable, @Param(value = "center_id") int center_id, @Param(value = "start_time") LocalDateTime start_time);
}
 