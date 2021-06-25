function getJson(irgendwas) { 	// irgendwas beinhaltet json mit allen kommunikations-metadaten
	return irgendwas.json();	// irgendwas.json ist der rheine json-inhalt
}


function getTxtFromJsonUndPackInsHTML(myjson) {
	var tabelle = document.getElementById("table01");
	for (var laufvariable of myjson.personen) {
		// neue Zeile am Ende der exist. Tabelle anfügen
		tabelle.insertAdjacentHTML("beforeend", "<tr>"
			+ "<td>"+laufvariable.id+"</td>"
			+ "<td>" + laufvariable.salutation + "</td>"
			+ "<td>" + laufvariable.firstname + "</td>"
			+ "<td>" + laufvariable.lastname + "</td>"
			+ "<td>" + laufvariable.address + "</td>"
			+ "<td>" + laufvariable.email + "</td>"
			+ "<td>" + laufvariable.version + "</td>"
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
	
	var version = document.getElementById("version").value;
	console.log(version);

	var jsonData = `{"salutation":"${salutation}", "firstname":"${firstname}", "lastname":"${lastname}","address":"${address}",
	"email":"${email}"}`;
	console.log(jsonData);

	fetch("http://localhost:8222/json/persons", {
		method: 'POST',
		body: jsonData,
		headers: { 'Content-Type': 'application/json' }
	}).then(refreshTable);
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
	}).then(refreshTable);

}

function deleteByID(event) {
	event.preventDefault();
	console.log("click");
	var deletingID = parseInt(document.getElementById("deletePersonID").value);
	console.log(deletingID);
	fetch(`http://localhost:8222/json/persons/${deletingID}`, {
		method: 'DELETE'
	}).then(refreshTable);

}

function refreshTable() {
	fetch("/json/persons/all")
	.then(getJson)
	.then(getTxtFromJsonAndPackInHTML)
	}
	
function onRefreshClick(event) {
	event.preventDefault();      // verhindert dass das event von Browser verwendet wird (verhindert GET-Request)
	console.log("click");


    refreshTable();
}


function oninputupdateclick(event) {
	event.preventDefault(); 
	var id = document.getElementById("id").value;
	console.log(id);
	var salutation = document.getElementById("salutationChoice").value;
	console.log(anrede);
	var vorname = document.getElementById("firstname").value;
	console.log(vorname);
	var nachname = document.getElementById("lastname").value;
	console.log(nachname);
	var address = document.getElementById("address").value;
	console.log(address);
	var email = document.getElementById("email").value;
	console.log(email);
	var version = document.getElementById("version").value;
	console.log(version);

	var jsondata = `{"id": "${id}","salutation": "${salutation}", "firstname": "${firstname}", "lastname": "${lastname}", "address": "${address}", "email": "${email}", "version": "${version}"}`;
	console.log(jsondata);
	
	fetch(`/json/persons`, {  
		method: 'PUT' ,
		body: jsondata,
		headers: {
			'Content-Type': 'application/json'
			}
		}).then(refreshTable);
	}

// Update Button
var inputupdate = document.getElementById("update");
inputupdate.addEventListener("click", oninputupdateclick);

var refreshButton = document.getElementById("refreshButton");
refreshButton.addEventListener("click",onRefreshClick);

var deleteID = document.getElementById("deleteID");
deleteID.addEventListener("click", deleteByID);

var deleteAllInput = document.getElementById("deleteAll");
deleteAllInput.addEventListener("click", deleteAll);

var input = document.getElementById("submitButton");
input.addEventListener("click", onInputClick);


fetch("/json/persons/all")		//to add all participants from JSON Personen
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML)

		// entpricht: cell.textContent = myjson.personen[0].vorname);