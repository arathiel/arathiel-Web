<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular-messages.min.js"></script>
<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Rechercher une passion</title>
</head>
<body ng-app="passionApp" ng-controller="passionRecherche">

<!-- HEADER -->
	<!-- Menu en haut à droite et bannière -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>

	<h1>Page de recherche d'une passion</h1>
<!-- 	<div ng-controller="CtrlRecherchePassion"> -->
		 <label for="lettres">Nom de la passion à rechercher : </label>
		 <input type="text" name="lettres" ng-model="saisie.lettres" ng-keyup="recherchePassion()" />
<br><br>

<div ng-if="listePassions">
<div ng-if="listePassions.length == 0">Il n'y a pas de passion portant ce nom</div>
<table ng-if ="listePassions.length != 0" border= "1" >
	<thead>
		<tr>
			<th>Identifiant</th>
			<th>Nom</th>
			<th>Description</th>
			<th>Race associée</th>
		</tr>
	</thead>
 	<tbody>
		<tr ng-repeat="passion in listePassions">
			<td><a href="/arathiel-Web/passion/detailPassion.action?passionId={{passion.id}}">{{passion.id}}</a>	</td>
			<td>{{passion.nom}}</td>
			<td>{{passion.description}}</td>
			<td>{{passion.race.nom}}</td>
		</tr>
	</tbody>
</table>
</div>

	<p ng-if="erreur == 999" ng-bind="reponse"></p> 
	
	<br /><br />


<script type="" src="<s:url namespace="/passion" 	action="passionJs" />"></script>
</body>
</html>
