package FTN.isa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.RegisteredUser;

public interface RegisteredUserRepository extends PagingAndSortingRepository<RegisteredUser, Long>{

	Page<RegisteredUser> findAll(Pageable pageable);
	
	@Query(value="SELECT * FROM registered_user r INNER JOIN person p ON r.person_id = p.id WHERE (p.name LIKE CONCAT('%', :name ,'%') AND p.surname LIKE CONCAT('%', :surname ,'%'))",nativeQuery = true)
	Page<RegisteredUser> findAllByNameSurname(Pageable pageable, @Param(value = "name") String name, @Param(value = "surname") String surname);
	
	@Query(value="SELECT * FROM registered_user r INNER JOIN person p ON r.person_id = p.id WHERE p.name LIKE CONCAT('%', :name ,'%')",nativeQuery = true)
	Page<RegisteredUser> findAllByName(Pageable pageable, @Param(value = "name") String name);
	
	@Query(value="SELECT * FROM registered_user r INNER JOIN person p ON r.person_id = p.id WHERE p.surname LIKE CONCAT('%', :surname ,'%')",nativeQuery = true)
	Page<RegisteredUser> findAllBySurname(Pageable pageable, @Param(value = "surname") String surname);
	
	public List<RegisteredUser> findAll();
	
	@Query(value="SELECT * FROM registered_user u WHERE u.verification_code = ?1",nativeQuery = true)
	public RegisteredUser findByVerificationCode(String code);
	
	@SuppressWarnings("unchecked")
	public RegisteredUser save(RegisteredUser registeredUser);
	
	@Query(value="select * from registered_user ru ,person p where ru.person_id= p.id and  ru.id =?1",nativeQuery = true)
	public RegisteredUser getOne(Long id);

	@Query(value="select * from registered_user ru ,person p where ru.person_id= p.id and  p.username =?1",nativeQuery = true)
	public RegisteredUser getByUsername(String id);
	
	@Query(value = "SELECT * FROM registered_user ru INNER JOIN person p ON p.id = ru.person_id INNER JOIN appointment a ON ru.id = a.registered_user_id INNER JOIN center c ON a.center_id = c.id INNER JOIN administrator_center ac ON c.id = ac.center_id WHERE c.id = ?1 AND ac.person_id = ?2", nativeQuery = true)
	public List<RegisteredUser> findByCenterAndPersonId(Long centerId, Long personId);






}
