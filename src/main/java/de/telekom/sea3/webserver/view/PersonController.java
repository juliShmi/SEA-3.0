package de.telekom.sea3.webserver.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.WebContext;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
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
		String alternative = String.format(HTMLTEMPLATE, personService.count());
		// String alternative2 = String.valueOf(personService.getSize());
		// return http als String
		return alternative;
	}

	// URL:"http://localhost:8080/count"
	@GetMapping("/count")
	public String getCount(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		String string = "Hallo";
		model.addAttribute("cou", name); // cou Platzhalter in der HTML Seite
		return "count";
	}
//	@GetMapping("/count")
//	public String getCount(Model model) {
//		String string5 = "count"; //name of html file -> template count
//		String hello = "hi all people";
//		model.addAttribute("name", hello);
//		return string5;
//	}

	// URL:"http://localhost:8080/count"
	@GetMapping("/size2") // Kein @ResponseBody, da es ... verhindert
	public String getSize2(Model model) {
		model.addAttribute("size3", personService.count());
		return "size";
	}

	@GetMapping("/personenList") // Kein @ResponseBody, da es ... verhindert
	public String showAll(Model model) {
		model.addAttribute("personen", personService.getAllPersons().getPersonen()); //need to return the list not the Object
		return "personenList.html";
	}

}
