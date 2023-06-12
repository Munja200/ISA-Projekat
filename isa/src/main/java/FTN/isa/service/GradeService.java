package FTN.isa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Address;
import FTN.isa.model.Center;
import FTN.isa.model.Grade;
import FTN.isa.repository.GradeRepository;

@Service
public class GradeService {
	
	@Autowired
	private GradeRepository gradeRepository;
	
	public Grade create(Grade grade) {
		return gradeRepository.save(grade);
	}
	
	public Grade findById(Long id) {
		return gradeRepository.getOne(id);
	}

	public Boolean updateGrade(Long id, Grade grade) {
	        var g = gradeRepository.getOne(id);
	        
	        if(g != null) {
	        	
	        	
	        	g.setId(grade.getId());
	        	g.setPersonId(grade.getPersonId());
	        	g.setScore(grade.getScore());
	        	g.setCenterId(grade.getCenterId());
	        	
	        	gradeRepository.save(g);
	        	
	            return true;
	        } else {
	            return false;
	        }
		}
	
	public Grade findGradeByCenterId(long centerId) {
	    Grade grade = gradeRepository.findByCenterId(centerId);
	    if (grade == null) {
	        grade = new Grade();
	        grade.setCenterId(centerId);
	        grade.setScore(0);
	    }
	    return grade;
	}
	
	public Grade findGradeByCenterAndPersonId(long centerId, long personId) {
	    Grade grade = gradeRepository.findGradeByCenterIdAndPersonId(centerId, personId);
	    if (grade == null) {
	        grade = new Grade();
	        grade.setCenterId(centerId);
	        grade.setPersonId(personId);
	        grade.setScore(0);
	    }
	    return grade;
	}



}
