package FTN.isa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Center;
import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.Termin;
import FTN.isa.model.DTOs.TerminDTO;
import FTN.isa.repository.TerminRepository;

@Service
public class TerminService {
	
	@Autowired
	private TerminRepository terminRepository;
	
	public List<Termin> getTerminiByCenterId(Long id) {
		return terminRepository.getTerminiByCenterId(id);
	}
	
	public List<Termin> getSlobodniTerminiByCenterId(Long id) {
		
		List<Termin> termini = new ArrayList<Termin>();

		for(Termin t : getTerminiByCenterId(id)){
			if(t.getKorisnikId() == null) {
				termini.add(t);
			}
		}
		return termini;
	}
	
	//samo ovde kasnije dodas proveru, da je izvestaj null
	public List<Termin> getTerminiByKorId(Long id) {
		return terminRepository.getTerminiByKorId(id);
	}
	
	public List<Termin> getZauzetiTerminiByCenterId(Long id) {
		List<Termin> termini = new ArrayList<Termin>();

		for(Termin t : getTerminiByCenterId(id)){
			if(t.getKorisnikId() != null) {
				termini.add(t);
			}
		}
		return termini;	
	}
	
	public Termin createTermin(Termin termin) {
		return terminRepository.save(termin);
	}
	
	public Termin getById(Long id) {
		return terminRepository.getOne(id);
	}
	
	public Boolean updateTermin(Long id, Long korId,  TerminDTO terminDTO) {
        
        Termin termin = getById(id);
        
        if(termin != null) {
        	
        	//termin.setKorisnikId(korId);
        	termin.setKorisnikId(terminDTO.getKorisnikId());

        	terminRepository.save(termin);
            return true;
        } else { 
            return false;
        }
	}
}
