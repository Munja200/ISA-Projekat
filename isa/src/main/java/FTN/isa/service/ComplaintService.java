package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FTN.isa.model.Complaint;
import FTN.isa.repository.ComplaintRepository;

@Service
public class ComplaintService {

	@Autowired
	private ComplaintRepository complaintRepository;
	
	public Page<Complaint> findAll(Pageable pageable) {
		return complaintRepository.findAll(pageable);
	}
	
	public List<Complaint> findAll(){
		return complaintRepository.findAll();
	}
	
	public Page<Complaint> findAllToAnswer(Pageable pageable){
		return complaintRepository.findAllToAnswer(pageable);
	}

	public Complaint save(Complaint complaint) {
		return complaintRepository.save(complaint);
	}
	
	public Complaint findById(int complaintId) {
		return complaintRepository.findById(complaintId);
	}
	
	public Page<Complaint> findByPersonId(Pageable pageable, String personId) {
		return complaintRepository.findByPersonId(pageable, personId);
	}
	
}
