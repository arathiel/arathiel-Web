// Chargement du listener à l'ouverture de la fenêtre
window.onload = listenerSaisie;


/**
 * Listener du champs de saisie
 * @returns
 */
function listenerSaisie() {
	console.log('Dans listenerSaisie');
	
	$('#saisieNom').bind('keyup', dynamicSearch);
}

/**
 * Récupère la saisie et l'envoie à la servlet puis retourne la liste des traits
 * @returns
 */
function dynamicSearch() {
	console.log("Entrée dans dynamicSearch")
	
	$.ajax({
		url			: 'erreur',
		type 		: 'GET',
		data 		: 'saisieNom=' + $('#saisieNom').val(),
		dataType	: 'HTML',
		
		success : function(code_html, statut){ 
			console.log("Entrée dans success : resultat = "+code_html + 'statut = '+statut)
		},
		
		error : function(resultat, statut, erreur){
			console.log("Entrée dans error : resultat = "+resultat + ', statut = '+statut + ', erreur = ' + erreur)
		},
		
		complete : function(resultat, statut){
			console.log("Entrée dans complete : resultat = "+resultat + ', statut = '+statut)
		}
	})
	
	console.log('Fin de dynamicSearch')
}







