package FTN.isa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FTN.isa.model.AnswerQuestion;
import FTN.isa.model.Person;
import FTN.isa.model.QuestionForm;

public interface AnswerQuestionRepository extends JpaRepository<Person, Long> {

		public AnswerQuestion save(AnswerQuestion person);
}
