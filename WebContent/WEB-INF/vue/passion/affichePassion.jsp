<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="fr">
<head>
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Caractère des personnages</title>
</head>
<body ng-app="passionApp" >
	<!-- HEADER -->
	<!-- Menu en haut à droite et bannière -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>

	<div ng-controller="passionCtrl">
	<h1> Cr&eacute;ation d'une nouvelle passion </h1>
	
<%-- 	<s:form namespace="/passion" action="affichePassion" method="post" acceptcharset ="UTF-8" > --%>
	<form name ="ajoutPassion" ng-submit="valide()" acceptcharset ="UTF-8"  novalidate >
		
		<label for="nomPassion">Nom de la passion: </label>
		<input type="text" name="nomPassion"  ng-model="saisie.passionNom" required />
		   <div ng-messages="ajoutPassion.nomPassion.$error" > 
    <ng-message when="required">Le Nom de la passion est obligatoire</ng-message> 
</div>
<!-- 		<p ng-show="ajoutPassion.nomPassion.$invalide" >Veuillez indiquer votre nom</p> -->
		<br><br>
		<label for="description">Description de la passion</label>
		<textarea rows="3" cols="20" name="description" ng-model="saisie.passionDescription"></textarea>
		<br><br>
		<s:select name="selectionRace" list="listeRace" 
		  listKey="nom"         listValue='nom' 
			  headerKey="0"        headerValue="Affecter une race" 
			  	  label="Race " ng-model="saisie.selectionRace" />
		<br><br>
		<s:select name="selectionMagie" list="listeMdpFond"
				  multiple ="true" 		size="3"
 				  listKey="libelle"  		listValue="libelle"
 			  	  headerKey="0"			headerValue="Sélectionnez la magie " 
			  	  label="Mots de pouvoir fondamentaux " ng-model="saisie.selectionMagie" required="" /> 
			  	  <br><br>
 		<div ng-messages="ajoutPassion.selectionMagie.$error" > 
    	<ng-message when="required">Vous devez sélectionner la magie à associer à la passion</ng-message> 
    <br><br>
 <s:submit value="Creation"  ng-disabled="!ajoutPassion.$valid" />

</form>
</div>
<br>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular-messages.min.js"></script>
<script type="" src="<s:url namespace="/passion" 	action="passionJs" />"></script>
</body>
</html>
