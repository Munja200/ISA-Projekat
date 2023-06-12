package FTN.isa.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.Center;
import FTN.isa.model.Grade;

public interface GradeRepository extends PagingAndSortingRepository<Grade, Long>{
	
	@SuppressWarnings("unchecked")
	public Grade save(Grade grade);
	
	@Query(value="select * from grade g where g.id = ?1",nativeQuery = true)
	public Grade getOne(Long id);
	
	@Query(value="SELECT * FROM grade g WHERE g.center_id = ?1", nativeQuery = true)
    Grade findByCenterId(@Param("centerId") long centerId);
	
	@Query(value = "SELECT * FROM grade g WHERE g.center_id = ?1 AND g.person_id = ?2", nativeQuery = true)
	Grade findGradeByCenterIdAndPersonId(long centerId, long personId);


}
