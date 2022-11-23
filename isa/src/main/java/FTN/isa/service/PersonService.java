package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Person;
import FTN.isa.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public Person create(Person person) {
		return personRepository.save(person);
	}
	
	public Person getById(Long id) {
		return personRepository.getOne(id);
	}
}
