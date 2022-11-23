package FTN.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FTN.isa.model.Person;
import FTN.isa.model.QuestionForm;

public interface QuestionFormRepository extends JpaRepository<Person, Long> {

	public QuestionForm save(QuestionForm person);
}
