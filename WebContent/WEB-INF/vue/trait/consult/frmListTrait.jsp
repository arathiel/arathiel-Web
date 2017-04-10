<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Consultation</title>

	<!-- CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />"  />	
</head>

<body ng-app="trait">

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"></jsp:include>
	

	<!-- Zone de recherche -->
	<br />
	<br />

	<div ng-controller="listCtrl" class="container">
		<!-- Zone d'affichage du message -->
		<br />
	
		<s:if test="%{message != null}">
			<div class="alert alert-info">
  				<strong>
  					<s:property value="%{message}"/>
  				</strong>
			</div>
		</s:if>	
	
		<br />

		<div class="titre">
			<h2>Consultation des traits</h2>
		</div>

		<br /> <br />

		<s:form class="form-horizontal" role="form" theme="simple"
			action="addAdm" method="post">
			<fieldset>

				<!-- Zone de recherche -->
				<div class="form-group">
					<label class="col-md-2 control-label" for="nom">Nom :</label>
					<div class="col-md-4">
						<s:textfield 
							id="nom" 
							placeholder="Rechercher un trait"
							class="form-control input-md" 
							type="text"
							ng-model="saisie.libSearch" 
							ng-keyup="dynamicSearchTr()" />
					</div>
				</div>

				<!-- Zone d'affichage dynamyque -->

				<br /> <br />

				<table class="table table-striped">
					<thead>
						<tr>
							<th>Nom</th>
							<th>Effet</th>
							<th>Disponibilité</th>
							<th>Visibilité</th>
							<th>Description</th>
						</tr>
					</thead>

					<tbody>
						<tr ng-repeat="trait in listeTrait">

							<!-- Struts2 interprétant en chaîne de caractère ce que je lui envoyais en paramètre, choix de ne pas l'utiliser mais pb de sécurité -->
							<td><a
								href="${pageContext.request.contextPath}/trait/detailTr.action?selectId={{trait.id}}">{{trait.libelle}}</a>
							</td>

							<!-- Essais de différentes technique pour l'affichage des booléens et de la description -->
							<td ng-if="trait.malus">Malus</td>
							<td ng-if="!trait.malus">Bonus</td>

							<td align="left">{{trait.dispoCrea ? 'A la création' :
								'Toujours' }}</td>
							<td align="left">{{trait.visiPublic ? 'Publique' : 'Maître
								du jeu' }}</td>

							<!-- Limite l'affichage à 50 caractères, si plus grand, affiche '...' à la suite. -->
							<td align="left">{{trait.description.contenu | limitTo: 50
								}}{{trait.description.contenu.length > 20 ? '...' : ''}}</td>
						</tr>
					</tbody>
				</table>
			
			</fieldset>
		</s:form>
	</div>
	
	<!-- JQuery et AngularJs -->
  	<script src="<s:url namespace="" 	action="jQuery" />"		 ></script>
	<script src="<s:url namespace="" 	action="angularjs" />"	 ></script>
	
	<!-- JavaScript -->
	<script src="<s:url namespace="/trait" 	action="jsTrait" />" ></script>
</body>


</html>