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
	
	@SuppressWarnings("unchecked")
	 @Query(value="SELECT u FROM registered_user u WHERE u.verification_code = ?1",nativeQuery = true)
	 public RegisteredUser findByVerificationCode(String code);
	

	public RegisteredUser save(RegisteredUser registeredUser);
	
	@Query(value="select * from registered_user ru ,person p where ru.person_id= p.id and  ru.id =?1",nativeQuery = true)
	public RegisteredUser getOne(Long id);
	
}
