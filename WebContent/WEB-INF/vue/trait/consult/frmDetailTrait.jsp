<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Création de Trait</title>

	<!-- CSS -->
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
</head>

<body ng-app="trait" ng-controller="detailCtrl">

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
		
		
	<div id="mainBloc">
	
		<s:form action="deleteAdm" method="post" theme="simple">
			
		<s:textfield
			class="update"
			label="Nom"
			value="%{trait.libelle}"
			name="trait.libelle"
			disabled="true"/>
		
		<s:radio
			class="update"
			label="Visibilité"
			labelposition="inline"
			list="{'Publique', 'Maître du jeu'}"
            name="visi"
			value="%{visi}"
			disabled="true"/>
            
        <s:radio
        	class="update"
            label="Disponibilité"
            labelposition="inline"
            list="{'Création', 'Toujours'}"
            name="dispo"
            value="%{dispo}"
            disabled="true"/>
                
        <s:radio
        	class="update"
			label="Visibilité"
			labelposition="inline"
			list="{'Bonus', 'Malus'}"
			name="malus"
			value="%{malus}"
			disabled="true"/>


		<!-- Affichage d'un tableau avec les comportements du trait (l'idéal aurait été de traiter l'objet dans un DTO dans bean pour affichage, non ici)-->
		<div id="listComp">
		<s:if test="%{trait.listComp.size()>0}">
			<h2>Liste des comportements</h2>
			<table border="1">
				<thead>
					<tr>
						<th>Nom</th>
						<th>Type</th>
						<th>Modificateur</th>
					</tr>
				</thead>


					<s:iterator value="trait.listComp" var="comp">
						<br />
						<tbody>
							<tr>
								<!-- Affichage du libellé -->
								<td align="left"><s:property value="libelle" /></td>

								<!-- Affichage du type de comportement -->
								<s:if
									test="%{#comp instanceof entity.trait.comportement.CompCaracteristique}">
									<td align="left">Caractéristique</td>
								</s:if>
								<s:elseif
									test="%{#comp instanceof entity.trait.comportement.CompRoleplay}">
									<td align="left">Roleplay</td>
								</s:elseif>

								<!-- Affichage du modificateur -->
								<s:if
									test="%{#comp instanceof entity.trait.comportement.CompCaracteristique}">
									<s:if test="%{caracteristique != null}">
										<td align="left"><s:property value="caracteristique.nomCarac" /></td>
									</s:if>
									<s:else>
										<td align="left">Aucune caractéristique associée</td>
									</s:else>
								</s:if>
								<s:elseif
									test="%{#comp instanceof entity.trait.comportement.CompRoleplay}">
									<td align="left">jeu d'acteur</td>
								</s:elseif>
							</tr>
						</tbody>
					</s:iterator>

				</table>
		</s:if>
		<s:else>
			<p> Aucun comportement associé à <s:property value="trait.libelle"/> <p>
		</s:else>
		</div>
		
		<s:textarea
			class="update"
 			label="Description"
			value="%{trait.description.contenu}"
			rows="10"
			cols="30"
			disabled="true"/>
	 		
	 	<s:submit value="Supprimer"/>
	 	
	 	<s:hidden name="id" value="%{trait.id}" />
	</s:form>
	
		<button id="btnsup" ng-click="btnModifier()">Modifier</button>
	
	</div>	
	
	
	<!-- JQuery et AngularJs -->
  	<script src="<s:url namespace="" 	action="jQuery" 	 />"	></script>
	<script src="<s:url namespace="" 	action="angularjs" 	 />"	></script>
	
	<!-- Js de la page -->
	<!-- JavaScript -->
	<script src="<s:url namespace="/trait" 	action="jsTrait" />" ></script>

</body>

</html>


