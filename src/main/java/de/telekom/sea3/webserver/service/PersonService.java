package de.telekom.sea3.webserver.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service

public class PersonService {

	private PersonRepository personRepository;
	static Logger logger = LoggerFactory.getLogger(PersonService.class);

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		this.personRepository = personRepository;
		logger.info(String.format("[INFO] PersonService instanziiert: %s", this.toString()));
		logger.info(String.format("[INFO] PersonRepo durch Annotation instanziiert: %s", personRepository.toString()));
	}

	public Long count() {
        return personRepository.count();
    }

	public Person findById(Long id) {
		if (personRepository.findById(id).isPresent()) {
			return personRepository.findById(id).get();
			}
			else
				return null;
	}

	public Personen getAllPersons() {
		return new Personen(personRepository.findAll());
	}

	public Person add(Person person) {
		personRepository.save(person);
		System.out.println("Person added!");
		return person;

	}

	public void deleteAll() {
		personRepository.deleteAll();
		System.out.println("List is clear! Size is: " + count());

	}

	public void deletePerson(Long id) {
		personRepository.deleteById(id);
		System.out.println("Person deleted");
		// TODO Auto-generated method stub
		
	}

	public Person update(Person person) {
		personRepository.save(person);
		System.out.println("Person updated!");
		return null;
	}
	
	public Personen selectPersonen(String ort) {
		Personen ps = new Personen();
		for (Person p : personRepository.selectPersonen(ort)) {
			((PersonService) ps.getPersonen()).add(p);
		}
		return ps;
	}

}
