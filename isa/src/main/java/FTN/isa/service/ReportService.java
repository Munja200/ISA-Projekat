package FTN.isa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FTN.isa.model.Center;
import FTN.isa.model.Report;
import FTN.isa.repository.CenterRepository;
import FTN.isa.repository.ReportRepository;

@Service
public class ReportService {
	
	@Autowired
	private ReportRepository reportRepository;
	
	public Report getById(Long id) {
		return reportRepository.getOne(id);
	}
	
	public List<Report> findAll() {
		return reportRepository.findAll();
	}
	
	public Report findById(long reportId) {
		return reportRepository.findById(reportId);
	}
	
	public Report create(Report report) {
		return reportRepository.save(report);
	}
	
	

}
