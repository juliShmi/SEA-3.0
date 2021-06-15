package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController2 {

	private PersonService personService;

	@Autowired
	public PersonController2(PersonService personService) {
		super();
		this.personService = personService;
		
	}
	
	@GetMapping("/allPersons")
	@ResponseBody
	public String getAllPersons() {
		Personen personen = personService.getAllPersons();
		//personen.toJson();
		String allPersons = "{\r\n"
				+ "\r\n"
				+ "\"personen\": [\r\n"
				+ "\r\n"
				+ "{\r\n"
				+ "\"Salutation\":\"Mr\",\r\n"
				+ "\"Firstname\":\"Tony\",\r\n"
				+ "\"Lastname\":\"Stark\"\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"Salutation\":\"Mr\",\r\n"
				+ "\"Firstname\":\"Peter\",\r\n"
				+ "\"Lastname\":\"Parker\"\r\n"
				+ "},\r\n"
				+ " {\r\n"
				+ "\"Salutation\":\"Mrs\",\r\n"
				+ "\"Firstname\":\"Natasha\",\r\n"
				+ "\"Lastname\":\"Romanoff\"\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"Salutation\":\"Mr\",\r\n"
				+ "\"Firstname\":\"Bruce\",\r\n"
				+ "\"Lastname\":\"Banner\"\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"Salutation\":\"Mr\",\r\n"
				+ "\"Firstname\":\"Thor\",\r\n"
				+ "\"Lastname\":\"Odynsson\"\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"Salutation\":\"Mr\",\r\n"
				+ "\"Firstname\":\"Scott\",\r\n"
				+ "\"Lastname\":\"Lang\"\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}";
		//String alternative = String.format(HTMLTEMPLATE, personService.getSize());
		//String alternative2 = String.valueOf(personService.getSize());
		// return http als String
		return allPersons;
	}

//	// URL: "http://localhost:8080/size"
//	@GetMapping("/size")
//	@ResponseBody
//	public String getSize() {
//		String alternative = String.format(HTMLTEMPLATE, personService.getSize());
//		//String alternative2 = String.valueOf(personService.getSize());
//		// return http als String
//		return alternative;
//	}

}
