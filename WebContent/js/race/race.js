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
	document.querySelector('#acad').onclick = acad;
}	
	
/**
 * Methode pour augmenter la valeur d'un bonus de caracteristique
 * 
 * @returns
 */
function caracPlus(){
	var select = document.querySelector('#selectCarac');
	var idCarac = select.options[select.selectedIndex].value;
	var valCarac = select.options[select.selectedIndex].innerHTML;

	console.log(idCarac);
	console.log(valCarac);
	
	if (idCarac != "0") {
		
		var divBonusExistant = document.getElementById(idCarac);			//on teste si un paragraph avec cette carac existe déjà...
		console.log(divBonusExistant);
		
		if (divBonusExistant==null){										//si absent on le crée
			var divBonus = document.createElement('div');
			divBonus.setAttribute("id", idCarac);	
			divBonus.innerHTML = valCarac;
			document.querySelector('#bonus').appendChild(divBonus);	
			
			var valeur = document.createElement('p');
			valeur.setAttribute("class", "valeur");
			valeur.innerHTML = "1"											//avec une valeur =1
			document.getElementById(idCarac).appendChild(valeur);
			
		} else {															//s'il existe on récupère sa valeur
			var valBonus = document.getElementById(idCarac).children[0];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt < 5) {												//si la valeur est <5 on l'augmente
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
	var valCarac = select.options[select.selectedIndex].innerHTML;

	console.log(idCarac);
	console.log(valCarac);
	
	if (idCarac != "0") {	
		var divBonusExistant = document.getElementById(idCarac);			//on teste si un paragraph avec cette carac existe déjà...
		console.log(divBonusExistant);
		
		if (divBonusExistant!=null){										//si il n'est pas absent on recupère sa valeur																		//s'il existe on récupère sa valeur
			var valBonus = document.getElementById(idCarac).children[0];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt >1) {												//si la valeur est >1 on la diminue
				valInt--;
				valBonus.innerHTML = valInt;
			} else if (valInt==1) {											//si la valeur =1 on supprimer le div
				document.getElementById(idCarac).remove();
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
	var valTrait = select.options[select.selectedIndex].innerHTML;

	console.log(idTrait);
	console.log(valTrait);
	
	if (idTrait != "0") {
		
		var divBonusExistant = document.getElementById(idTrait);			//on teste si un div avec ce trait existe déjà...
		console.log(divBonusExistant);
		
		if (divBonusExistant==null){										//si absent on le crée
			var divBonus = document.createElement('div');
			divBonus.setAttribute("id", idTrait);	
			divBonus.innerHTML = valTrait;
			document.querySelector('#bonus').appendChild(divBonus);	
			
			var valeur = document.createElement('p');
			valeur.setAttribute("class", "valeur");
			valeur.innerHTML = "0"											//avec une valeur =0
			document.getElementById(idTrait).appendChild(valeur);
			
		} else {															//s'il existe on récupère sa valeur
			var valBonus = document.getElementById(idTrait).children[0];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt < 5) {												//si la valeur est <5 on l'augmente
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
	var valTrait = select.options[select.selectedIndex].innerHTML;

	console.log(idTrait);
	console.log(valTrait);
	
	if (idTrait != "0") {	
		var divBonusExistant = document.getElementById(idTrait);			//on teste si un div avec ce trait existe déjà...
		console.log(divBonusExistant);
		
		if (divBonusExistant!=null){										//si il n'est pas absent on recupère sa valeur																		//s'il existe on récupère sa valeur
			var valBonus = document.getElementById(idTrait).children[0];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt >0) {												//si la valeur est >0 on la diminue
				valInt--;
				valBonus.innerHTML = valInt;
			} else if (valInt==0) {											//si la valeur =0 on supprimer le div
				document.getElementById(idTrait).remove();
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
	var valComp = select.options[select.selectedIndex].innerHTML;

	console.log(idComp);
	console.log(valComp);
	
	if (idComp != "0") {
		
		var idCompBonus = "Comp"+idComp;
		var divBonusExistant = document.getElementById(idCompBonus);		//on teste si un div avec cette competence existe déjà...
		console.log(divBonusExistant);
		
		if (divBonusExistant==null){										//si absent on le crée
			var divBonus = document.createElement('div');
			divBonus.setAttribute("id", idCompBonus);	
			divBonus.innerHTML = valComp;
			document.querySelector('#bonus').appendChild(divBonus);	
			
			var valeur = document.createElement('p');
			valeur.setAttribute("class", "valeur");
			valeur.innerHTML = "1"											//avec une valeur =1
			document.getElementById(idCompBonus).appendChild(valeur);
			
			var acadChk = document.createElement("INPUT");					//On ajoute une checkbox pour pouvoir modifier le statut "Académique" de la compétence
			acadChk.setAttribute("type", "checkbox");
			acadChk.setAttribute("name", "chkAcad");
			document.getElementById(idCompBonus).appendChild(acadChk);
			
		} else {															//s'il existe on récupère sa valeur
			var valBonus = document.getElementById(idCompBonus).children[0];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt < 5) {												//si la valeur est <5 on l'augmente
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
	var valComp = select.options[select.selectedIndex].innerHTML;
	var idCompBonus = "Comp"+idComp;
	
	console.log(idComp);
	console.log(valComp);
	
	if (idComp != "0") {	
		var divBonusExistant = document.getElementById(idCompBonus);		//on teste si un div avec cette competence existe déjà...
		console.log(divBonusExistant);
		
		if (divBonusExistant!=null){										//si il n'est pas absent on recupère sa valeur																		//s'il existe on récupère sa valeur
			var valBonus = document.getElementById(idCompBonus).children[0];
			var valInt = parseInt(valBonus.innerHTML);	
			
			if (valInt >1) {												//si la valeur est >1 on la diminue
				valInt--;
				valBonus.innerHTML = valInt;
			} else if (valInt==1) {											//si la valeur =1 on supprime le div
				document.getElementById(idCompBonus).remove();
			}		
		}
	}
}

function acad() {
	console.log("acad");
}