<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Armurerie</title>
</head>
<body>
	<h1>Armurerie</h1>
	<a href="<%=request.getContextPath()%>/armurerie/arme"><input type="button" name="btnArme" class="btnArmurerie" value="Arme"/></a>
	<a href="<%=request.getContextPath()%>/armurerie/armure"><input type="button" name="btnArmure" class="btnArmurerie" value="Armure"/></a>

</body>
</html>