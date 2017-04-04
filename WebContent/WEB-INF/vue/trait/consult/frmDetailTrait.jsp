<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Création de Trait</title>
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
</head>

<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
		
		
	<div id="mainBloc">
		<s:form>
		<s:label name="id">id : <s:property value="trait.id" /> </s:label>
		
		<s:textfield
			label="Nom"
			value=""
			name="libelle"
			disabled="true"/>
		
<%-- 		<s:radio --%>
<%--             label="Visibilité" --%>
<%--             labelposition="inline" --%>
<%--             list="{'Publique', 'Maître du jeu'}" --%>
<%--             name="visiPublic" --%>
<%--             value="" --%>
<%--             disabled="true"/> --%>
            
<%--         <s:radio --%>
<%--             label="Disponibilité" --%>
<%--             labelposition="inline" --%>
<%--             list="{'Création', 'Toujours'}" --%>
<%--             name="dispoCrea" --%>
<%--             value="" --%>
<%--             disabled="true"/> --%>
                
<%--         <s:radio --%>
<%--             label="Visibilité" --%>
<%--             labelposition="inline" --%>
<%--             list="{'Bonus', 'Malus'}" --%>
<%--             name="malus" --%>
<%--             value="" --%>
<%-- 			disabled="true"/> --%>


		<!-- Affichage d'un tableau avec les comportements du trait -->
<%-- 		<s:if test="%{trait.listComp.size()>0}"> --%>
<!-- 			<table border="1"> -->
<!-- 				<thead> -->
<!-- 					<tr> -->
<%-- 						<th><s:text name="Nom" /></th> --%>
<%-- 						<th><s:text name="Type" /></th> --%>
<%-- 						<th><s:text name="Modificateur" /></th> --%>
<%-- 						<th><s:text name="Description" /></th> --%>
<!-- 					</tr> -->
<!-- 				</thead> -->


<%-- 				<s:iterator value="trait.listComp"> --%>
<!-- 					<br /> -->
<!-- 					<tbody> -->
<!-- 						<tr> -->
<!-- 							Affichage du libellé -->
<%-- 							<td align="left"><s:property value="libelle" /></td> --%>

<!-- 							Affichage du type de comportement -->
<%-- 							<s:if test="getClass() instanceOf CompCaracteristique.class"> --%>
<!-- 								<td align="left">Caractéristique</td> -->
<%-- 							</s:if> --%>
<%-- 							<s:elseif test="getClass() instanceOf CompRoleplay.class"> --%>
<!-- 								<td align="left">Roleplay</td> -->
<%-- 							</s:elseif> --%>
							
<!-- 							Affichage du modificateur -->
<%-- 							<s:if test="getClass() instanceOf CompCaracteristique.class"> --%>
<%-- 								<td align="left"><s:property value="caracteristique.getNomCarac()" /> </td> --%>
<%-- 							</s:if> --%>
<%-- 							<s:elseif test="getClass() instanceOf CompRoleplay.class"> --%>
<!-- 								<td align="left">Pur jeu d'acteur</td> -->
<%-- 							</s:elseif> --%>
<!-- 						</tr> -->
<!-- 					</tbody> -->
<%-- 				</s:iterator> --%>

<!-- 			</table> -->
<%-- 		</s:if> --%>
<%-- 		<s:else> --%>
<%-- 			<p> Aucun comportement associé à <s:property value="trait.libelle"/> <p> --%>
<%-- 		</s:else> --%>
		
		<s:textarea 
			label="Description : "
			value="trait.description.contenu"
			disabled="true"/>/>
	</s:form>
	</div>	
</body>

</html>


