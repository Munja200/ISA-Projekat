package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import FTN.isa.model.Person;



public interface PersonRepository  extends JpaRepository<Person, Long> {
	
	
	public List<Person> findAll();
	
	@SuppressWarnings("unchecked")
	public Person save(Person person);
	
	@Query(value="select * from person p ,address a where p.address_id= a.id and  p.id =?1",nativeQuery = true)
	public Person getOne(Long id);
}
