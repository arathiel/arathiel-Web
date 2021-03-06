/**
 * Script de méthodes qui gèrent l'ajout de bonus 
 * sur les pages de création et d'édition des races
 */

window.onload = initAll;

var urlEnvoi = "";

function initAll() {
	document.querySelector('#caracPlus').onclick = caracPlus;	
	document.querySelector('#caracMoins').onclick = caracMoins;
	document.querySelector('#traitPlus').onclick = traitPlus;	
	document.querySelector('#traitMoins').onclick = traitMoins;
	document.querySelector('#compPlus').onclick = compPlus;	
	document.querySelector('#compMoins').onclick = compMoins;	
	document.querySelector('#reset').onclick = reset;
	
	if (document.querySelector('#enregistrer') != null){
		document.querySelector('#enregistrer').onclick = enregistrer;
	}	
	
	if (document.querySelector('#modifier') != null){
		console.log("bouton modifier opérationnel");
		document.querySelector('#modifier').onclick = modifier;
	}	
	
	if (document.querySelector('#supprimer') != null){
		console.log("bouton supprimer opérationnel");
		document.querySelector('#supprimer').onclick = supprimer;
	}
}	
	
/**
 * Methode pour augmenter la valeur d'un bonus de caracteristique
 * 
 */
function caracPlus(){
	var select = document.querySelector('#selectCarac');
	var idCarac = select.options[select.selectedIndex].value;
	var nomCarac = select.options[select.selectedIndex].innerHTML;

	if (idCarac != "0") {
		var idCaracBonus = "Car"+idCarac;
		var divBonusExistant = document.getElementById(idCaracBonus);			//on teste si une ligne du tableau bonus avec cette carac existe déjà...

		
		if (divBonusExistant==null){											//si absent on la créee...
			var divBonus = document.querySelector('#tableBonus');
			var ligne = divBonus.insertRow();									//On crée la ligne
			ligne.setAttribute("id", idCaracBonus);
			var cel1 = ligne.insertCell(0);										//On y insère des cellules avec la nom de la carac...
			cel1.innerHTML = nomCarac;
			var cel2 = ligne.insertCell(1);										//...et une valeur =1
			cel2.innerHTML="1"													
			
		} else {																
			var valBonus = divBonusExistant.getElementsByTagName('td')[1];		//si elle existe déjà on récupère sa valeur
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt < 5) {													//si la valeur est <5 on l'augmente
				valInt++;
				valBonus.innerHTML = valInt;
			}
		}
	}	
}


/**
 * Methode pour diminuer la valeur d'un bonus de caracteristique
 * 
 */
function caracMoins(){
	
	var select = document.querySelector('#selectCarac');
	var idCarac = select.options[select.selectedIndex].value;
	var nomCarac = select.options[select.selectedIndex].innerHTML;

	if (idCarac != "0") {	
		var idCaracBonus = "Car"+idCarac;
		var divBonusExistant = document.getElementById(idCaracBonus);		//on teste si une ligne du tableau bonus avec cette carac existe déjà...

		
		if (divBonusExistant!=null){										//si elle existe on recupère sa valeur					
			var valBonus = divBonusExistant.getElementsByTagName('td')[1];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt >1) {												//si la valeur est >1 on la diminue
				valInt--;
				valBonus.innerHTML = valInt;
			} else if (valInt==1) {											//si la valeur =1 on supprime la ligne
				var ligne = document.getElementById(idCaracBonus);
				ligne.parentNode.removeChild(ligne);
			}		
		}
	}	
}


/**
 * Methode pour augmenter la valeur d'un bonus de trait
 * 
 *
 */
