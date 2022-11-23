package FTN.isa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;

import FTN.isa.model.Center;

public interface CenterRepository extends PagingAndSortingRepository<Center, Long>{
	
	Page<Center> findAll(Pageable pageable);

	public List<Center> findAll();
	
	public Center save(Center center);
	
	@Query(value="select * from center c where c.id = ?1",nativeQuery = true)
	public Center findById(int centerId);
}
