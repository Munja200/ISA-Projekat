package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Question;
import FTN.isa.repository.QuestionRepository;
import io.swagger.v3.oas.models.security.SecurityScheme.In;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	public List<Question> findAll() {
		return questionRepository.findAll();
	}
	
}
