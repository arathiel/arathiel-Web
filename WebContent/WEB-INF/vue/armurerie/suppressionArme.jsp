<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"    uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<link rel="stylesheet" href="<s:url namespace="" 		action="cssArathiel" />" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Suppression Arme</title>
</head>
<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
	
	
	<h3>Liste des Armes :</h3>
	<s:form id="listeArme" methode="post" action="#">
		<table>
			<tr>
				<td>Selection</td>
				<td>Nom</td>
				<td>Races</td>
				<td>Encombrement</td>
				<td>Prix</td>
			</tr>
			<s:iterator value="armes">
				<tr>
					<td><s:radio 		name="idArme" 		list="{idArme}"/></td>
					<td><s:property 	value="nom"/></td>
					<td><s:iterator 	value="races">
							<s:property value="nomRace"/>
						</s:iterator></td>
					<td><s:property 	value="encombrement"/></td>
					<td><s:property 	value="prix"/></td>
				</tr>
			</s:iterator>	
		</table>
		<input type="submit" valeur="Détail"/>
	</s:form>
			<h3>modification Arme</h3>
	<br/>
	<br/>
	<s:if test="hasFieldErrors()">
		<s:fielderror>Les erreurs suivantes se sont produites : </s:fielderror>
	</s:if>
	<s:if test="hasActionMessages()">
		<s:actionmessage id="actionmessage" 	label="actionmessage :" />
	</s:if>
	<s:form namespace="/armurerie" 	action="suppressionArmeValide" 	method="post">
		<p>Id : <s:textfield 		name="armeDto.idArme"/></p>
		<p>Nom : <s:textfield 		name="armeDto.nom"/></p>	
		<p>Races : <s:checkboxlist 	name="tabRaces"        			list="races" 	accesskey="idRace"/></p>								
		<p>Encombrement : <select 	name="armeDto.encombrement"		type="number" >
				<option></option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
		</select></p>							
		<p>Prix : <s:textfield 		name="armeDto.prix"				 type="number"/></p>
		<p>Monnaie : <select 		name="armeDto.monnaie"			 class="monnaie">
			<option>Cuivre</option>
			<option>Argent</option>
			<option>Or</option>
		</select></p>
		<label class="drucks">Drucks</label>
		<br/>
		<br/>
		
		<s:url namespace="/armurerie" action="suppressionArmeValide" 		var="suppressionArmeValide"/>
		
		<s:submit 	value="Vérifier" 		formaction="#"/>	
		<s:submit 	value="Supprimer" 		formaction="${suppressionArmeValide}"/>
		<s:reset 	value="Quitter" 		formaction="#"/>

		</s:form>
</body>
</html>