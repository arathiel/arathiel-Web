/**
 * Script de méthodes qui gèrent l'ajout de bonus 
 * sur les pages de création et d'édition des races
 */

window.onload = initAll;

function initAll() {
	console.log("Coucou bande de noobs"+document.querySelector('#caracPlus')+document.querySelector('#caracMoins'));
	document.querySelector('#caracPlus').onclick = caracPlus;	
	document.querySelector('#caracMoins').onclick = caracMoins;
	document.querySelector('#traitPlus').onclick = traitPlus;	
	document.querySelector('#traitMoins').onclick = traitMoins;
	document.querySelector('#compPlus').onclick = compPlus;	
	document.querySelector('#compMoins').onclick = compMoins;
	document.querySelector('#enregistrer').onclick = enregistrer;
}	
	
/**
 * Methode pour augmenter la valeur d'un bonus de caracteristique
 * 
 * @returns
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
		
		if (divBonusExistant!=null){										//si elle existe on recupère sa valeur																		//s'il existe on récupère sa valeur
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
		var idTraitBonus = "Trait"+idTrait;
		var divBonusExistant = document.getElementById(idTraitBonus);			//on teste si un div avec ce trait existe déjà...
		console.log(divBonusExistant);
		
		if (divBonusExistant==null){											//si absent on la créee...
			var divBonus = document.querySelector('#tableBonus');
			var ligne = divBonus.insertRow();									//On crée la ligne
			ligne.setAttribute("id", idTraitBonus);
			var cel1 = ligne.insertCell(0);										//On y insère des cellules avec la nom du trait...
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
		var idTraitBonus = "Trait"+idTrait;
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
		
		var idCompBonus = "Comp"+idComp;
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
			acadChk.setAttribute("name", "chkAcad");
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
	var idCompBonus = "Comp"+idComp;
	
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
 * Methode qui recupère les données du formulaire 
 * et les envoi vers le beanAction ActionsRacesGestion
 *  
 * @returns
 */
function enregistrer() {
	console.log("enregistrer");
	var divBonus = document.getElementById("bonus");
	var listeBonus = new Array;
	listeBonus = document.getElementsByTagName('tr');
	
	if (listeBonus != null){
		console.log(listeBonus.length);
		for (i=1; i<listeBonus.length; i++){
			var dataBonus = listeBonus[i].children;
			var idBonus = listeBonus[i].getAttribute('id');
			var valeur = dataBonus[1].innerHTML;			//la valeur du bonus est dans la 2eme cellule de la ligne
			var acad = dataBonus[2];						//la checkbox est eventuellement l'enfant de la 3ème dellule de la ligne
			
			
			if (acad != undefined) {
				var chk	= acad.firstChild;
				console.log(listeBonus[i].getAttribute('id')+"  "+valeur+"  "+chk.checked);
			} else {
				console.log(listeBonus[i].getAttribute('id')+"  "+valeur);
			}
		}
		
		
	}	
	
}