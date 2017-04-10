<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Détail d'une passion</title>
</head>
<body ng-app="passionApp">
	<!-- HEADER -->
	<!-- Menu en haut à droite et bannière -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>

	
	<h1> Affichage de la passion: <s:property value="%{passion.nom}"/> </h1>
	
	<s:if test="hasFieldErrors()">
		<ul>
			<s:fielderror>Les erreurs suivantes se sont produites : </s:fielderror>
		</ul>
		<hr />
	</s:if>

	<s:if test="hasActionErrors()">
		<s:actionerror id="actionerror" label="actionerror : " />
		<hr />
	</s:if>

	<s:if test="hasActionMessages()">
		<s:actionmessage id="actionmessage" label="actionmessage :" />
		<hr />
	</s:if>
	
<form>
		<input type="radio"  ng-model="choix"  value="modif"/>Modifier
		<input type="radio"  ng-model="choix"  value="suppr"/>Supprimer
</form>
		<br><br>
		<s:label name="nomPassion" value="Nom : %{passion.nom}"/> 
		<br><br>
		<s:label value="Description : %{passion.description}"/>
	<br><br>
		<s:if test= "passion.race.nom != null">
		<s:label value="Race : %{passion.race}"/>
		</s:if>
		<br><br>
		<s:iterator value ="passion.magies">
		<s:label value="Mot de pouvoir fondamental : %{libelle}"/>
		<br><br>
		</s:iterator>



<div ng-controller = "passionModif">
<div ng-switch="choix">
	<div ng-switch-when="modif">
	<s:form acceptcharset ="UTF-8" ng-submit="valide()">
 		<s:textfield name="passionNom" value="%{passion.nom}" readonly= "true" label="Nom : "/>
 		<s:textarea name="passionDescription" 	value="%{passion.description}"	label="Description" />
 
 		<s:select name="selectionRace" list="listeRace"  multiple ="false" size="1"
		  		  listKey="nom"        listValue="nom" 
			  	  headerKey="0"        headerValue="Affecter une race" 
			  	  label="Race " 	   ng-model="saisie.selectionRace" />
		<br><br>
		<s:select name="selectionMagie" list="listeMdpFond"
				  multiple ="true" 		size="3"
 				  listKey="libelle"  		listValue="libelle"
 			  	  selected="0" headerKey="0"		headerValue="Sélectionnez la magie " 
			  	  label="Mots de pouvoir fondamentaux " ng-model="saisie.selectionMagie" required="" /> 
			  	  <br><br>

<s:url namespace="/passion" action="modifierPassion" var="modif" />
<s:submit value="Modifier"  		formaction="${modif}" />
</s:form> 
	</div>
	<div ng-switch-when = "suppr">
	<s:form namespace="/passion"  method="post" acceptcharset ="UTF-8">
		<s:textfield name="passionNom" value="%{passion.nom}" readonly= "true" label="La passsion suivante va être supprimée: "/>
		<s:url namespace="/passion" action="supprimerPassion" var="suppr" />
		<s:submit value="Supprimer" 		formaction="${suppr}" />
	</s:form> 
</div>
</div>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.0-rc.0/angular-messages.min.js"></script>
<script type="" src="<s:url namespace="/passion" 	action="passionJs" />"></script>
</body>
</html>
