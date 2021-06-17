package de.telekom.sea3.webserver.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository
public class PersonRepository {

	private List<Person> personen = new ArrayList<Person>();

	public PersonRepository() {
		super();
		System.out.println("PersonRepository instanziert: " + this.toString());
	}

	public int getSize() {
		return personen.size();
	}

	public boolean add(Person person) {
		return personen.add(person);

	}

	public List<Person> getAll() {
		return personen;
	}

	public void deleteAll() {
		personen.clear();
	}

	public Person getID(int id) {
		// TODO Auto-generated method stub
		return personen.get(id);
	}

	public void deletePerson(Person person) {
		personen.remove(person);
		
	}

}
