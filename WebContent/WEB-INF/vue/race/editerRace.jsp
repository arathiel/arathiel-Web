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
		
		
	<h1> Page d'�dition des Races</h1>
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
<%-- 				<s:checkbox id="acad" name="chkAca" label="Acad�mique "></s:checkbox> --%>
			</div>
		</div>
		
		<div id="resume">
			<form accept-charset=utf-8>
				<div id="identRace">	
					<s:textfield name="idRace" 		label="Id" 	readonly="true"></s:textfield>
					<s:textfield name="nomRace" 	label="Nom"></s:textfield>
					<s:textfield name="xpRendue" 	label="Xp Rendue"></s:textfield>
				</div>
				
				<div id="bonus">
					<table id="tableBonus">
<!-- 		dans ce tableau seront cr��s des bonus � la vol�e chacun remplissant une ligne   -->
						<tr>
							<th>Nom</th>
							<th>Valeur</th>
							<th>Acad�mique</th>
						</tr>	
						
						<s:iterator value="listeBonus" var="bonus">
							<s:if test="%{#bonus instanceof entity.race_bonus_carac.bonus.BonusCarac}">
								<s:set var ="idLigne" value ="'Car'+#bonus.getCaracAssociee().getIdCarac()" ></s:set>
								<tr id= "<s:property value="#idLigne"/>">
									<td>
											<s:property value="#bonus.getCaracAssociee().getNomCarac()"/>
									</td>
									<td><s:property value="valeurBonus"/></td>
								</tr>
							</s:if>
								
							<s:if test="%{#bonus instanceof entity.race_bonus_carac.bonus.BonusTrait}">
								<s:set var ="idLigne" value ="'Trait'+#bonus.getTraitAssocie().getId()" ></s:set>
								<tr id= "<s:property value="#idLigne"/>">
									<td>
											<s:property value="#bonus.getTraitAssocie().getLibelle()"/>
									</td>
									<td><s:property value="valeurBonus"/></td>
								</tr>
							</s:if>
							
							<s:if test="%{#bonus instanceof entity.race_bonus_carac.bonus.BonusCompetence}">
								<s:set var ="idLigne" value ="'Comp'+#bonus.getCompAssociee().getId()" ></s:set>
								<tr id= "<s:property value="#idLigne"/>">
									<td>
											<s:property value="#bonus.getCompAssociee().getNom()"/>
									</td>
									<td><s:property value="valeurBonus"/></td>
									<td> <input type = "checkbox"
											<s:if test="%{#bonus.isAcademique()}">
											checked = "checked"
											</s:if>
										/> 
									</td>
								</tr>	
							</s:if>
						</s:iterator>			
					</table>

				</div>
				
				<div id="bouton">
					<button type="button" id="modifier">Modifier</button>
					<s:submit	value="Supprimer" 	id="suppr"></s:submit>
					<input type="reset"  id="reset"/>
				</div>
			
			</form>
			
		</div>
	</div>
</body>
</html>