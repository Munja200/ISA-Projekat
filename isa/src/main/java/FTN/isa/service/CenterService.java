package FTN.isa.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.Address;
import FTN.isa.model.Center;
import FTN.isa.model.RadnoVreme;
import FTN.isa.model.Person;
import FTN.isa.model.RegisteredUser;
import FTN.isa.model.Termin;
import FTN.isa.model.DTOs.CenterDTO;
import FTN.isa.model.DTOs.CenterWithTerminDTO;
import FTN.isa.model.DTOs.RegisteredUserDTO;
import FTN.isa.model.DTOs.TerminDTO;
import FTN.isa.repository.CenterRepository;

@Service
public class CenterService {
	@Autowired
	private CenterRepository centerRepository;
	
	public Page<Center> findAll(Pageable pageable) {
		return centerRepository.findAll(pageable);
	}
	
	public Center getById(Long id) {
		return centerRepository.getOne(id);
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
		   
		    	CenterDTO centerDTO = new CenterDTO(center);
		    	
		    	/*centerDTO.setId(center.getId());
		    	centerDTO.setName(center.getName());
		    	centerDTO.setAddress(center.getAddress());
		    	centerDTO.setDescription(center.getDescription());
		    	centerDTO.setAverageRating(center.getAverageRating());
		    	centerDTO.setDeleted(false);
		    	centerDTO.setRadnoVreme(center.getRadnoVreme());*/

		    return centerDTO;

	 }
	 
	 public Boolean updateCenter(Long id, Center center) {
	        var c = centerRepository.getOne(id);
	        
	        if(c != null) {
	        	
	        	
	        	c.setName(center.getName());
	        	
	        	Address adresa = new Address();
	        	adresa.setCountry(center.getAddress().getCountry());
	        	adresa.setCity(center.getAddress().getCity());
	        	adresa.setStreet(center.getAddress().getStreet());
	        	adresa.setNumber(center.getAddress().getNumber());
	        	
	        	c.setAddress(adresa);
	        	
	        	c.setDescription(center.getDescription());
	        	c.setAverageRating(center.getAverageRating());
	        	
	        	centerRepository.save(c);
	        	
	            return true;
	        } else {
	            return false;
	        }
		}

	 	
	 	/*
	 public List<Center> getCentersbyDateWithFreeAppointments(String datum) {
		    List<Center> centers = new ArrayList<Center>();

		    for (Center c : findAll()) {
		        
		        for (RadnoVreme rv : c.getRadnoVreme()) {
		            LocalDateTime otvaranje = rv.getVremeOtvaranja();
		            LocalDateTime zatvaranje = rv.getVremeZatvaranja();
		            LocalDateTime dateTime = LocalDateTime.parse(datum, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
		            if (dateTime.isAfter(otvaranje) && dateTime.isBefore(zatvaranje)) {
		                
		                // Da li ima neki termin koji upada u ovaj datum?
		                for (Termin t : c.getTermini()) {
		                    LocalDateTime pocetak = t.getPocetakTermina();
		                    LocalDateTime kraj = t.getKrajTermina();
		                    
		                    // DateTime upada u vremenski interval slobodnog termina
		                    if (!dateTime.isAfter(pocetak) && !dateTime.isBefore(kraj)) {
		    		            centers.add(c);
		    		            break;
		                    }
		                } 
		                break; 
		            }
		        }
		    }
		    return centers;
		}
		*/

	 public List<CenterWithTerminDTO> getCentersbyDateWithFreeAppointments(String datum) {
		 
		    List<CenterWithTerminDTO> lista = new ArrayList<CenterWithTerminDTO>();
		    List<Center> centers = new ArrayList<Center>();

		    for (Center c : findAll()) {
		        
			    CenterWithTerminDTO list = new CenterWithTerminDTO();

		        for (RadnoVreme rv : c.getRadnoVreme()) {
		            LocalDateTime otvaranje = rv.getVremeOtvaranja();
		            LocalDateTime zatvaranje = rv.getVremeZatvaranja();
		            LocalDateTime dateTime = LocalDateTime.parse(datum, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));
		            if (dateTime.isAfter(otvaranje) && dateTime.isBefore(zatvaranje)) {
		                
		                // Da li ima neki termin koji upada u ovaj datum?
		                for (Termin t : c.getTermini()) {
		                    LocalDateTime pocetak = t.getPocetakTermina();
		                    LocalDateTime kraj = t.getKrajTermina();
		                    
		                    // DateTime upada u vremenski interval slobodnog termina
		                    if (dateTime.isAfter(pocetak) && dateTime.isBefore(kraj)) {
		    		            //centers.add(c);
		                    	
		                    	CenterDTO centarDto = new CenterDTO(c);
		                    	TerminDTO terminDto = new TerminDTO(t);

		                    	list.setId(c.getId());
		    		            list.setCenterDTO(centarDto);
		    		            list.setTerminDTO(terminDto);
		    			        lista.add(list);

		    		            break;
		                    }
		                } 
		                break; 
		            }
		        }
		    }
		    return lista;
		}



	
}
