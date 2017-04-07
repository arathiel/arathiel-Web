/**
 * 
 */
var app = angular.module('passionApp', ['ngMessages']);


app.controller('passionCtrl', function ($scope, $http, $httpParamSerializer) {
	
	$scope.saisie = {'passionNom':'', 'passionDescription':'', 'selectionRace':'', 'selectionMagie' : ''};
	$scope.reponse = "";
	$scope.valide = function () {
		var test = angular.isUndefined($scope.saisie.selectionRace);
		if(test === true){
			$scope.saisie.selectionRace = "0";
		}
		$scope.reponse = "";
		console.log($httpParamSerializer($scope.saisie));
		$http.post("http://localhost:8080/arathiel-Web/passion/ajouterPassion.action", $httpParamSerializer($scope.saisie),{headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
			.then(function (response) {

				$scope.erreur = response.status;
				$scope.reponse = response.data;

			}, function (response) {
	            $scope.erreur = response.status;
	            $scope.reponse = "oupps probleme de retour";

});
	}
	
	});

app.controller('passionRecherche', function($scope, $http, $httpParamSerializer) {
	
	console.log('dans passion recherche');
	 $scope.saisie = {'lettres':''};
	 $scope.reponse = "";
	 $scope.listePassions="";
  
	$scope.recherchePassion = function() {

		$scope.reponse = "";
		$http.post('http://localhost:8080/arathiel-Web/passionjson/recherchePassion.action', $httpParamSerializer($scope.saisie), {headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
		.then(function (response) {

			$scope.erreur = response.status;

			$scope.reponse = response.data.listePassions;
			$scope.listePassions = response.data.listePassions;

		}, function (response) {
          $scope.erreur = response.status;
          $scope.reponse = "Oupps probleme de retour";
		});
   }
}); 


app.controller('passionModif', function ($scope, $http, $httpParamSerializer) {
	console.log('dans passion modif');
	$scope.saisie = {'passionNom':'', 'passionDescription':'', 'selectionRace':'', 'selectionMagie' : ''};
	$scope.reponse = "";
	var test = angular.isUndefined($scope.saisie.selectionRace);
	console.log(test);
	if(test === true){
		$scope.saisie.selectionRace = "0";
	}
	$scope.valide = function () {
		var test = angular.isUndefined($scope.saisie.selectionRace);
		console.log(test);
		if(test === true){
			$scope.saisie.selectionRace = "0";
		}
		$scope.reponse = "";
		console.log($httpParamSerializer($scope.saisie));
//		$http.post("http://localhost:8080/arathiel-Web/passion/modifierPassion.action", $httpParamSerializer($scope.saisie),{headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
//			.then(function (response) {
//
//				$scope.erreur = response.status;
//				$scope.reponse = response.data;
//
//			}, function (response) {
//	            $scope.erreur = response.status;
//	            $scope.reponse = "oupps probleme de retour";
//
//});
	}
	});