function traitPlus(){
	var select = document.querySelector('#selectTrait');
	var idTrait = select.options[select.selectedIndex].value;
	var nomTrait = select.options[select.selectedIndex].innerHTML;

	if (idTrait != "0") {
		var idTraitBonus = "Tra"+idTrait;
		var divBonusExistant = document.getElementById(idTraitBonus);			//on teste si un div avec ce trait existe déjà...

		
		if (divBonusExistant==null){											//si absent on la créee...
			var divBonus = document.querySelector('#tableBonus');
			var ligne = divBonus.insertRow();									//On crée la ligne
			ligne.setAttribute("id", idTraitBonus);
			var cel1 = ligne.insertCell(0);										//On y insère des cellules avec le nom du trait...
			cel1.innerHTML = nomTrait;
			var cel2 = ligne.insertCell(1);										//...et une valeur =0 (un trait peu avoir une valeur nulle)
			cel2.innerHTML="0";
			
		} else {																
			var valBonus = divBonusExistant.getElementsByTagName('td')[1];		//si elle existe déjà on récupère sa valeur
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt < 5) {													//si la valeur est <5 on l'augmente
				valInt++;
				valBonus.innerHTML = valInt;
			}
		}
	}		
}

/**
 * Methode pour diminuer la valeur d'un bonus de trait
 * 
 *
 */
function traitMoins(){
	
	var select = document.querySelector('#selectTrait');
	var idTrait = select.options[select.selectedIndex].value;
	var nomTrait = select.options[select.selectedIndex].innerHTML;

	if (idTrait != "0") {
		var idTraitBonus = "Tra"+idTrait;
		var divBonusExistant = document.getElementById(idTraitBonus);		//on teste si un div avec ce trait existe déjà...

		
		if (divBonusExistant!=null){										//si elle existe on recupère sa valeur																		//s'il existe on récupère sa valeur
			var valBonus = divBonusExistant.getElementsByTagName('td')[1];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt >0) {												//si la valeur est >0 on la diminue
				valInt--;
				valBonus.innerHTML = valInt;
			} else if (valInt==0) {											//si la valeur =0 on supprime la ligne
				var ligne = document.getElementById(idTraitBonus);
				ligne.parentNode.removeChild(ligne);
			}		
		}
	}
}

/**
 * Methode pour augmenter la valeur d'un bonus de competence
 * 
 * 
 */
function compPlus(){
	var select = document.querySelector('#selectComp');
	var idComp = select.options[select.selectedIndex].value;
	var nomComp = select.options[select.selectedIndex].innerHTML;

	if (idComp != "0") {
		
		var idCompBonus = "Com"+idComp;
		var divBonusExistant = document.getElementById(idCompBonus);		//on teste si un div avec cette competence existe déjà...

		
		if (divBonusExistant==null){											//si absent on la créee...
			var divBonus = document.querySelector('#tableBonus');
			var ligne = divBonus.insertRow();									//On crée la ligne
			ligne.setAttribute("id", idCompBonus);
			var cel1 = ligne.insertCell(0);										//On y insère des cellules avec la nom de la carac...
			cel1.innerHTML = nomComp;
			var cel2 = ligne.insertCell(1);										//...et une valeur =1
			cel2.innerHTML="1"
			var cel3 = ligne.insertCell(2);
			var acadChk = document.createElement("INPUT");						//On ajoute une checkbox pour pouvoir modifier le statut "Académique" de la compétence
			acadChk.setAttribute("type", "checkbox");
			acadChk.setAttribute("class", "chkAcad");
			cel3.appendChild(acadChk);
			
		} else {																
			var valBonus = divBonusExistant.getElementsByTagName('td')[1];		//si elle existe déjà on récupère sa valeur
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt < 5) {													//si la valeur est <5 on l'augmente
				valInt++;
				valBonus.innerHTML = valInt;
			}
		}
	}	
}


/**
 * Methode pour diminuer la valeur d'un bonus de competence
 * 
 *
 */
