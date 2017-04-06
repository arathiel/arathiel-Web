/**
 * Script contenant les methodes pour selectionner une race 
 * à afficher dans la fenêtre d'édition depuis la liste des races
 */
 

function choix(element) {
	console.log("js choix"+element);
	var tdElem = element.parentNode;
	console.log(tdElem);
	var trElem = tdElem.parentNode;
	console.log(trElem);
	var tdNom = trElem.childNodes[1].innerHTML;
	
	console.log(tdNom);
	requeteChoix(tdNom);
}	
	
//	for (i=0; i<tdNom.length; i++){
//	console.log(tdNom[i].innerHTML);
//	}

	
function requeteChoix(nomRace){
	
	$.ajax({
		url        : "../race/pageediter",
	    contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
	    data       : {"nomRace":nomRace},
	    type       : 'GET',
	    
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
