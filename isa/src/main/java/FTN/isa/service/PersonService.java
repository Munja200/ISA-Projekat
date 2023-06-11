package FTN.isa.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.Role;
import FTN.isa.repository.PersonRepository;
import FTN.isa.repository.RegisteredUserRepository;
import net.bytebuddy.utility.RandomString;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private RoleService roleService;

	
	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	public List<Person> findAll() {
		return personRepository.findAll();
	}
	
	public Person findByUsername(String username) throws UsernameNotFoundException {
		return personRepository.findByUsername(username);
	}	

	public RegisteredUser create(Person person)throws UnsupportedEncodingException, MessagingException {
	    RegisteredUser user = new RegisteredUser(0,false,person);
		 
	    String randomCode = RandomString.make(64);
	    user.setVerificationCode(randomCode);
	    user.getPerson().setPassword(passwordEncoder.encode(person.getPassword()));
	    user.getPerson().setUsername(person.getEmail());
	    user.getPerson().setEnabled(false);
	    user.setEnabled(false);
	    List<Role> roles = roleService.findByName("ROLE_USER");
		user.getPerson().setRoles(roles);
		
	    RegisteredUser users = registeredUserRepository.save(user); 	
		return users;
	}
	
	public Person getById(Long id) {
		return personRepository.getOne(id);
	}
	
	public Person getOneByUsername(String username) {
		return personRepository.getOneByUsername(username);
	}
	
	
	public Person verify(String verificationCode) {
	    RegisteredUser user = registeredUserRepository.findByVerificationCode(verificationCode);
	     
	    if (user == null || user.getPerson().isEnabled()) {
	    	System.out.println("Ovde ulazi");
	        return null;
	    } else {
	        user.setVerificationCode(null);
	        user.getPerson().setEnabled(true);
	        user.setEnabled(true);
	        registeredUserRepository.save(user);
	        System.out.println("A sad ovde"); 
	        return user.getPerson();
	    }
	}
	
	
	public Person updateRegisteredPerson(Long id, Person person) {
        var p = personRepository.findById(id).get();
        if(p != null) {
        	
        	
        	
        	p.setName(person.getName());
        	p.setSurname(person.getSurname());
        	p.setPhonNumber(person.getPhonNumber());
        	p.setJmbg(person.getJmbg());
        	p.setGender(person.getGender());
        	p.setOccupation(person.getOccupation());
        	p.setInformationAboutCompany(person.getInformationAboutCompany());
        	p.setDateOfBirth(person.getDateOfBirth());
        	p.setBloodType(person.getBloodType());
        	p.setAddress(person.getAddress());
        	p.setPassword(passwordEncoder.encode(person.getPassword()));
        	List<Role> roles = roleService.findByName("ROLE_ADMIN_CENTER");
    		p.setRoles(roles);
        	p.setFirstLogin(person.isFirstLogin());
        	
            
        	personRepository.save(p);
        	
            return person;
        } else {
            return null;
        }
	}
}