function compMoins(){
	
	var select = document.querySelector('#selectComp');
	var idComp = select.options[select.selectedIndex].value;
	var nomComp = select.options[select.selectedIndex].innerHTML;
	var idCompBonus = "Com"+idComp;

	if (idComp != "0") {	
		var divBonusExistant = document.getElementById(idCompBonus);		//on teste si un div avec cette competence existe déjà...
		
		if (divBonusExistant!=null){										//si elle existe on recupère sa valeur																		//s'il existe on récupère sa valeur
			var valBonus = divBonusExistant.getElementsByTagName('td')[1];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt >1) {												//si la valeur est >1 on la diminue
				valInt--;
				valBonus.innerHTML = valInt;
			} else if (valInt==1) {											//si la valeur =1 on supprime la ligne
				var ligne = document.getElementById(idCompBonus);
				ligne.parentNode.removeChild(ligne);
			}		
		}
	}
}

/**
 * Methode qui enregistre une nouvelle race
 * 
 */
function enregistrer() {
	urlEnvoi = "../race/creerRace";
	traitementData();
}

/**
 * Methode qui modifie une race
 * 
 */
function modifier() {
	urlEnvoi = "../race/modifierRace";
	traitementData();
}

/**
 * Methode qui supprime une nouvelle race
 * 
 */
function supprimer() {
	urlEnvoi = "../race/supprimerRace";
	traitementData();
}


/**
 * Methode de reconstruction des données de la page 
 * Puis envoi à la méthode envoiAjax
 */
function traitementData() {
	//Recupération des données brutes del arace (id, nom et disponibilité)
	var idRaceElt = document.getElementById("idRace");
	var idRace = 0;
	if (idRaceElt.value != "") {
		idRace = parseInt(idRaceElt.value);
	}	
	
	var race = { 	"idRace":		idRace,
					"nomRace" : 	document.getElementById("nomRace").value,					
					"dispo" : 		document.getElementById("dispo").checked	
	};
	
	//Récupération des bonus
	var listeBonus = new Array;
	var rowBonus = $('#tableBonus > tbody > tr');
	
	if (rowBonus != null){
			for (i=1; i<rowBonus.length; i++){	//On parcours le tableau des bonus à partir du deuxième poste (le première contient les headers)
			console.log(rowBonus[i]);
			var dataBonus = rowBonus[i].children;
			var idBonus = rowBonus[i].getAttribute('id');
			var valeur = dataBonus[1].innerHTML;			//la valeur du bonus est dans la 2eme cellule de la ligne
			var acad = dataBonus[2];						//la checkbox est eventuellement l'enfant de la 3ème dellule de la ligne
			
			var newBonus = {	"idBonus" : idBonus,
								"valeurBonus" : valeur,
								"acad":	"false"	};
			
			if (acad != undefined) {
				var chk	= acad.children[0];				
				console.log(idBonus+"  "+valeur+"  "+chk.checked);
				newBonus.acad = chk.checked;
			}	
			
			listeBonus.push(newBonus);
		}
	}
	envoiAjax(race, listeBonus);
}


/** 
 * Methode qui reset la table des bonus
 *  
 */
function reset() {
	var row = document.getElementsByTagName('tr');
	var nom = document.getElementById('nomRace');
	var id  = document.getElementById('idRace');
	var chk= document.getElementById('dispo');
	var nb= row.length;
	
	for (i=nb-1; i>0; i--){
		row[i].parentNode.removeChild(row[i]);
	}	
	
	nom.value="";
	id.value="";
	chk.checked = false;
}

/**
* Methode qui se charge de construire un objet Ajax avec les données récupérées 
* et les envoie au beanAction
*/
function envoiAjax(race, listebonus) {
	var datageneric = {nomRace:race.nomRace, idRace:race.idRace, dispo:race.dispo};

	datageneric.listeBonus = listebonus;
	
	$.ajax({
	    url        	: urlEnvoi,
	    dataType	: 'html',
	    contentType	: 'application/x-www-form-urlencoded; charset=UTF-8',
	    data       	: datageneric,
	    type       	: 'POST',
	    
	    success 	: function(code_html, statut){ 	 
	    	$('#message').html(code_html);
	    },
	    
	    error : function(resultat, statut, erreur){
	    	$('#message').html(erreur);
    	},

    	complete : function(resultat, statut){
    		console.log("complete");
    	}
     });
	
}















