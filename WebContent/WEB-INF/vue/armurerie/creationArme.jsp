<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"    uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création Arme</title>
</head>
<body>
	<h3>Création Arme</h3>
	<br/>
	<br/>
	<s:if test="hasFieldErrors()">
		<s:fielderror>Les erreurs suivantes se sont produites : </s:fielderror>
	</s:if>
	<s:if test="hasActionMessages()">
		<s:actionmessage id="actionmessage" label="actionmessage :" />
	</s:if>
	<s:form namespace="/armurerie" 		action="creationArmeValide" method="post">
		<p>Nom : <s:textfield 		name="armeDto.nom"/></p>	
		<p>Races : <s:checkboxlist 	name="tabRaces" 				list="races" 		accesskey="idRace"/></p>								
		<p>Encombrement : <select 	name="armeDto.encombrement"		type="number"  >
				<option></option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
		</select></p>							
		<p>Prix : <s:textfield 	name="armeDto.prix" 	type="number"/></p>
		<p>Monnaie : <select 	name="armeDto.monnaie"	class="monnaie">
				<option>Cuivre</option>
				<option>Argent</option>
				<option>Or</option>
			</select>
		</p>
		<label class="drucks">Drucks</label>
		<br/>
		<br/>
		
		<s:url namespace="/armurerie" 	action="creationArmeValide" 		var="creationArmeValide"/>
		
		<s:submit 	value="Vérifier" 	formaction="#"/>	
		<s:submit 	value="Créer" 		formaction="${creationArmeValide}"/>
		<s:reset 	value="Quitter" 	formaction="#"/>

	</s:form>				
</body>
</html>