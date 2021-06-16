package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@RestController
public class PersonController2 {

	private PersonService personService;

	@Autowired
	public PersonController2(PersonService personService) {
		super();
		this.personService = personService;

	}

	// URL: @see <a href="http://localhost:8080/json/persons/all"></a>
	@GetMapping("json/persons/all")
	public Personen getAllPersons() {
		Personen personen = personService.getAllPersons();
		return personen;
	}

	// URL: "http://localhost:8080/size"
	@GetMapping("json/persons/size")
	public Integer getSize() {
		int size = personService.getSize();
//		String string1 = String.format("{\n" + "	\"size\": %d\n" + "}", size);
		return size;
	}

	@GetMapping("json/persons/{id}")
	public Person getPerson(@PathVariable("id") int id) {
		return personService.get(id);

	}

	@PostMapping("json/person")
	public Person addPerson(@RequestBody Person person) {
		return personService.add(person);
	}

}