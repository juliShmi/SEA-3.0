package de.telekom.sea3.webserver.model;

import java.util.ArrayList;
import java.util.List;

public class DoctorList {
	private List<Doctor> doctors = new ArrayList<Doctor>();

	public List<Doctor> getDoctors() {
		return doctors;
	}

	public void setDoctors(List<Doctor> doctors) {
		this.doctors = doctors;
	}
	

}
