package FTN.isa.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import FTN.isa.service.PersonService;

@Controller
public class StaticControler {

	@Autowired
	private PersonService service;
	
		
	
	@GetMapping("/verify/{id}") 
	public void verifyUser(@PathVariable("id") String id) { 
		System.out.println("usao je");
		service.verify(id);
		//	return "verify_success";
	//	} else {
	//		return "templates/verify_fail";
		
	}
	
}
