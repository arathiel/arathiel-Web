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
		
		
		
		<h2>Création de trait</h2>
		<br />
	
		<s:form action	="">
		
			<s:textfield 
				label		="Nom" 
				name		="trait.nom"/>
			
			<s:select
            	label		="Type"
            	name		="selectType"
            	list		="{'Technique', 'Roleplay'}"	
            	headerKey	="None"
            	emptyOption	="true"
            	headerValue	="Choisissez type"/>
            	
			<s:textarea 
				label		="titre" 
				name		="descr"/>
        	 
         	<s:radio
            	label="Effet"
            	name="selectMalus"
            	labelposition="inline"
            	list="{'Bonus', 'Malus'}"/>
            	
            <s:radio
            	label="Disponibilité"
            	name="selectDispo"
            	labelposition="inline"
            	list="{'Création', 'Toujours'}"/>
            	
            <s:radio
            	label="Visibilité"
            	name="selectVisi"
            	labelposition="inline"
            	list="{'MJ', 'Public'}"/>

       		<s:submit value="Enregistrer"/>
		
		</s:form>
	
</body>

</html>


