package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.AdministratorCenter;
import FTN.isa.repository.AdministratorCenterRepository;

@Service
public class AdministratorCenterService {

	@Autowired
	private AdministratorCenterRepository administratorCenterRepository;
	
	public List<AdministratorCenter> findAll() {
		return administratorCenterRepository.findAll();
	}
	
	public AdministratorCenter create(AdministratorCenter administratorCenter) {
		return administratorCenterRepository.save(administratorCenter);
	}
	
	public AdministratorCenter getAdministratorCenterByUsername(String username) {
		return administratorCenterRepository.getAdministratorCenterByUsername(username);
	}
}
