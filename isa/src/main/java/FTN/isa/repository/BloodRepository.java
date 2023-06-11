package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.Blood;
import FTN.isa.model.Center;

public interface BloodRepository extends PagingAndSortingRepository<Blood, Long>{
	
	@Query(value = "SELECT * FROM blood b JOIN center c ON c.id = b.center_id WHERE c.id =?1", nativeQuery = true)
	List<Blood> findByCenterId(@Param("centerId") Long id);

}
