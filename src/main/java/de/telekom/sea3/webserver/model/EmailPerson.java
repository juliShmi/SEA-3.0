package de.telekom.sea3.webserver.model;

import javax.persistence.Entity;


public class EmailPerson {
	
	private String addresse;
	private String email;
	public String getAddresse() {
		return addresse;
	}
	public void setAddresse(String addresse) {
		this.addresse = addresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
