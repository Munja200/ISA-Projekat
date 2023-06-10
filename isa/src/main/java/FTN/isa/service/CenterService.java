package FTN.isa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.Center;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.model.DTOs.RegisteredUserDTO;
import FTN.isa.repository.CenterRepository;

@Service
public class CenterService {
	@Autowired
	private CenterRepository centerRepository;
	
	public Page<Center> findAll(Pageable pageable) {
		return centerRepository.findAll(pageable);
	}
	
	public List<Center> findAll() {
		return centerRepository.findAll();
	}
	
	public Center findById(String centerId) {
		return centerRepository.findById(Integer.parseInt(centerId));
	}
	
	public Center create(Center center) {
		return centerRepository.save(center);
	}
	
	public Page<Center> findAllByNameCity(Pageable pageable, String name, String city) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
		return centerRepository.findAllByNameCity(pageable, name, city);
	}
	
	public Page<Center> findAllByName(Pageable pageable, String name) {
		name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		return centerRepository.findAllByName(pageable, name);
	}
	
	public Page<Center> findAllByCity(Pageable pageable, String city) {
		city = city.substring(0, 1).toUpperCase() + city.substring(1).toLowerCase();
		return centerRepository.findAllByCity(pageable, city);
	}
	
	public Page<Center> findAllByAverageStreet(Pageable pageable, Float average, String street) {
		street = street.substring(0, 1).toUpperCase() + street.substring(1).toLowerCase();
		return centerRepository.findAllByAverageStreet(pageable, average, street);
	}
	
	public Page<Center> findAllByAverage(Pageable pageable, float average) {
		return centerRepository.findAllByAverage(pageable, average);
	}
	
	public Page<Center> findAllByStreet(Pageable pageable, String street) {
		street = street.substring(0, 1).toUpperCase() + street.substring(1).toLowerCase();
		return centerRepository.findAllByStreet(pageable, street);
	}
	
	 public CenterDTO findByAdminId(Long adminId) {
		 Center center = centerRepository.findByAdminId(adminId);
		    
		   
		    	CenterDTO centerDTO = new CenterDTO();
		    	
		    	centerDTO.setId(center.getId());
		    	centerDTO.setName(center.getName());
		    	centerDTO.setAddress(center.getAddress());
		    	centerDTO.setDescription(center.getDescription());
		    	centerDTO.setAverageRating(center.getAverageRating());
		    	centerDTO.setDeleted(false);

		    return centerDTO;

	 }


	
}
