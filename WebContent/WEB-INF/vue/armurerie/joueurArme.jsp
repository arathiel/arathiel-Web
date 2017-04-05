<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" 	content="text/html; charset=UTF-8">
<title>Joueur</title>
</head>
<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
	
	<s:form namespace="/armurerie" 		action="joueurArmeValide" 	method="post">
		<p>Joueur : <s:select 	name="joueurId" 			list="joueurs" 	listValue="nomJoueur" 	listKey="idJoueur"/></p>
		<p>Arme :	<s:select 	name="armeId" 				list="armes" 	listValue="nom" 		listKey="idArme"/></p>
		<p>Etat : 	<s:radio 	name="etat" 	list="{'neuf','usage','casse'}"/></p>
		
		<s:url namespace="/armurerie"	action="joueurArmeValide" 	var="joueurArmeValide"/>
		
		<s:submit 	value="Enregistrer" formaction="${joueurArmeValide}"/>
		<s:reset 	value="Quitter" 	formaction="#"/>
	</s:form>
</body>
</html>