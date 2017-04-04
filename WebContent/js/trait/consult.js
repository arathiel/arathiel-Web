window.onload = test;

function test() {
	console.log ('JS consult.js chargé')
}

/**
 * Application pour trait, regroupant les différents controlleurs
 */
var app = angular.module('trait', []);


/**
 * Mis en place du controller de saisie pour la recherche dynamique
 */
app.controller('searchCtrl', function($scope, $http, $httpParamSerializer) {
	//Initialisation de la variable
	$scope.saisie 		= {'libelle':''};
	
	//Fonction pour la recherche dynamique
	$scope.dynamicSearch = function() {

		//Initialisation des variables
		$scope.reponse	 	= "";
		$scope.listeTrait	= "";
	
	
		//Requête + Retour
		$http.post('http://localhost:8080/arathiel-Web/traitjson/searchTr.action', 
					$httpParamSerializer($scope.saisie), 
					{headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
					.then(
							function (response) {
								console.log('Dans la function success')
						
								//Initialisation de la variable response			
								$scope.status = response.status;
								console.log($scope.status)
								
								$scope.reponse = response.data;
								console.log($scope.reponse)
								
								$scope.listeTrait = response.data.listTrait;
								console.log($scope.listeTrait)

					}, 
					
					function (response) {
						$scope.erreur = response.status;
						$scope.reponse = "Oupps probleme de retour";
					});
     			}
});// Fin searchCtrl 