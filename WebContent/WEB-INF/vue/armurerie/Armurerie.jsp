<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr" ng-app="appArmurerie">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Armurerie</title>
</head>
<body>
	<h1>Armurerie</h1>
	<div ng-controller="CtrlArmurerie">
		<form>
			<label><input type="radio" name="radioArmurerie" ng-model="armurerie.statuts" class="radioArmurerie" value="arme"/>Arme</label>
			<label><input type="radio" name="radioArmurerie" ng-model="armurerie.statuts" class="radioArmurerie" value="armure"/>Armure</label>
		</form>
	
		<hr>
	
		<div ng-switch="armurerie.statuts">
			<div ng-switch-when="arme">
				<div ng-controller="CtrlArme">
					<form>
						<label><input type="radio" name="radioArme" ng-model="arme.statuts" class="radioArme" value="creationArme"/>Créer Arme</label>
						<label><input type="radio" name="radioArme" ng-model="arme.statuts" class="radioArme" value="modificationArme"/>Modifier Arme</label>
						<label><input type="radio" name="radioArme" ng-model="arme.statuts" class="radioArme" value="suppressionArme"/>Supprimer Arme</label>
						<label><input type="radio" name="radioArme" ng-model="arme.statuts" class="radioArme" value="rechercheArme"/>Rechercher Arme</label>		
					</form>
					<div ng-switch="arme.statuts">
						<div ng-switch-when="creationArme">
							<%@include file="CreationArme.jsp"%>							
						</div>
						<div ng-switch-when="modificationArme">
							<h3>modificaion arme</h3>
						</div>
						<div ng-switch-when="suppressionArme">
							<h3>suppression arme</h3>
						</div>
						<div ng-switch-when="rechercheArme">
							<h3>recherche arme</h3>
						</div>
						<div ng-switch-default>
							<h3>Que souhaitez-vous faire ?</h3>
						</div>
					</div>
				</div>
			</div>
			<div ng-switch-when="armure">
				<form>
					<label>
						<input type="radio" name="radioArmure" ng-model="arme.statuts" class="radioArmure" value="creationArmure"/>Créer Armure
					</label>
					<label>
						<input type="radio" name="radioArmure" ng-model="arme.statuts" class="radioArmure" value="modificationArmure"/>Modifier Armure
					</label>
					<label>
						<input type="radio" name="radioArmure" ng-model="arme.statuts" class="radioArmure" value="suppressionArmure"/>Supprimer Armure
					</label>
					<label>
						<input type="radio" name="radioArmure" ng-model="arme.statuts" class="radioArmure" value="rechercheArmure"/>Rechercher Armure
					</label>		
				</form>
			</div>
			<div ng-switch-default>
				<h2>Bienvenue dans l'Armurerie d'Arathiel</h2>
			</div>
		</div>
	</div>

	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.min.js"></script>
	<script src="<%= request.getContextPath() %>/js/AngularArmurerie.js"></script>
</body>
</html>