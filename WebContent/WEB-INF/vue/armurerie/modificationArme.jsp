<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"    uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="fr" ng-app="listeArme">
<head>
<link rel="stylesheet" href="<s:url namespace="" 						action="cssArathiel" />" />
<link rel="stylesheet" href="<s:url namespace="/armurerie" 				action="cssModification" />" />
<meta http-equiv="Content-Type" 	content="text/html; charset=UTF-8">
<script src="<s:url					namespace="/armurerie" 				action="angular.action" />"></script>
<script src="<s:url 				namespace="/armurerie" 				action="angularArmurerie.action" />"></script>
<title>Modification Arme</title>
</head>
<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
	
	<div>
	<h3>Liste des Armes :</h3>
	<s:form id="listeArme" methode="post" action="#" theme="simple">
		<table>
			<tr>
				<th>Selection</th>
				<th>Nom</th>
				<th>Races</th>
				<th>Encombrement</th>
				<th>Prix</th>
			</tr>
			<s:iterator value="armes">
				<tr>
					<td><s:radio 		name="" 		list="{idArme}" ng-model="saisie.idArme" ng-focus="CtrlList()"/></td>
					<td><s:property 	value="nom"/></td>
					<td><s:iterator 	value="races">
							<s:property value="nom"/>
						</s:iterator>
					</td>
					<td><s:property 	value="encombrement"/></td>
					<td><s:property 	value="prix"/></td>
				</tr>
			</s:iterator>	
		</table>
		<input type="button" value="Modifier"/>

	</s:form>
	</div>
	<div>
		<h3>modification Arme</h3>
	<br/>
	<br/>
	<s:if test="hasFieldErrors()">
		<s:fielderror>Les erreurs suivantes se sont produites : </s:fielderror>
	</s:if>
	<s:if test="hasActionMessages()">
		<s:actionmessage id="actionmessage" label="actionmessage :" />
	</s:if>
	<s:form namespace="/armurerie" 			action="modificationArmeValide" 	method="post" theme="simple">
		<p>Id : 			<s:textfield 		name="armeDto.idArme"/></p>
		<p>Nom : 			<s:textfield 		name="armeDto.nom"/></p>	
		<p>Races : 			<s:checkboxlist 	name="tabRaces" 			list="nomRaces" 	accesskey="idRace"/></p>								
		<p>Encombrement : 	<select 			name="armeDto.encombrement"	type="number">
				<option></option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
		</p>							
		<p>Prix : 		<s:textfield 		name="armeDto.prix" 	type="number"/></p>
		<p>Monnaie : 	<select 			name="armeDto.monnaie" 	class="monnaie">
			<option>Cuivre</option>
			<option>Argent</option>
			<option>Or</option>
		</select></p>
		<label class="drucks">Drucks</label>
		<br/>
		<br/>
		
		<s:url 		namespace="/armurerie" 	action="modificationArmeValide" 	var="modificationArmeValide"/>
		<s:url 		namespace="/armurerie" 	action="accueil" 					var="quitter"/>
			
		<s:submit 	value="Modifier" 		formaction="${modificationArmeValide}"/>
		<s:reset 	value="Quitter" 		formaction="${quitter}"/>

		</s:form>	
		</div>	
</body>
</html>