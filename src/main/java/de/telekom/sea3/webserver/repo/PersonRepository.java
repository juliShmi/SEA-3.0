package de.telekom.sea3.webserver.repo;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
	
	public PersonRepository() {
		super();
		System.out.println("PersonRepository instanziert: " +this.toString());
	}
	
	public int getSize() {
		return 0;
	}

}
