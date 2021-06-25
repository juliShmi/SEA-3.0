package de.telekom.sea3.webserver.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import de.telekom.sea3.webserver.model.Doctor;

@Service
public class DoctorWhoService {
	@RequestMapping(value = "/allDoctorsWho", method = RequestMethod.GET)
	public Doctor getById(int incarnationNumber) {
		String doctor = null;
		String pathToJson = "/SEA-3.0/src/main/resources/public/allDoctorWho.json";
		JSONObject obj = new JSONObject(pathToJson);
		JSONArray arr = obj.getJSONArray("newDoctors");

		if (incarnationNumber == 9) {
			doctor = arr.getJSONObject(0).getString("number");
			System.out.println(doctor);
		}

		if (incarnationNumber == 10) {
			doctor = arr.getJSONObject(1).getString("number");
			System.out.println(doctor);
		}
		if (incarnationNumber == 11) {
			doctor = arr.getJSONObject(2).getString("number");
			System.out.println(doctor);
		}

		if (incarnationNumber == 12) {
			doctor = arr.getJSONObject(3).getString("number");
			System.out.println(doctor);
		}

		if (incarnationNumber == 13) {
			doctor = arr.getJSONObject(4).getString("number");
			System.out.println(doctor);
		}

		// TODO Auto-generated method stub
		return null;
	}

}
