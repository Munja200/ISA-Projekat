package FTN.isa.service;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import FTN.isa.model.Address;
import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.repository.IRegisteredUserRepository;

@Service
public class RegisteredUserService implements IRegisteredUserService {

    IRegisteredUserRepository registeredUserRepository;

	public RegisteredUserService(IRegisteredUserRepository registeredUserRepository) {

		this.registeredUserRepository = registeredUserRepository;
		/*
		Address address = new Address(87, 89, "Masarikova", "2", "Novi Sad", "Srbija");    
        String phoneNumber = "065/560-22-69";
        Person regPerson = new Person("Ana", "Anic", "ana@gmail.com", "ana", phoneNumber, "241000508019", 
        		"female", "student", "Ftn", null , Role.registerUser, "A", address);
        
        RegisteredUser registeredUser = new RegisteredUser(false, regPerson, null);
        registeredUserRepository.save(registeredUser);
        */
        
	}

	@Override
	public RegisteredUser saveRegisteredUser(RegisteredUser registeredUser) {
        return registeredUserRepository.save(registeredUser);
	}

	@Override
	public RegisteredUser findById(Long id) throws NoSuchElementException {
        return registeredUserRepository.findById(id).get();
	}

	@Override
	public Boolean updateRegisteredUser(Long id, RegisteredUser registeredUser) {
		var ru = registeredUserRepository.findById(id).get();
        if(ru != null) {
        	
        	Person person = new Person();
        	person.setName(registeredUser.getPerson().getName());
        	person.setSurname(registeredUser.getPerson().getSurname());
        	person.setPassword(registeredUser.getPerson().getPassword());
        	person.setJmbg(registeredUser.getPerson().getJmbg());
        	person.setOccupation(registeredUser.getPerson().getOccupation());
        	person.setGender(registeredUser.getPerson().getGender());
        	
        	ru.setPerson(person);
            registeredUserRepository.save(ru);
            return true;
        } else {
            return false;
        }
	}

}
