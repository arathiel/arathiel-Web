<%@ page language="java" contentType="text/html; UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<s:url namespace="" 		action="cssArathiel" />" />
	<link rel="stylesheet" href="<s:url namespace="/race" 	action="cssRaceEdit" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Page d'édition des races</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/race/race.js"></script>
</head>
<body>
	<!-- HEADER -->
	<!-- Menu en haut à droite et bannière -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>
		
		
	<h1> Page d'édition des Races</h1>
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
							label="Ajouter une compétence " 
							/>	
							
				<s:submit	value="+" id="compPlus"></s:submit>	
				<s:submit	value="-" id="compMoins"></s:submit>

			</div>
		</div>
		
		<div id="resume">
			<form accept-charset=utf-8 action="#" onsubmit="return false">
				<div id="identRace">	
					<s:textfield name="idRace" 		label="Id" 	readonly="true"></s:textfield>
					<s:textfield name="nomRace" 	label="Nom"></s:textfield>
					<s:textfield name="xpRendue" 	label="Xp Rendue"></s:textfield>
					
					<label>Disponible : </label>
					<input type="checkbox"  id="dispo" <s:if test="%{chkAcad=='true'}">checked = "checked"</s:if>/>
				
				</div>
				
				<div id="bonus">
					<table id="tableBonus">
<!-- 		dans ce tableau seront créés des bonus à la volée chacun remplissant une ligne   -->
						<tr>
							<th>Nom</th>
							<th>Valeur</th>
							<th>Académique</th>
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
								<s:set var ="idLigne" value ="'Tra'+#bonus.getTraitAssocie().getId()" ></s:set>
								<tr id= "<s:property value="#idLigne"/>">
									<td>
										<s:property value="#bonus.getTraitAssocie().getLibelle()"/>
									</td>
									<td><s:property value="valeurBonus"/></td>
								</tr>
							</s:if>
							
							<s:if test="%{#bonus instanceof entity.race_bonus_carac.bonus.BonusCompetence}">
								<s:set var ="idLigne" value ="'Com'+#bonus.getCompAssociee().getId()" ></s:set>
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
					<button id="modifier">Modifier</button>
					<button	id="supprimer">Supprimer</button>
					<input	type="reset"  id="reset">
				</div>
			
			</form>
			
		</div>
	</div>
</body>
</html>