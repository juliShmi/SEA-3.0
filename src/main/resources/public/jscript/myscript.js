function getJson(irgendwas) { 	// irgendwas beinhaltet json mit allen kommunikations-metadaten
	return irgendwas.json();	// irgendwas.json ist der rheine json-inhalt
}


function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle = document.getElementById("table01");
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend", "<tr>"
			+ "<td>" + laufvariable.Salutation + "</td>"
			+ "<td>" + laufvariable.Firstname + "</td>"
			+ "<td>" + laufvariable.Lastname + "</td>"
			+ "</tr>")
		//	document.getElementById("psalut").textContent = laufvariable.Salutation;
		//	document.getElementById("pfn").textContent = laufvariable.Firstname;
		//	document.getElementById("pln").textContent = laufvariable.Lastname;
	}
}

function onInputClick(event) {
	event.preventDefault();
	console.log("click");

	var salut = document.getElementById("salut").value;
	console.log(salut);

	var fname = document.getElementById("fname").value;
	console.log(fname);

	var lname = document.getElementById("lname").value;
	console.log(lname);

	var jsonData = `{"Salutation": "${salut}", "Firstname": "${fname}", "Lastname":"${lname}"}`;
	console.log(jsonData);

	fetch("http://localhost:8080/json/person", {
		method: 'POST',
		body: jsonData,
		headers: { 'Content-Type': 'application/json' }
	});
}


var input = document.getElementById("submitButton");
input.addEventListener("click", onInputClick);


fetch("http://localhost:8080/json/persons/all")		//to add all participants from JSON Personen
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML) 	
	
		// entpricht: cell.textContent = myjson.personen[0].vorname);