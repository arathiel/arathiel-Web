/**
 * Application pour trait, regroupant les différents controlleurs
 */
var app = angular.module('trait', []);


/**
 * Mis en place du controller de saisie pour la recherche dynamique
 */
app.controller('searchCtrl', function($scope, $http, $httpParamSerializer) {
	//Initialisation de la variable
	$scope.saisie 		= {'libSearch':''};
	$scope.listeTrait	= "";
	
	
	//Fonction pour la recherche dynamique
	$scope.dynamicSearch = function() {

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

});// Fin searchCtrl 
