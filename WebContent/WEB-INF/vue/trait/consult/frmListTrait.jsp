<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Consultation</title>

	<link rel="stylesheet" href="<s:url namespace="" 	action="cssArathiel" />"  />	
</head>

<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"></jsp:include>


	<!-- Zone de recherche -->
	<br />
	<br />

	<div class="mainbloc">

		<div id="searchbloc">

			<div class="titre">
				<h2>"Consultation des traits"</h2>
			</div>

			<br />
			<br />

			<div id="formbloc">
				<s:form>
				<input type="text" id="saisieNom" /> 

<%-- 					<s:textfield --%>
<%-- 						id="saisieNom" --%>
<%-- 						label="Nom du trait"/> --%>

					<s:select 
						id="seltype"
						label="type" 
						list="{'Technique', 'Roleplay'}" 
						headerKey="None"
						headerValue="Type de trait"/>

				</s:form>

			</div>

		</div>

		<br />
		<br />
		<hr width="80" />
		<br />
		<br />

		<!-- Zone d'affichage dynamyque -->

		<div id="listbloc">

			<div class="titre">
				<h2>Liste des traits disponibles</h2>
			</div>

			<br />
			<br />

			<div id="resultbloc"></div>

		</div>

	</div>

	<!-- JavaScript -->
	<script src="${pageContext.request.contextPath}/js/trait/consult.js"> 	 </script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js"> </script>

</body>


</html>