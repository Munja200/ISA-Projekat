package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.Center;
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
}
