package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import FTN.isa.model.AdministratorCenter;
import FTN.isa.model.Center;

public interface AdministratorCenterRepository extends JpaRepository<AdministratorCenter, Integer>{

	public List<AdministratorCenter> findAll();

	public AdministratorCenter save(AdministratorCenter administratorCenter);
}
