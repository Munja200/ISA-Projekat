package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import FTN.isa.model.Center;

public interface CenterRepository extends JpaRepository<Center, Long>{
	
	public List<Center> findAll();
}
