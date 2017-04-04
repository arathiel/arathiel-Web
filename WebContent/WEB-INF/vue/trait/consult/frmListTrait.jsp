<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Consultation</title>
	
	<!-- JQuery et AngularJs -->
  	<script src="<s:url namespace="" 	action="jQuery" />"> 	</script>
	<script src="<s:url namespace="" 	action="angularjs" />">	</script>
	
	<!-- JavaScript -->
	<script src="<s:url namespace="/trait" 	action="jsConsult" />" > </script>

	<link rel="stylesheet" href="<s:url namespace="" 	action="cssArathiel" />"  />	
</head>

<body ng-app="trait">

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"></jsp:include>


	<!-- Zone de recherche -->
	<br />
	<br />

	<div ng-controller="searchCtrl" class="mainbloc">

		<div id="searchbloc">

			<div class="titre">
				<h2>Consultation des traits</h2>
			</div>

			<br /> <br />

			<div id="formbloc">
				<s:form>
					<s:textfield 
						label="Nom du trait"
						ng-model="saisie.libSearch"
						ng-keyup="dynamicSearch()"/>						
				</s:form>

			</div>

		</div>

		<!-- Zone d'affichage dynamyque -->

		<div id="listbloc">

			<br /> <br />

			<table border="1">
				<thead>
					<tr>
						<th>Nom				</th>
						<th>Effet			</th>
						<th>Disponibilité	</th>
						<th>Visibilité		</th>
						<th>Description		</th>
					</tr>
				</thead>

				<tbody>
					<tr ng-repeat="trait in listeTrait">
						
						<!-- Struts2 interprétant en chaîne de caractère ce que je lui envoyais en paramètre, choix de ne pas l'utiliser -->
						<td><a href="/arathiel-Web/trait/detailTr.action?selectId={{trait.id}}">{{trait.libelle}}</a>						</td>	
					
						<!-- Essais de différentes technique pour l'affichage des booléens et de la description -->
						<td ng-if="trait.malus"	>Malus																						</td>
 						<td ng-if="!trait.malus">Bonus																						</td>
						
						<td align="left">{{trait.dispoCrea  ? 'A la création' 	: 'Toujours' }}												</td>
						<td align="left">{{trait.visiPublic ? 'Publique' 		: 'Maître du jeu' }}										</td>
						
						<!-- Limite l'affichage à 50 caractères, si plus grand, affiche '...' à la suite. -->
						<td align="left">{{trait.description.contenu | limitTo: 50 }}{{trait.description.contenu.length > 20 ? '...' : ''}}	</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	
</body>


</html>