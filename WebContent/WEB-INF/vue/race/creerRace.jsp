<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<s:url namespace="" 		action="cssArathiel" />" />
	<link rel="stylesheet" href="<s:url namespace="/race" 	action="cssRaceEdit" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Page d'�dition des races</title>
<%-- 	<script type="text/javascript" src="../../../js/race/race.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/race/race.js"></script>
</head>
<body>
	<!-- HEADER -->
	<!-- Menu en haut � droite et banni�re -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>
		
		
	<h1> Page de cr�ation des Races</h1>
	<div id="divGeneral">	
		<div id="selections">
			
			<div id="carac">
				<s:select 	id="selectCarac"
							list="listeCarac" 
							name="selectCarac"
							listKey="idCarac"
							listValue="nomCarac"
							headerKey="0"
							headerValue="Choisissez..."
							label="Ajouter une Caracteristique "/>
							
				<s:submit	value="+" 	id="caracPlus"></s:submit>	
				<s:submit	value="-"	id="caracMoins"></s:submit>
			</div>
	
			<div id="trait">
				<s:select 	list="listeTrait" 
							name="selectTrait"
							listKey="id"
							listValue="libelle"
							headerKey="0"
							headerValue="Choisissez..."
							label="Ajouter un Trait "
							/>	
							
				<s:submit	value="+" id="traitPlus"></s:submit>	
				<s:submit	value="-" id="traitMoins"></s:submit>
			</div>
				
			<div id="comp" >	
				<s:select 	list="listeComp" 
							name="selectComp"
							listKey="id"
							listValue="nom"
							headerKey="0"
							headerValue="Choisissez..."
							label="Ajouter une comp�tence " 
							/>	
							
				<s:submit	value="+" id="compPlus"></s:submit>	
				<s:submit	value="-" id="compMoins"></s:submit>
			</div>
		</div>
		
		<div id="resume">
			<form accept-charset=utf-8 action="#" onsubmit="return false" >
				<div id="identRace">
					<s:textfield name="nomRace" 	label="Nom"></s:textfield>
					<s:textfield name="xpRendue" 	label="Xp Rendue" readonly="true"></s:textfield>
				</div>
				
				<div id="bonus">
					<table id="tableBonus">
						<tr>
							<th>Nom</th>
							<th>Valeur</th>
							<th>Acad�mique</th>
						</tr>	
						
						<!-- 		dans ce tableau seront cr��s des bonus � la vol�e chacun remplissant une ligne   -->			
					</table>

				</div>
				
				<div id="bouton">
					<button  id="enregistrer">Creer</button>
					<input type="reset"  id="reset"/>
				</div>		
				
			</form>
				
			<p id="message"></p>
		</div>
	</div>
</body>
</html>