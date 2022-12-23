package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.AdministratorCenter;

public interface AdministratorCenterRepository extends JpaRepository<AdministratorCenter, Integer>{

	public List<AdministratorCenter> findAll();

	@SuppressWarnings("unchecked")
	public AdministratorCenter save(AdministratorCenter administratorCenter);
	
	@Query(value="SELECT * FROM administrator_center a INNER JOIN person p ON p.id = a.person_id WHERE p.username = :username",nativeQuery = true)
	public AdministratorCenter getAdministratorCenterByUsername(@Param(value = "username") String username);
}
