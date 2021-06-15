package de.telekom.sea3.webserver.model;

public class Person {

	private String Salutation;
	private String Firstname;
	private String Lastname;

	public String getSalutation() {
		return Salutation;
	}

	public void setSalutation(String salutation) {
		Salutation = salutation;
	}

	public String getFirstname() {
		return Firstname;
	}

	public void setFirstname(String firstname) {
		Firstname = firstname;
	}

	public String getLastname() {
		return Lastname;
	}

	public void setLastname(String lastname) {
		Lastname = lastname;
	}

}
