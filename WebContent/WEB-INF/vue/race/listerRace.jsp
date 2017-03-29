<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="../css/Arathiel.css" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Page de listing des races</title>
</head>
<body>
<!-- HEADER -->
		<!-- Menu en haut à droite et bannière -->
		<jsp:include page="../../include/header.jsp" />
		<jsp:include page="../../include/menu.jsp"></jsp:include>


		<h1> Page de Listing des Races</h1>
		<div id="listeRaceDiv">
			<table>
				<tr>
					<th>Id</th>
					<th>Nom</th>
					<th>Dispo</th>
				</tr>
				<s:iterator value="listeRace">
				<tr>
					<s:a namespace="/race" action="choix">
						<td><s:property value="id"/></td>
						<td><s:property value="nom"/></td>
						<td><s:property value="dispo"/></td>
					</s:a>
				</tr>
				</s:iterator>	
	
			</table>
			
		</div>


</body>
</html>