package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.RegisteredUser;
import FTN.isa.repository.RegisteredUserRepository;

@Service
public class RegisteredUserService {
	@Autowired
	private RegisteredUserRepository registeredUserRepository;
	
	public Page<RegisteredUser> findAll(Pageable pageable) {
		return registeredUserRepository.findAll(pageable);
	}
	
	public List<RegisteredUser> findAll() {
		return registeredUserRepository.findAll();
	}
	
	public List<RegisteredUser> findAllByNameSurname(String name, String surname) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
		return registeredUserRepository.findAllByNameSurname(name, surname);
	}
	
	public List<RegisteredUser> findAllByName(String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		return registeredUserRepository.findAllByName(name);
	}
	
	public List<RegisteredUser> findAllBySurname(String surname) {
		surname = surname.substring(0, 1).toUpperCase() + surname.substring(1).toLowerCase();
		return registeredUserRepository.findAllBySurname(surname);
	}
	
	public RegisteredUser create(RegisteredUser registeredUser) {
		return registeredUserRepository.save(registeredUser);
	}
}
