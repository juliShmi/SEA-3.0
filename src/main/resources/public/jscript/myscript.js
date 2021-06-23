function getJson(irgendwas) { 	// irgendwas beinhaltet json mit allen kommunikations-metadaten
	return irgendwas.json();	// irgendwas.json ist der rheine json-inhalt
}


function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle = document.getElementById("table01");
	var i=1;
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend", "<tr>"
			+ `<td> ${i++} </td>`
			+ "<td>"+laufvariable.id+"</td>"
			+ "<td>" + laufvariable.salutation + "</td>"
			+ "<td>" + laufvariable.firstname + "</td>"
			+ "<td>" + laufvariable.lastname + "</td>"
			+ "<td>" + laufvariable.address + "</td>"
			+ "<td>" + laufvariable.email + "</td>"
			+ "</tr>")
		//	document.getElementById("psalut").textContent = laufvariable.Salutation;
		//	document.getElementById("pfn").textContent = laufvariable.Firstname;
		//	document.getElementById("pln").textContent = laufvariable.Lastname;
	}
}


function onInputClick(event) {
	event.preventDefault();
	console.log("click");
	
	var salutation = document.getElementById("salutationChoice").value;
	console.log(salutation);

	var firstname = document.getElementById("firstname").value;
	console.log(firstname);

	var lastname = document.getElementById("lastname").value;
	console.log(lastname);
	
	var address = document.getElementById("address").value;
	console.log(address);
	
	var email = document.getElementById("email").value;
	console.log(email);

	var jsonData = `{"salutation":"${salutation}", "firstname":"${firstname}", "lastname":"${lastname}","address":"${address}",
	"email":"${email}"}`;
	console.log(jsonData);

	fetch("http://localhost:8222/json/person", {
		method: 'POST',
		body: jsonData,
		headers: { 'Content-Type': 'application/json' }
	});
}

function deleteAll(event) {
	event.preventDefault();
	console.log("click");

	var jsonData = `{"salutation":null, "firstname":null, "lastname":null, "address": null; "email":null}`;
	console.log(jsonData);

	fetch("http://localhost:8222/json/persons/deleteall", {
		method: 'DELETE',
		body: jsonData,
		headers: { 'Content-Type': 'application/json' }
	});

}

function deleteByID(event) {
	event.preventDefault();
	console.log("click");
	var deletingID = parseInt(document.getElementById("deletePersonID").value);
	console.log(deletingID);
	fetch(`http://localhost:8222/json/person/${deletingID}`, {
		method: 'DELETE'
	});

}

function oninputupdateclick(event) {
	event.preventDefault(); 
	var id = document.getElementById("id").value;
	console.log(id)
	var anrede = document.getElementById("salutation").value;
	console.log(anrede);
	var vorname = document.getElementById("firstname").value;
	console.log(vorname);
	var nachname = document.getElementById("lastname").value;
	console.log(nachname);
	var address = document.getElementById("address").value;
	console.log(address);
	var email = document.getElementById("email").value;
	console.log(email);

	var jsondata = `{"id": "${id}", "salutation": "${salutation}", "firstname": "${firstname}", "lastname": "${lastname}", "address": "${address}", "email": "${email}"}`;
	console.log(jsondata);
	
	fetch(`/json/person`, {  
		method: 'PUT' ,
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
			}
		});
	}

// Update Button
var inputupdate = document.getElementById("update");
inputupdate.addEventListener("click", oninputupdateclick);

var deleteID = document.getElementById("deleteID");
deleteID.addEventListener("click", deleteByID);

var deleteAllInput = document.getElementById("deleteAll");
deleteAllInput.addEventListener("click", deleteAll);

var input = document.getElementById("submitButton");
input.addEventListener("click", onInputClick);


fetch("http://localhost:8222/json/persons/all")		//to add all participants from JSON Personen
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML)

		// entpricht: cell.textContent = myjson.personen[0].vorname);