<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Consultation</title>
	
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
</head>

<body>

	<!-- Include du Header -->
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include/header"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include/menu"></jsp:include>
		
		
	<h2 id="titre"><s:text name="Consultation des traits"/></h2>
	
	<br/>
	<br/>
	
	<div>
		<s:textfield 
			label	="Nom du trait"
			id		="saisie"/>
			
		<s:select
            label		="type"
            id			="seltype"
            list		="{'Technique', 'Roleplay'}"
            headerKey	="None"
            headerValue	="Choisissez un type de trait"/>
	
	</div>
		
	<br/>
	<br/>
		
	<hr/>
	
	<br/>
	<br/>

	<div id="response"></div>
	
</body>


</html>