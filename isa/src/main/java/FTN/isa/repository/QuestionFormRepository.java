package FTN.isa.repository;

import java.util.Set;
import org.springframework.data.repository.PagingAndSortingRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.Center;
import FTN.isa.model.QuestionForm;

public interface QuestionFormRepository extends PagingAndSortingRepository<QuestionForm, Long>{

	@SuppressWarnings("unchecked")
	public QuestionForm save(QuestionForm questionForm);
	
	@Query(value="select * from question_form a where a.registered_user_id  = :registered_user_id",nativeQuery = true)
	Set<QuestionForm> findAllForUser(@Param(value = "registered_user_id") long registered_user_id);

}
