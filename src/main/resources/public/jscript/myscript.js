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
		//		document.getElementById("psalut").textContent = laufvariable.Salutation;
		//		document.getElementById("pfn").textContent = laufvariable.Firstname;
		//		document.getElementById("pln").textContent = laufvariable.Lastname;
	}
}
fetch("personen.json")
	.then(getJson) 								//  entspricht: .then( irgendwas => irgendwas.json() )
	.then(getTxtFromJsonUndPackInsHTML) 		// entpricht: cell.textContent = myjson.personen[0].vorname);