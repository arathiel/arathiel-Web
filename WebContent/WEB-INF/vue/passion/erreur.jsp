<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE >
<html>
<head>
<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Les Royaumes d'Arathiel - Panneau d'administration</title>
</head>
<body>
<!-- HEADER -->
		<!-- Menu en haut � droite et banni�re -->
			<jsp:include page="../../include/header.jsp" />
			<jsp:include page="../../include/menu.jsp"/>
<h1>Probleme !</h1>
<br><br>
<fieldset>
<p> Une erreur a �t� d�tect�e</p>
<br><br>
<s:property value="%{messErreur}"/>
<br><br>
<img src="../../../img/err.jpg">
</fieldset>
</body>
</html>