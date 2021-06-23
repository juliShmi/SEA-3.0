package de.telekom.sea3.webserver.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.repo.PersonRepository;
import de.telekom.sea3.webserver.service.PersonService;

@RestController
@RequestMapping
public class PersonController2 {

	@Autowired
	private PersonRepository personRepository;

	@GetMapping("/json/persons/all")
	public List<Person> getAllPersons() {
		return (List<Person>) personRepository.findAll();
	}

	@GetMapping("/json/persons/size")
	public void getSize() {
		System.out.println(personRepository.count());
	}

	@GetMapping("/json/persons/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long id) {
		Person person = (Person) personRepository.findById(id).get();

		return ResponseEntity.ok().body(person);

	}

	@PostMapping("/json/person")
	public Person addPerson(@RequestBody Person person) {
		return personRepository.save(person);
	}

	@PutMapping("/json/person/update/{id}")
	public ResponseEntity<Person> updateEmployee(@PathVariable(value = "id") Long id,
			@RequestBody Person personDetails) {
		Person person = personRepository.findById(id).get();
		person.setEmail(personDetails.getEmail());
		person.setLastname(personDetails.getLastname());
		person.setFirstname(personDetails.getFirstname());
		final Person updatedperson = personRepository.save(person);
		return ResponseEntity.ok(updatedperson);
	}

	@DeleteMapping("/json/persons/deleteall")
	public void deleteAll() {
		personRepository.deleteAll();
	}

	@DeleteMapping("/json/person/{id}")
	public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long id) {
		Person person = personRepository.findById(id).get();
		personRepository.delete(person);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;

	}

}
