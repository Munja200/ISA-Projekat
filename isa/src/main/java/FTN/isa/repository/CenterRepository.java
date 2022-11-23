package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import FTN.isa.model.Center;
import FTN.isa.model.Person;
import FTN.isa.model.Question;

public interface CenterRepository extends JpaRepository<Center, Integer>{

	public List<Center> findAll();
	
	public Center save(Center center);
	
	@Query(value="select * from center c where c.id = ?1",nativeQuery = true)
	public Center findById(int centerId);
}
