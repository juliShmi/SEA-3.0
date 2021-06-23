package de.telekom.sea3.webserver.service;

import java.util.Optional;

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
		
	}

	public long count() {
		return personRepository.count();
	}

	public Optional<Person> findById(Long id) {
		return personRepository.findById(id);
	}

	public Personen getAllPersons() {
		return new Personen(personRepository.findAll());
	}

	public Person add(Person person) {
		personRepository.save(person);
		System.out.println("Person wurde angelegt!");
		return person;

	}

	public void deleteAll() {
		personRepository.deleteAll();
		System.out.println("List is clear! Size is: " + count());

	}

	public void deletePerson(long id) {
		personRepository.deleteById(id);
		System.out.println("Person deleted");
		// TODO Auto-generated method stub
		
	}

}
