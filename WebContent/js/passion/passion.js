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
			$scope.saisie.selectionRace = "null";
		}
		if($scope.saisie.selectionRace.length === 0){
			$scope.saisie.selectionRace = "null";
		}
		$scope.reponse = "";
		console.log($httpParamSerializer($scope.saisie));
		$http.post("http://localhost:8080/arathiel-Web/passionjson/ajouterPassion.action", $httpParamSerializer($scope.saisie),{headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
			.then(function (response) {

				$scope.erreur = response.status;
				$scope.reponse = response.data.messErreur;

			}, function (response) {
	            $scope.erreur = response.status;
	            $scope.reponse = response.status;

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


app.controller('passionModif', function ($scope) {
	console.log('dans passion modif');
	$scope.valide = function () {
		var test = angular.isUndefined($scope.saisie.selectionRace);
		if(test === true){
			$scope.saisie.selectionRace = "null";
		}
		if($scope.saisie.selectionRace.length === 0){
			$scope.saisie.selectionRace = "null";
		}
	}}
);


