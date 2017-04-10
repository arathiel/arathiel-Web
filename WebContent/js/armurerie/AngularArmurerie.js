/**
 * Fichier Javascript pour l'utilisation d'AngularJS sur la page Armurerie.jsp
 * @Author OlivB
 */
var app = angular.module('appArmurerie', []);
 
app.controller('CtrlArmurerie', function($scope) {
    $scope.armurerie = {
    		statuts : 'default'
    };
});

var app = angular.module('listerArme', ['ngSanitize']);

app.controller('CtrlList', function($scope, $http, $httpParamSerializer) {
	$scope.saisie = {'idArme':''};
	$scope.reponse = "";
	 
	 $http.post('http://localhost:8080/Angular-Demo2-AjaxStruts/rechercheDemo2', $httpParamSerializer($scope.saisie), {headers: {'Content-Type': 'application/x-www-form-urlencoded'}})
		.then(function (response) {
	
});
});

