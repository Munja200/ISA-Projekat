package FTN.isa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import FTN.isa.model.Center;
import FTN.isa.model.RegisteredUser;

public interface CenterRepository extends PagingAndSortingRepository<Center, Long>{
	
	Page<Center> findAll(Pageable pageable);

	public List<Center> findAll();
	
	public Center save(Center center);
	
	@Query(value="select * from center c where c.id = ?1",nativeQuery = true)
	public Center findById(int centerId);
	
	@Query(value="SELECT * FROM center c INNER JOIN address a ON c.address_id = a.id WHERE (c.name LIKE CONCAT('%', :name ,'%') AND a.city LIKE CONCAT('%', :city ,'%'))",nativeQuery = true)
	Page<Center> findAllByNameCity(Pageable pageable, @Param(value = "name") String name, @Param(value = "city") String city);
	
	@Query(value="SELECT * FROM center c WHERE c.name LIKE CONCAT('%', :name ,'%')",nativeQuery = true)
	Page<Center> findAllByName(Pageable pageable, @Param(value = "name") String name);
	
	@Query(value="SELECT * FROM center c INNER JOIN address a ON c.address_id = a.id WHERE a.city LIKE CONCAT('%', :city ,'%')",nativeQuery = true)
	Page<Center> findAllByCity(Pageable pageable, @Param(value = "city") String city);

	@Query(value="SELECT * FROM center c INNER JOIN address a ON c.address_id = a.id WHERE (c.average_rating LIKE CONCAT('%', :average_rating ,'%') AND a.street LIKE CONCAT('%', :street ,'%'))",nativeQuery = true)
	Page<Center> findAllByAverageStreet(Pageable pageable, @Param(value = "average_rating") Float average_rating, @Param(value = "street") String street);
	
	@Query(value="SELECT * FROM center c WHERE c.average_rating = ' :average_rating '",nativeQuery = true)
	Page<Center> findAllByAverage(Pageable pageable, @Param(value = "average_rating") float average_rating);
	
	@Query(value="SELECT * FROM center c INNER JOIN address a ON c.address_id = a.id WHERE a.street LIKE CONCAT('%', :street ,'%')",nativeQuery = true)
	Page<Center> findAllByStreet(Pageable pageable, @Param(value = "street") String street);

	
}
