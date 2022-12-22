package FTN.isa.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.Complaint;

public interface ComplaintRepository extends PagingAndSortingRepository<Complaint, Long>{
	
	Page<Complaint> findAll(Pageable pageable);

	public List<Complaint> findAll();
	
	@Query(value="select * from complaint c where c.answer is null",nativeQuery = true)
	public Page<Complaint> findAllToAnswer(Pageable pageable);
	
	@SuppressWarnings("unchecked")
	public Complaint save(Complaint complaint);
	
	@Query(value="select * from complaint c where c.id = :complaintId",nativeQuery = true)
	public Complaint findById(@Param(value = "complaintId") int complaintId);
	
	@Query(value="select * from complaint c where c.person_id = :personId",nativeQuery = true)
	public Page<Complaint> findByPersonId(Pageable pageable, @Param(value = "personId") String personId);
	
}
