// Chargement du listener à l'ouverture de la fenêtre
window.onload = listenerSaisie;


/**
 * Listener du champs de saisie
 * @returns
 */
function listenerSaisie() {
	var saisie = document.querySelector ('#lettres');
	saisie.onkeyup = dynamicSearch;
}

/**
 * Récupère la saisie et l'envoie à la servlet puis retourne la liste des clients
 * @returns
 */
function dynamicSearch() {
	var xhr = null;
	
	xhr = initConnect();
	
	console.log("1-xhr : "+xhr)
	
	// Requète
	
	xhr.open("GET", "../RechercheClient?saisie=" + document.querySelector ('#lettres').value, true);
	console.log("2-xhr : "+xhr)
	xhr.onreadystatechange = function() {
		if (xhr.readyState==4)
		document.querySelector('#response').innerHTML = xhr.responseText;
		}
	
	xhr.send(null);
	console.log("3-xhr : "+xhr)
}

/**
 * Initialise l'objet XMLHttpRequest
 * @returns
 */
function initConnect() {
	var xhr = null;
	
	if (window.XMLHttpRequest) xhr = new XMLHttpRequest();
	else if (window.ActiveXObject) { // Internet Explorer
	try { xhr = new ActiveXObject("Msxml2.XMLHTTP"); }
	catch (e) { xhr = new ActiveXObject("Microsoft.XMLHTTP"); }
	}
	return xhr;
}
