console.log('La JS se lance bien')
/**
 * Application pour trait, regroupant les différents controlleurs
 */
var app = angular.module('trait', []);

/**
 * Mis en place du controller de saisie pour la recherche dynamique
 */
app.controller('searchCtrl', function($scope, $http, $httpParamSerializer) {

  	$scope.saisie 		= {'libSaisie':''};
	$scope.reponse 		= "";
	$scope.listeTrait	= "";
    
	$scope.dynamicSearch = function() {

	$scope.reponse = "";
		
	$http.post('http://localhost:8080/arathiel-Web/traitjson/searchTr.action', 
				$httpParamSerializer($scope.saisie), 
				{headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
				.then(
					function (response) {
						$scope.status = response.status;
			
						// reponse devient un tableau d'objet
						$scope.reponse = response.data.listeTrait;

					}, 
					
					function (response) {
						$scope.erreur = response.status;
						$scope.reponse = "Oupps probleme de retour";
					});
     			}
});// Fin searchCtrl 







