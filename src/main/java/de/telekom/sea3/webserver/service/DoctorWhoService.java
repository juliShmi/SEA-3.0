package de.telekom.sea3.webserver.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.telekom.sea3.webserver.model.Doctor;

@Service
public class DoctorWhoService {
	@RequestMapping(value = "/allDoctorsWho", method = RequestMethod.GET)
	public Doctor getById(int incarnationNumber) {

		// TODO Auto-generated method stub
		return null;
	}

}
