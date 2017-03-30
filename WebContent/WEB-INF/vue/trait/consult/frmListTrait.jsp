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
				<h2>Consultation des traits</h2>
			</div>

			<br /> <br />

			<div id="formbloc">
				<s:form>

					<s:textfield id="saisieNom" label="Nom du trait" />

					<s:select id="seltype" label="type"
						list="{'Technique', 'Roleplay'}" headerKey="None"
						headerValue="Type de trait" />

				</s:form>

			</div>

		</div>

		<br /> <br />
		<hr width="80" />
		<br /> <br />

		<!-- Zone d'affichage dynamyque -->

		<div id="listbloc">

			<div class="titre">
				<h2>Liste des traits disponibles</h2>
			</div>

			<br /> <br />

			<s:if test="%{listTrait != null}">
			<s:if test="%{listTrait.size()>0}">
				<table border="1">
					<thead>
						<tr>
							<th><s:text name="Nom" 	 /></th>
							<th><s:text name="Effet" /></th>
						</tr>
					</thead>

					<s:iterator value="listTrait">
						<br />

						<s:url namespace="/trait" action="detailTr" var="detailTr">
							<s:param name="idTrait">
								<s:property value="id" />
							</s:param>
						</s:url>

						<tbody>
							<tr>
								<th align="left"><a href="${detailTr}"> <s:property value="libelle"/></a></th>					
								<th align="left"><s:property value="malus" /></th>
							</tr>
						</tbody>
					</s:iterator>

				</table>
			</s:if>
			</s:if>
			
			<s:else>
				<div id="noresult">
					<p> Aucun Trait d'enregistré. </p>
				</div>
			</s:else>

		</div>

	</div>

	<!-- JavaScript -->
	<script src="${pageContext.request.contextPath}/js/trait/consult.js"> 	 </script>
	<script src="${pageContext.request.contextPath}/js/jquery-3.2.0.min.js"> </script>

</body>


</html>