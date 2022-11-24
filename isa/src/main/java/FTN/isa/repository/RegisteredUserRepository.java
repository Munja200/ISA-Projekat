package FTN.isa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;

public interface RegisteredUserRepository extends PagingAndSortingRepository<RegisteredUser, Long>{

	Page<RegisteredUser> findAll(Pageable pageable);
	
	@Query(value="SELECT * FROM registered_user INNER JOIN person ON registered_user.person_id = person.id WHERE (person.name LIKE CONCAT('%', :name ,'%') AND person.surname LIKE CONCAT('%', :surname ,'%'));",nativeQuery = true)
	List<RegisteredUser> findAllByNameSurname(@Param(value = "name") String name, @Param(value = "surname") String surname);
	
	@Query(value="SELECT * FROM registered_user INNER JOIN person ON registered_user.person_id = person.id WHERE person.name LIKE CONCAT('%', :name ,'%');",nativeQuery = true)
	List<RegisteredUser> findAllByName(@Param(value = "name") String name);
	
	@Query(value="SELECT * FROM registered_user INNER JOIN person ON registered_user.person_id = person.id WHERE person.surname LIKE CONCAT('%', :surname ,'%');",nativeQuery = true)
	List<RegisteredUser> findAllBySurname(@Param(value = "surname") String surname);
	
	public List<RegisteredUser> findAll();
	
	public RegisteredUser save(RegisteredUser registeredUser);
	
	@Query(value="select * from registered_user ru ,person p where ru.person_id= p.id and  ru.id =?1",nativeQuery = true)
	public RegisteredUser getOne(Long id);
	
}
