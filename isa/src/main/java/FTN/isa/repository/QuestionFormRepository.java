package FTN.isa.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import FTN.isa.model.QuestionForm;

public interface QuestionFormRepository extends JpaRepository<QuestionForm, Long> {

	public QuestionForm save(QuestionForm person);
	
	@Query(value="select * from question_form a where a.registered_user_id  = :registered_user_id",nativeQuery = true)
	Set<QuestionForm> findAllForUser(@Param(value = "registered_user_id") long registered_user_id);

}
