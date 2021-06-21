package de.telekom.sea3.webserver.view;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import de.telekom.sea3.webserver.model.Doctor;
import de.telekom.sea3.webserver.service.DoctorWhoService;

@RestController
public class DoctorWhoController {
	
	private DoctorWhoService dws;
	
	DoctorWhoController(DoctorWhoService dws){
		this.dws = dws;
	}

	private static final String HTMLTEMPLATE ="<!DOCTYPE html>" + "<html lang='de'><head> <meta charset='utf-8'>"
			+ "<meta name='viewport' content='width=device-width, initial-scale=1.0'> " + "<title>Titel</title> "
			
			+ "</head> <body><ul>"			+ "				    <li><a href='https://en.wikipedia.org/wiki/Ninth_Doctor'>Ninth Doctor</a></li>"
			+ "				    <li><a href='https://en.wikipedia.org/wiki/Tenth_Doctor'>Tenth Doctor</a></li>"
			+ "				    <li><a href='https://en.wikipedia.org/wiki/Eleventh_Doctor'>Eleventh Doctor</a></li>"
			+ "				    <li><a href='https://en.wikipedia.org/wiki/Twelfth_Doctor'>Twelfth Doctor</a></li>"
			+ "				  </ul></body>" + "</html>";

	@RequestMapping("/doctor/9")
	public String returnNinth() {
		return "Greetings from <a href='https://en.wikipedia.org/wiki/Ninth_Doctor'>Ninth Doctor!</a>";
	}

	@RequestMapping("/doctor/10")
	public String returnTenth() {
		return "Greetings from <a href='https://en.wikipedia.org/wiki/Tenth_Doctor'>Tenth Doctor!</a>";
	}

	@RequestMapping("/doctor/11")
	public String returnEleventh() {
		return "Greetings from <a href='https://en.wikipedia.org/wiki/Eleventh_Doctor'>Eleventh Doctor!</a>";
	}

	@RequestMapping("/doctor/12")
	public String returnTwelfth() {
		return "Greetings from <a href='https://en.wikipedia.org/wiki/Twelfth_Doctor'>Twelfth Doctor!</a>";
	}

	@RequestMapping("/")
	public String returnLinkList() {
		return HTMLTEMPLATE;
	}
	
	@GetMapping("/doctor/<{incarnationNumber}>")
	public Doctor getQuestion(@PathVariable int incarnationNumber) {
	    if(incarnationNumber >= 1 && incarnationNumber <=8) {
	        throw new ResponseStatusException(HttpStatus.SEE_OTHER, "See another Doctor");
	    }
	    if(incarnationNumber>13 || incarnationNumber<1) {
	    	 throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible to retrieve the incarnation "+ incarnationNumber);
	    }
	    return dws.getById(incarnationNumber);
	}


}
