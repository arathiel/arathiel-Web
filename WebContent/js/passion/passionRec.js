/**
 * 
 */
var app = angular.module('passionApp', ['ngMessages']);


app.controller('passionRecherche', function($scope, $http, $httpParamSerializer) {
	
 	 $scope.saisie = {'lettres':''};
	 $scope.reponse = "";
	 $scope.listePassions="";
   
	$scope.recherchePassion = function() {

		$scope.reponse = "";
		$http.post('http://localhost:8080/arathiel-Web/passionjson/recherchePassion.action', $httpParamSerializer($scope.saisie), {headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
		.then(function (response) {
			console.log('Dans la fonction success')
			
			//Initialisation de la variable response			
			$scope.status = response.status;
			console.log($scope.status)
			
			$scope.reponse = response.data;
			console.log($scope.reponse)
			
			$scope.listePassions = response.data.listePassions;
			console.log($scope.listePassions)
			$scope.erreur = response.status;

		}, function (response) {
			$scope.erreur = response.status;
			$scope.reponse = "Oupps probleme de retour";
		});
    }
}); 

