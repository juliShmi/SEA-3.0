package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.repo.PersonRepository;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController {

	private PersonService personService;
	private static final String HTMLTEMPLATE = "<!DOCTYPE html>" + "<html lang='de'><head> <meta charset='utf-8'>"
			+ "<meta name='viewport' content='width=device-width, initial-scale=1.0'> " + "<title>Titel</title> "
			+ "</head> <body>size: %d</body>" + "</html>";

	@Autowired
	public PersonController(PersonService personService) {
		super();
		System.out.println("PersonController instanziert: " + this + toString());
		this.personService = personService;
		System.out.println("PersonService instanziert: " + this.personService.toString());
	}

	// URL: "http://localhost:8080/size"
	@GetMapping("/size")
	@ResponseBody
	public String getSize() {
		String alternative = String.format(HTMLTEMPLATE, personService.getSize());
		//String alternative2 = String.valueOf(personService.getSize());
		// return http als String
		return alternative;
	}

}
