package FTN.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.QuestionForm;
import FTN.isa.repository.QuestionFormRepository;

@Service
public class QuestionFormService {
	@Autowired
	private QuestionFormRepository questionFormRepository;
	
	public QuestionForm createQuestionForm(QuestionForm questionForm) {
		return questionFormRepository.save(questionForm);
	}

}
