<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Page d'édition des races</title>
<%-- 	<script type="text/javascript" src="../../../js/race/race.js"></script> --%>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/race/race.js"></script>
</head>
<body>
	<!-- HEADER -->
	<!-- Menu en haut à droite et bannière -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>
		
		
		<h1> Page d'édition des Races</h1>
		
		<div class="selections">
			
			<div id="carac">
				<s:select 	id="selectCarac"
							list="listeCarac" 
							name="selectCarac"
							listKey="idCarac"
							listValue="nomCarac"
							headerKey="0"
							headerValue="Choisissez..."
							label="Ajouter une Caractéristique "/>
							
				<s:submit	value="+" 	id="caracPlus"></s:submit>	
				<s:submit	value="-"	id="caracMoins"></s:submit>
			</div>
	
			<div id="trait">
				<s:select 	list="listeTrait" 
							name="selectTrait"
							listKey="id"
							listValue="nom"
							headerKey="0"
							headerValue="Choisissez..."
							label="Ajouter un trait "/>	
							
				<s:submit	value="+" id="traitPlus"></s:submit>	
				<s:submit	value="-" id="traitMoins"></s:submit>
			</div>
				
			<div id="comp">		
				<s:select 	list="listeComp" 
							name="selectComp"
							listKey="id"
							listValue="nom"
							headerKey="0"
							headerValue="Choisissez..."
							label="Ajouter une Compétence "/>	
							
				<s:submit	value="+" id="compPlus"></s:submit>	
				<s:submit	value="-" id="compMoins"></s:submit>
				<s:checkbox id="acad" name="chkAca" label="Académique "></s:checkbox>
			</div>
		</div>
		
		<div id="resume">
		
			<div id="identRace">
			<s:form>
				<s:textfield name="idRace" 		label="Id"></s:textfield>
				<s:textfield name="nomRace" 	label="Nom"></s:textfield>
				<s:textfield name="xpRendue" 	label="Xp Rendue"></s:textfield>
				
				<div id="bonus">
					
				
				</div>
				
				<s:submit	value="Modifier" 	id="modif"></s:submit>	
				<s:submit	value="Supprimer" 	id="suppr"></s:submit>
			</s:form>
			
			</div>
			
		</div>
</body>
</html>