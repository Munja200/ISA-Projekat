package FTN.isa.service;

import java.util.NoSuchElementException;
import FTN.isa.model.RegisteredUser;
import FTN.isa.modelDTO.RegisteredUserDTO;

public interface IRegisteredUserService {
	
	RegisteredUser saveRegisteredUser(RegisteredUser registeredUser);
	
	RegisteredUser findById(Long id) throws NoSuchElementException;
	
    Boolean updateRegisteredUser(Long id, RegisteredUser registeredUser);
}
