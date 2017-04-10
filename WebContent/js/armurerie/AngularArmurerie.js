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

var app = angular.module('listerArme', []);

app.controller('CtrlList', function($scope) {
	
});

