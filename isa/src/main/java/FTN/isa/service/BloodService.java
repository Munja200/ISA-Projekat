package FTN.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Blood;
import FTN.isa.model.Center;
import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.Role;
import FTN.isa.model.DTOs.BloodDTO;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.model.DTOs.RegisteredUserDTO;
import FTN.isa.repository.BloodRepository;
import FTN.isa.repository.CenterRepository;

@Service
public class BloodService {
	
	@Autowired
	private BloodRepository bloodRepository;
	
	public List<BloodDTO> findByCenterId(Long centerId) {
		List<Blood> bloods = bloodRepository.findByCenterId(centerId);
	    List<BloodDTO> bloodDTOs = new ArrayList<>();

	    for (Blood blood : bloods) {
	        BloodDTO bloodDTO = new BloodDTO();
	        bloodDTO.setId(blood.getId());
	        bloodDTO.setBloodType(blood.getBloodType());
	        bloodDTO.setQuantity(blood.getQuantity());

	        bloodDTOs.add(bloodDTO);
	    }

	    return bloodDTOs;

	 }
	
	public Blood create(Blood blood) {
		return bloodRepository.save(blood);
	}
	
	public Boolean updateBlood(long centerId, int quantity, String bloodType) {
	    List<Blood> b = bloodRepository.findByCenterId(centerId);
	    Blood krvvvv = new Blood();

	    for (Blood krv : b) {
	        if (krv.getBloodType().equals(bloodType)) {
	            krv.setQuantity(krv.getQuantity() - quantity);
	            bloodRepository.save(krv);
	            return true;
	            }
	    }
	    
	    return false;
	}

}

