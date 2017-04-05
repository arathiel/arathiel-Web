<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"    uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="fr" ng-app="appArmurerie">
<head>
	<link rel="stylesheet" href="<s:url namespace="" 		action="cssArathiel" />" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<s:url namespace="/armurerie" action="rechercheArme.action" />"></script>
<title>Armurerie</title>
</head>
<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
	
	
	<h1>Armurerie</h1>
	<div ng-controller="CtrlArmurerie">
		<form>
			<label><input type="radio" name="radioArmurerie" ng-model="armurerie.statuts" class="radioArmurerie" value="arme"/>Arme</label>
			<label><input type="radio" name="radioArmurerie" ng-model="armurerie.statuts" class="radioArmurerie" value="armure"/>Armure</label>
		</form>
	
		<hr>
	
		<div ng-switch="armurerie.statuts">
			<div ng-switch-when="arme">
<%-- 				<div ng-controller="CtrlArme">--%>
				<s:form namespace="/armurerie" action="afficheArme" method="post">

						<s:url namespace="/armurerie" action="creationArmeAffiche" 		var="creationArmeAffiche"/>
						<s:url namespace="/armurerie" action="modificationArmeAffiche" 	var="modificationArmeAffiche"/>
						<s:url namespace="/armurerie" action="suppressionArmeAffiche" 	var="suppressionArmeAffiche"/>
						<s:url namespace="/armurerie" action="joueurArmeAffiche" 		var="joueurArmeAffiche"/>
						<s:url namespace="/armurerie" action="rechercheArmeAffiche" 	var="rechercheArmeAffiche"/>
						
						<s:submit value="Création" 		formaction="${creationArmeAffiche}" />
						<s:submit value="Modification" 	formaction="${modificationArmeAffiche}" />
						<s:submit value="Suppression" 	formaction="${suppressionArmeAffiche}" />
						<s:submit value="Joueur" 		formaction="${joueurArmeAffiche}" />
						<s:submit value="Rechercher" 	formaction="${rechercheArmeAffiche}" 	id="listArme" />	
						
<%-- 					<label><input type="button" name="buttonArme" ng-model="arme.statuts" class="buttonArme" value="creationArme"/>Créer Arme</label>
						<label><input type="button" name="buttonArme" ng-model="arme.statuts" class="buttonArme" value="modificationArme"/>Modifier Arme</label>
						<label><input type="button" name="buttonArme" ng-model="arme.statuts" class="buttonArme" value="suppressionArme"/>Supprimer Arme</label>
						<label><input type="button" name="buttonArme" ng-model="arme.statuts" class="buttonArme" value="rechercheArme"/>Rechercher Arme</label>	
						--%>		
					</s:form>
					
					<hr>
					
					<div id="listeArmes">
					
					</div>

<%--				<div ng-switch="arme.statuts">
						<div ng-switch-when="creationArme">
							<%@include file="/../WEB-INF/vue/CreationArme.jsp"%>							
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
				</div>  --%>	
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
		</div>
	</div>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.8/angular.min.js"></script>
<script src="<%= request.getContextPath() %>/js/armurerie/AngularArmurerie.js"></script>
</body>
</html>