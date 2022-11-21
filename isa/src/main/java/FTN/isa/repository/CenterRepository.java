package FTN.isa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import FTN.isa.model.Center;

public interface CenterRepository extends PagingAndSortingRepository<Center, Long>{
	
	Page<Center> findAll(Pageable pageable);
	
	
}
