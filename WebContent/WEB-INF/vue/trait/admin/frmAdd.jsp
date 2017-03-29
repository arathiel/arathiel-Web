<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	
	<link rel="stylesheet" href="<s:url namespace= "" action="cssheader" />" />
	<link rel="stylesheet" href="<s:url namespace= "" action="cssMenu" />" />	
</head>

<body>

	<!-- Include du Header -->
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include/header"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="${pageContext.request.contextPath}/WEB-INF/include/menu"></jsp:include>


</body>

</html>


