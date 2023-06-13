package FTN.isa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import FTN.isa.model.Blood;
import FTN.isa.model.Center;
import FTN.isa.model.Report;

public interface ReportRepository extends PagingAndSortingRepository<Report, Long>{
	
	public List<Report> findAll();
	
	@SuppressWarnings("unchecked")
	public Report save(Report report);
	
	@Query(value="select * from report r where r.id = ?1",nativeQuery = true)
	public Report findById(long reportId);
	
	@Query(value="select * FROM report r WHERE r.id =?1",nativeQuery = true)
	Report getOne(Long id);

}
