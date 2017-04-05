/**
 * Script de méthodes qui gèrent l'ajout de bonus 
 * sur les pages de création et d'édition des races
 */

window.onload = initAll;

function initAll() {
	console.log("Coucou bande de noobs"+document.querySelector('#enregistrer'));
	document.querySelector('#caracPlus').onclick = caracPlus;	
	document.querySelector('#caracMoins').onclick = caracMoins;
	document.querySelector('#traitPlus').onclick = traitPlus;	
	document.querySelector('#traitMoins').onclick = traitMoins;
	document.querySelector('#compPlus').onclick = compPlus;	
	document.querySelector('#compMoins').onclick = compMoins;	
	
	if (document.querySelector('#enregistrer') != null){
		document.querySelector('#enregistrer').onclick = enregistrer;
	}	
	
	if (document.querySelector('#modifier') != null){
		document.querySelector('#modifier').onclick = modifier;
	}	
	document.querySelector('#reset').onclick = reset;
}	
	
/**
 * Methode pour augmenter la valeur d'un bonus de caracteristique
 * 
 */
function caracPlus(){
	var select = document.querySelector('#selectCarac');
	var idCarac = select.options[select.selectedIndex].value;
	var nomCarac = select.options[select.selectedIndex].innerHTML;

	console.log(idCarac);
	console.log(nomCarac);
	
	if (idCarac != "0") {
		var idCaracBonus = "Car"+idCarac;
		var divBonusExistant = document.getElementById(idCaracBonus);			//on teste si une ligne du tableau bonus avec cette carac existe déjà...
		console.log(divBonusExistant);
		
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
 * @returns
 */
function caracMoins(){
	
	var select = document.querySelector('#selectCarac');
	var idCarac = select.options[select.selectedIndex].value;
	var nomCarac = select.options[select.selectedIndex].innerHTML;

	console.log(idCarac);
	console.log(nomCarac);
	
	if (idCarac != "0") {	
		var idCaracBonus = "Car"+idCarac;
		var divBonusExistant = document.getElementById(idCaracBonus);		//on teste si une ligne du tableau bonus avec cette carac existe déjà...
		console.log(divBonusExistant);
		
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
 * @returns
 */
function traitPlus(){
	var select = document.querySelector('#selectTrait');
	var idTrait = select.options[select.selectedIndex].value;
	var nomTrait = select.options[select.selectedIndex].innerHTML;

	console.log(idTrait);
	console.log(nomTrait);
	
	if (idTrait != "0") {
		var idTraitBonus = "Tra"+idTrait;
		var divBonusExistant = document.getElementById(idTraitBonus);			//on teste si un div avec ce trait existe déjà...
		console.log(divBonusExistant);
		
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
 * @returns
 */
function traitMoins(){
	
	var select = document.querySelector('#selectTrait');
	var idTrait = select.options[select.selectedIndex].value;
	var nomTrait = select.options[select.selectedIndex].innerHTML;

	console.log(idTrait);
	console.log(nomTrait);
	
	if (idTrait != "0") {
		var idTraitBonus = "Tra"+idTrait;
		var divBonusExistant = document.getElementById(idTraitBonus);		//on teste si un div avec ce trait existe déjà...
		console.log(divBonusExistant);
		
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
 * @returns
 */
function compPlus(){
	var select = document.querySelector('#selectComp');
	var idComp = select.options[select.selectedIndex].value;
	var nomComp = select.options[select.selectedIndex].innerHTML;

	console.log(idComp);
	console.log(nomComp);
	
	if (idComp != "0") {
		
		var idCompBonus = "Com"+idComp;
		var divBonusExistant = document.getElementById(idCompBonus);		//on teste si un div avec cette competence existe déjà...
		console.log(divBonusExistant);
		
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
 * @returns
 */
function compMoins(){
	
	var select = document.querySelector('#selectComp');
	var idComp = select.options[select.selectedIndex].value;
	var nomComp = select.options[select.selectedIndex].innerHTML;
	var idCompBonus = "Com"+idComp;
	
	console.log(idComp);
	console.log(nomComp);
	
	if (idComp != "0") {	
		var divBonusExistant = document.getElementById(idCompBonus);		//on teste si un div avec cette competence existe déjà...
		console.log(divBonusExistant);
		
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
 * Methode qui enrgistre une nouvelle race
 * 
 */
function enregistrer() {
	var race = recupData();
	var listeBonus = recupBonus();

	
	console.log("race = "+race);
	console.log("nb de bonus = "+listeBonus.length);
	envoiAjax(race, listeBonus);
}



/** 
 * Methode qui recupère les données de base des races (nom + id)
 * 
 */
function recupData() {
	console.log("enregistrer");
	var divBonus = document.getElementById("bonus");
	var idRaceElt = document.getElementById("idRace");
	var idRace = 0;
	if (idRaceElt != null) {
		idRace = parseInt(idRaceElt.value);
	}	
	
	var race = { 	"idRace":		idRace,
					"nomRace" : 	document.getElementById("nomRace").value					
				};
	return race;
}

/** 
 * Methode qui recupère les données des bonus
 * 
 */
function recupBonus() {
	var rowBonus = new Array;
	var listeBonus = new Array;
	rowBonus = document.getElementsByTagName('tr');

	
	if (rowBonus != null){
			for (i=1; i<rowBonus.length; i++){					//On parcours le tableau des bonus à partir du deuxième poste (le première contient les headers)
			var dataBonus = rowBonus[i].children;
			var idBonus = rowBonus[i].getAttribute('id');
			var valeur = dataBonus[1].innerHTML;			//la valeur du bonus est dans la 2eme cellule de la ligne
			var acad = dataBonus[2];						//la checkbox est eventuellement l'enfant de la 3ème dellule de la ligne
			
			var newBonus = {	"idBonus" : idBonus,
								"valeurBonus" : valeur,
								"acad":	"false"	};
			
//			var newBonus = {	"idBonus" : idBonus,
//					"valeurBonus" : valeur,
//					"acad":	"false"	};
			
			if (acad != undefined) {
				var chk	= acad.children[0];				
				console.log(idBonus+"  "+valeur+"  "+chk.checked);
				newBonus.acad = chk.checked;
			}	
			
			listeBonus.push(newBonus);
			console.log(listeBonus.length);
			console.log(bonus);			
		}
	}
	return listeBonus;	
}


/** 
 * Methode qui reset la table des bonus
 *  
 */
function reset() {
	var row = document.getElementsByTagName('tr');
	var nb= row.length;
	console.log(row.length);
	
	for (i=nb-1; i>0; i--){
		console.log(i);
		console.log(row[i]);
		row[i].parentNode.removeChild(row[i]);
	}	
}

/**
* Methode qui se charge de construire un objet Ajax avec les données récupérées 
* et les envoie au beanAction
*/
function envoiAjax(race, listebonus) {
//	var xhr = null;
//	
//	if (window.XMLHttpRequest){
//		xhr = new XMLHttpRequest();
//	} else if(window.ActiveXObject) {
//		try { xhr = new ActiveXObject("Msxml2.XHTTP");}
//		catch(e) {xhr = new ActiveXObject("Microsoft.XMLHTTP");}		
//	} else {
//		alert("Erreur de support de l'objet XMLHttpRequest");
//	}	
//	
//
//	console.log(race.idRace+race.nomRace);
//	xhr.open("GET", "../race/creerRace?nomRace="+race.nomRace+"&idRace="+race.idRace, true);
//	//xhr.open("POST", "../race/creerRace", true);
//	
//	xhr.setRequestHeader("content-type", "application/x-www-form-urlencoder");
//	
//	xhr.send(null);
//	//xhr.send("nomRace="+race.nomRace+"&idRace="+race.idRace);
//	
//	xhr.onreadystatechange = function() {
//		if (xhr.readyState==4){
//			document.querySelector('#message').innerHTML=xhr.status;
//		}
//	}
	
	
//	var raceAjax = {nomRace:race.nomRace, idRace:race.idRace, listeBonus:[{id:race.listeBonus.idBonus}, {val:race.listeBonus.valeurBonus}]};
	
//	var raceAjax = JSON.stringify(race);
//	console.log(raceAjax);
	
	var datageneric = {nomRace:race.nomRace, idRace:race.idRace};
	//var liste =JSON.stringify(listebonus)
	datageneric.listeBonus = listebonus;
	
//	for (i=0; i<listebonus.length; i++){
//		console.log("Bonus: ");
//		
//		var index = "index"+i;
//		datageneric.index="bonus n°"+i;
//		
//		console.log(datageneric);
//	}
	
	
	
	$.ajax({
	    url        : "../race/creerRace",
//	    dataType   : 'json',
//	    contentType: 'application/json; charset=UTF-8', 
	    data       : datageneric,
	    type       : 'POST',
	    
	    success 	: function(code_html, statut){ 				
	        console.log("success");
	    },
	    
	    error : function(resultat, statut, erreur){
	    	console.log("error")
    	},

    	complete : function(resultat, statut){
    		console.log("complete")
    	}
     });
	
}















