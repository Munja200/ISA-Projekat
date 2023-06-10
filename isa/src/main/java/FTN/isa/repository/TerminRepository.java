package FTN.isa.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import FTN.isa.model.Termin;

public interface TerminRepository extends PagingAndSortingRepository<Termin, Long>{

	@Query(value = "SELECT * FROM termin t WHERE t.center_id =?1", nativeQuery = true)
	List<Termin> getTerminiByCenterId(@Param("id") Long id);

}
