package de.telekom.sea3.webserver.model;

import java.util.ArrayList;
import java.util.List;

public class Personen {

	private Iterable<Person> personen = new ArrayList<Person>();

	public Personen(Iterable<Person> iterable) {
		this.personen = iterable;
	}

	public Personen() {
	}

	public Iterable<Person> getPersonen() {
		return personen;
	}

	public void setPersonen(Iterable<Person>personen) {
		this.personen = personen;
	}

}
