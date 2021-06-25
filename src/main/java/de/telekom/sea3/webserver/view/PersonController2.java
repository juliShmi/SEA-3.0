package de.telekom.sea3.webserver.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.repo.PersonRepository;
import de.telekom.sea3.webserver.service.PersonService;

@RestController
@RequestMapping
public class PersonController2 {
	
	private PersonService personService;
	
	static Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	@Autowired
	public PersonController2(PersonService personService) {
		this.personService=personService;
	}


	@GetMapping("/json/persons/all")
	public Personen getAllPersons() {
		Personen p = personService.getAllPersons();
		return p;
		
	}

	@GetMapping("/json/persons/size")
	public Long getSize() {
		return personService.count();
	}

	@GetMapping("/json/persons/{id}")
	 public Person getPerson(@PathVariable ("id") Long id) {
        return personService.findById(id);

	}

	@PostMapping("/json/persons")
	 public Person addPerson(@RequestBody Person person) {
        return personService.add(person);
	}

	@PutMapping("/json/persons")
	public Person updatePerson(@RequestBody Person person) {
		return personService.update(person);
	}

	@DeleteMapping("/json/persons/deleteall")
	public void deleteAll() {
		personService.deleteAll();
	}

	@DeleteMapping("/json/persons/{id}")
	public void deletePerson(@PathVariable ("id") Long id) {
        personService.deletePerson(id);

	}
	@GetMapping("/json/select")
	public Personen searchNachOrt(@RequestParam(name="ort", required=false) String ort) {
		Personen personen = personService.selectPersonen(ort);
		logger.info("Ort: " + ort);
		return personen;
	}
	

}
