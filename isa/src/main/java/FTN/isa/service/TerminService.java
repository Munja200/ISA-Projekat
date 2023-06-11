package FTN.isa.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Center;
import FTN.isa.model.Termin;
import FTN.isa.repository.TerminRepository;

@Service
public class TerminService {
	
	@Autowired
	private TerminRepository terminRepository;
	
	public List<Termin> getTerminiByCenterId(Long id) {
		return terminRepository.getTerminiByCenterId(id);
	}
	
	public Termin createTermin(Termin termin) {
		return terminRepository.save(termin);
	}
	
	public Termin getById(Long id) {
		return terminRepository.getOne(id);
	}
}
