/**
 * 
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
	

function caracPlus(){
	var select = document.querySelector('#selectCarac');
	var idCarac = select.options[select.selectedIndex].value;
	var valCarac = select.options[select.selectedIndex].innerHTML;
	var paragraph = document.createElement('p');
	paragraph.setAttribute("id", idCarac);
	paragraph.innerHTML = valCarac;
	
	document.querySelector('#bonus').appendChild(paragraph);
	
	console.log(idCarac);
	console.log(valCarac);
	console.log("caracPlus");
}

function caracMoins(){
	console.log("caracMoins");
}

function traitPlus(){
	console.log("traitPlus");
}

function traitMoins(){
	console.log("traitMoins");
}

function compcPlus(){
	console.log("compPlus");
}

function compMoins(){
	console.log("compMoins");
}

function acad() {
	console.log("acad");
}