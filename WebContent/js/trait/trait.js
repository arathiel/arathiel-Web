/*****************************************************************/
/* 							AngularJs							 */
/*****************************************************************/

/**
 * Application pour trait, regroupant les différents controlleurs
 */
var trait = angular.module('trait', []);


/**
 * Mis en place du controller de saisie pour la recherche dynamique
 */
trait.controller('listCtrl', function($scope, $http, $httpParamSerializer) {
	//Initialisation de la variable
	$scope.saisie 		= {'libSearch':''};
	$scope.listeTrait	= "";
	
	
	//Fonction pour la recherche dynamique
	$scope.dynamicSearchTr = function() {

		//Initialisation des variables
		$scope.listeTrait	= "";
	
		//Requête + Retour
		$http.post('http://localhost:8080/arathiel-Web/traitjson/searchTr.action', 
					$httpParamSerializer($scope.saisie), 
					{headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
					.then(
							function (response) {											//SUCESS
								//Initialisation de la liste de trait avec le retour
								$scope.listeTrait = response.data.listTrait;
							}, 
					
							function (response) {											//ERREUR
								$scope.erreur = response.status;
								$scope.reponse = "Oupps probleme de retour";
							}
					);// Fin .then
		
	}// Fin dynamicSearch()
	
});// Fin listCtrl 


/**
 * Controleur pour la frmDetailTr
 */
trait.controller('detailCtrl', function($scope) {
	
	$scope.btnModifier = function() {
		$('#listComp').remove();
		$('.update').prop('disabled', false);
	}
	
});// Fin detailCtrl


/**
 * Controleur pour select dynamique une fois la page chargée
 * Ne pouvant utiliser facilement Struts2 et angular, j'ai choisi d'utiliser votre méthode
 */
$(document).ready(function() {
	$('#type').change(function(event) {
		
		//Variable
		var type 		= $("select#type").val();
		
		//On gère le disable du second sélect
		if(type == 'Caractéristique' || type == 'Roleplay' || type == 'Tous') {
			$('select#comp').prop('disabled', false);
		}
		else {
			$('select#comp').prop('disabled', true);
		}
		
		//Appel AJAX du service
	    $.getJSON(
	    		'http://localhost:8080/arathiel-Web/traitjson/dynamicSelectComp', 
	    		{ type : type }, 
	    		function(jsonResponse) {
	    			console.log(jsonResponse)

	    			//Initialisation variable avec 2ème select
	    			var selectComp 	= $('select#comp');
	    			
	    			// on enleve tous les <option>
	    			selectComp.find('option').remove();
	    			
	    			// on rempli le <select> avec les datas de map (jsonResponse.map)
	    			$.each(jsonResponse.map, function(key, value) {
	    				  $('<option>').val(key).text(value).appendTo(selectComp);
	    			});
	    		}
	    );
	});
});

// Essai de code pour cloner les sélect afin de permettre plusieurs comportement. Echec actuellement
//$(document).ready(function (){
//	  $('#btnMore').click(function (){
//	        $('.clone').append($('.clone').html())
//	    })
//	  
//	  })
	
