<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="fr">
<head>
<link rel="stylesheet" href="<s:url namespace="" 		action="cssArathiel" />" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message Erreur</title>
</head>
<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
	
	<h2>Voici l'erreur qui s'est produite :</h2>
	<p><s:property value="%{messageErreur}"/></p>

</body>
</html>