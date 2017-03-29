<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
</head>

<body>

	<!-- Include du Header -->
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include/header"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include/menu"></jsp:include>



	<s:form action		="#">
		<s:textfield 
			label		="cote" 
			name		="document.cote"/>
		
		<s:textfield 
			label		="titre" 
			name		="document.titre"/>

		<s:textarea
			label		="description" 
			name		="document.descriptif"/>
			
		<s:textfield
			label		="Nombre exemplaire" 
			name		="document.nbExemplaireDispo"/>
        
        <s:select
            label		="Auteur"
            list		="listAuteur"
            listKey		="id"
            listValue	="prenom + ' ' + nom"
            name		="selectidAuteur"
            headerKey	="None"
            headerValue	="Choisissez un auteur"/>
            
        <s:select
            label		="Themes"
            list		="listTheme"
            listKey		="id"
            listValue	="nom"
            name		="selectlistIdTheme"
            headerKey	="None"
            multiple	="true"/>
                                          
        <s:textfield
			label		="Lieu" 
			name		="localisation.lieu"/>
		
		<s:textfield
			label		="Emplacement" 
			name		="localisation.emp"/>
			
		<s:submit value="Enregistrer"/>
		
	</s:form>
	
</body>

</html>


