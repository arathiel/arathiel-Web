<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Consultation</title>

	<link rel="stylesheet" href="<s:url namespace="" 	action="cssArathiel" />"  />	
</head>

<body ng-app="">

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"></jsp:include>


	<!-- Zone de recherche -->
	<br />
	<br />

	<div class="mainbloc" ng-controller="searchCtrl">

		<div id="searchbloc">

			<div class="titre">
				<h2>Consultation des traits</h2>
			</div>

			<br /> <br />

			<div id="formbloc">
				<s:form>
					<s:textfield 
						label="Nom du trait"
						ng-model="saisie.libSaisie" 
						ng-keyup="dynamicSearch()" />						
				</s:form>

			</div>

		</div>

		<!-- Zone d'affichage dynamyque -->

		<div id="listbloc">

			<br /> <br />

			<table border="1">
				<thead>
					<tr>
						<th><s:text name="Nom" /></th>
						<th><s:text name="Effet" /></th>
						<th><s:text name="Dispo Création" /></th>
						<th><s:text name="Visi publique" /></th>
					</tr>
				</thead>

				<tbody>
					<tr ng-repeat="trait in reponse ">
						<td align="left">{{trait.libelle}}</td>
						<td align="left">{{trait.malus}}</td>
						<td align="left">{{trait.dispoCrea}}</td>
						<td align="left">{{trait.visiPublic}}</td>
					</tr>
				</tbody>

			</table>

		</div>

	</div>

	<!-- JavaScript -->
	<script src="<s:url namespace="/trait" 	action="jsConsult" />"   	 ></script>
	<script src="<s:url namespace="" 	   	action="jQuery.action" />"   ></script>
	<script src="<s:url namespace="" 		action="angularjs.action" />"></script>

</body>


</html>