package FTN.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.AnswerQuestion;
import FTN.isa.model.QuestionForm;
import FTN.isa.repository.AnswerQuestionRepository;
import FTN.isa.repository.QuestionFormRepository;

@Service
public class QuestionFormService {
	@Autowired
	private QuestionFormRepository personRepository;
	
	@Autowired
	private AnswerQuestionRepository answerRepository;
	

	public QuestionForm save(QuestionForm person) {
		
		
		return personRepository.save(person);
	}

}
