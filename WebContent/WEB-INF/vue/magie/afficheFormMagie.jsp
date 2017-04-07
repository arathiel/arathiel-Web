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
<body ng-app="magieApp" >
	<!-- HEADER -->
	<!-- Menu en haut à droite et bannière -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>

	<div ng-controller="magieCtrl">
	<h1> Cr&eacute;ation d'un mot de pouvoir </h1>
	

	<form name ="ajoutMDPvoir" ng-submit="valide()" acceptcharset ="UTF-8"  novalidate >
		
		<label for="nomMotDePouvoir">Nom du mot de pouvoir: </label>
		<input type="text" name="nomMdPvoir"  ng-model="saisie.mdpvoirNom" required />
		   <div ng-messages="ajoutMdPvoir.nomMdPvoir.$error" > 
    			<ng-message when="required">Le Nom de la mdpvoir est obligatoire</ng-message> 
			</div>

		<br><br>
					
		<s:select name="selectionMagie" list="listeMdpFond"
				  multiple ="true" 		size="3"
 				  listKey="libelle"  		listValue="libelle"
 			  	  headerKey="0"			headerValue="Sélectionnez la magie " 
			  	  label="Mots de pouvoir fondamentaux " ng-model="saisie.selectionMagie" required="" /> 
		
		<br><br>
 		<div ng-messages="ajoutMdPvoir.selectionMagie.$error" > 
    		<ng-message when="required">Vous devez sélectionner la magie à associer à la mdpvoir</ng-message> 
    <br><br>
 <s:submit value="Creation"  ng-disabled="!ajoutMdPvoir.$valid" />

</form>
</div>
<br>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular-messages.min.js"></script>
<script type="" src="<s:url namespace="/magie" 	action="magieJs" />"></script>
</body>
</html>
