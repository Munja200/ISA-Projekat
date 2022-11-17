package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Center;
import FTN.isa.repository.CenterRepository;

@Service
public class CenterService {
	@Autowired
	private CenterRepository centerRepository;
	
	public List<Center> findAll() {
		return centerRepository.findAll();
	}
}
