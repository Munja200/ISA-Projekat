package FTN.isa.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;
import javax.swing.text.PasswordView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.repository.PersonRepository;
import FTN.isa.repository.RegisteredUserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	public RegisteredUser create(Person person)throws UnsupportedEncodingException, MessagingException {
	    RegisteredUser user = new RegisteredUser(0,false,person);
		 
	    String randomCode = RandomString.make(64);
	    user.setVerificationCode(randomCode);
	    user.setEnabled(false);
	    RegisteredUser users = registeredUserRepository.save(user); 	
		return users;
	}
	
	public Person getById(Long id) {
		return personRepository.getOne(id);
	}
	
	
	
	public boolean verify(String verificationCode) {
	    RegisteredUser user = registeredUserRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.isEnabled()) {
	        return false;
	    } else {
	        user.setVerificationCode(null);
	        user.setEnabled(true);
	        registeredUserRepository.save(user);
	         
	        return true;
	    }
	}
}
