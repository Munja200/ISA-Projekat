package FTN.isa.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.Center;
import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.Termin;
import FTN.isa.model.DTOs.TerminDTO;
import FTN.isa.repository.PersonRepository;
import FTN.isa.repository.TerminRepository;

@Service
public class TerminService {
	
	@Autowired
	private TerminRepository terminRepository;
	
	@Autowired
	private PersonRepository personRepository;
	
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
	
	public List<Termin> getProsliTerminiByUser(Long id) {
		
		List<Termin> termini = new ArrayList<Termin>();
		List<Termin> poUseru = terminRepository.getTerminiByUserId(id);

		for(Termin t : poUseru) {
			if(t.getReport() != null) {
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
	
   public Boolean updateTermina(Long id,TerminDTO terminDTO) {
        Termin termin = getById(id);
        
        if(termin != null) {
        	termin.setReport(terminDTO.getReport());
        	terminRepository.save(termin);
            return true;
        } else { 
            return false;
        }
	}
   
   public Boolean updateTerminaQF(Long id,TerminDTO terminDTO) {
       Termin termin = getById(id);
       
       if(termin != null) {
       	termin.setQuestionForm(terminDTO.getQuestionForm());
       	terminRepository.save(termin);
           return true;
       } else { 
           return false;
       }
	}
	
	public List<Termin> findAllByImePrezime(String ime, String prezime, Long centerId) {
		List<Termin> lista= new ArrayList<>();
		
		ime = ime.substring(0, 1).toUpperCase() + ime.substring(1).toLowerCase();
		prezime = prezime.substring(0, 1).toUpperCase() + prezime.substring(1).toLowerCase();
		
		for(Termin t : getZauzetiTerminiByCenterId(centerId)){
			Person person = new Person();
			person = personRepository.getOne(t.getKorisnikId());
			if(person.getName().equals(ime) && person.getSurname().equals(prezime)) {
				lista.add(t);
			}
		}
		return lista;
		
	}
	
	public List<Termin> findAllByIme(String ime, Long centerId) {
		List<Termin> lista= new ArrayList<>();
		ime = ime.substring(0, 1).toUpperCase() + ime.substring(1).toLowerCase();

		for(Termin t : getZauzetiTerminiByCenterId(centerId)){
			Person person = new Person();
			person = personRepository.getOne(t.getKorisnikId());
			if(person.getName().equals(ime)) {
				lista.add(t);
			}
		}
		return lista;
	}
	

	public List<Termin> findAllByPrezime(String prezime, Long centerId) {
		List<Termin> lista= new ArrayList<>();
		prezime = prezime.substring(0, 1).toUpperCase() + prezime.substring(1).toLowerCase();
		
		for(Termin t : getZauzetiTerminiByCenterId(centerId)){
			Person person = new Person();
			person = personRepository.getOne(t.getKorisnikId());
			if(person.getSurname().equals(prezime)) {
				lista.add(t);
			}
		}
		return lista;
	}
}
