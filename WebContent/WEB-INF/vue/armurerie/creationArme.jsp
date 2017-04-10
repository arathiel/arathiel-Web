<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s"    uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<link rel="stylesheet" href="<s:url namespace="" 		action="cssArathiel" />" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création Arme</title>
</head>
<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
	
	<h2>Création Arme</h2>
	<br/>
	<br/>
	<s:if test="hasFieldErrors()">
		<ul>
			<s:fielderror>Les erreurs suivantes se sont produites : </s:fielderror>
		</ul>
	</s:if>
	<hr>
	<s:if test="hasActionErrors()">
		<s:actionerror id="actionerror" label="actionerror : "/>
	</s:if>
	<hr>
	<s:if test="hasActionMessages()">
		<s:actionmessage id="actionmessage" label="actionmessage :" />
	</s:if>
	<hr>
	
	<s:form namespace="/armurerie" 		action="creationArmeValide" method="post" theme="simple">
		<p>Nom : <s:textfield 		name="armeDto.nom"/></p>	
		<p>Races : <s:checkboxlist 	name="tabRaces" 				list="nomRaces" 		accesskey="idRace"/></p>								
		<p>Encombrement : <select 	name="armeDto.encombrement"		type="number"  >
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
		</select></p>							
		<p>Prix : <s:textfield 		name="armeDto.prix" 			type="number"/></p>
		<p>Monnaie : <select 		name="armeDto.monnaie"			class="monnaie">
				<option>Cuivre</option>
				<option>Argent</option>
				<option>Or</option>
			</select>
		</p>
		<label class="drucks">Drucks</label>
		<br/>
		<br/>
		
		<s:url 		namespace="/armurerie" 	action="creationArmeValide" 		var="creationArmeValide"/>
		<s:url 		namespace="/armurerie" 	action="accueil" 					var="quitter"/>
			
		<s:submit 	value="Créer" 			formaction="${creationArmeValide}"/>
		<s:reset 	value="Quitter" 		formaction="${quitter}"/>

	</s:form>				
</body>
</html>