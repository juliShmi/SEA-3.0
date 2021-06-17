package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
		System.out.println("PersonService instanziert: " + this.toString());

	}

	public int getSize() {
		return personRepository.getSize();
	}

	public Person get(int id) {
		return personRepository.getID(id);
	}

	public Personen getAllPersons() {
		return new Personen(personRepository.getAll());
	}

	public Person add(Person person) {
		personRepository.add(person);
		System.out.println("Person wurde angelegt!");
		return person;

	}

	public void deleteAll() {
		personRepository.deleteAll();
		System.out.println("List is clear! Size is: " + getSize());

	}

	public void deletePerson(Person person) {
		personRepository.deletePerson(person);
		System.out.println("Person deleted");
		// TODO Auto-generated method stub
		
	}

}
