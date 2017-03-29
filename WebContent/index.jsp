<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<s:url namespace="" 	action="cssArathiel" />" />
<link rel="stylesheet" href="./css/index.css" />
<title>Les Royaumes d'Arathiel</title>
</head>
<body>
	<img class="img-header" src="<%=request.getContextPath()%>/img/bannerRA.jpg" alt="LogoArathiel" />
<!-- Div Connexion -->
	<div class="connexion">
		<form name="conexion" action="<%=request.getContextPath()%>/royaume/" onsubmit="return true"><!-- FAIRE JAVA SCRIPT -->
			<fieldset>
			<legend>Se connecter</legend>
			<br />
			<label>Nom d'utilisateur :</label>
			<input id="login" name="login" type="text" placeholder="Nom d'utilisateur"></input>
			<br />
			<label>Mot de passe :</label>
			<input id="password" name="password" type="password" placeholder="Mot de passe"></input>
			<br /><br />
			<input class="bouton" type="submit" value="Connexion"></input>
			<br />
			<br>
		<input type ="radio" name ="radioConnect" value="Admin">Administrateur
		<input type ="radio" name ="radioConnect" value="Visiteur">Visiteur
		<br><br>
			<a href="#">Mot de passe oublié ?</a>
			</fieldset>
		</form>
	</div>	
</body>
</html>