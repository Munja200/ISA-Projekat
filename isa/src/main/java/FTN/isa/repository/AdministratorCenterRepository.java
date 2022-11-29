package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import FTN.isa.model.AdministratorCenter;

public interface AdministratorCenterRepository extends JpaRepository<AdministratorCenter, Integer>{

	public List<AdministratorCenter> findAll();

	@SuppressWarnings("unchecked")
	public AdministratorCenter save(AdministratorCenter administratorCenter);
}
