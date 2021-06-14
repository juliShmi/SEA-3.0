package de.telekom.sea3.webserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // new Person();
public class Person {

	private Hund hund;
	private Katze katze;

	@Autowired
	public Person(Hund hund, Katze katze) { // constructor is optional just to show how component works
		this.hund = hund;
		this.katze = katze;
		System.out.println("Person erzeugt" + (this.hund != null));
		System.out.println(this.hund.toString());
		System.out.println(this.katze.toString());
	}

}
