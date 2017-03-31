<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Page de listing des races</title>
</head>
<body>
	<!-- HEADER -->
	<!-- Menu en haut � droite et banni�re -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>
	
	
	<h1> Page de Listing des Races</h1>
	<div id="listeRaceDiv">
		<table>
			<tr>
				<th>Nom</th>
				<th>Dispo</th>
				<th>Xp Rendue</th>
			</tr>
			
			
			<s:iterator value="listeRace">
			<tr>

					<td><s:url namespace="/race" action="pageediter" var="raceURL">
							<s:param name="nomRace"><s:property value="nom"/></s:param>
						</s:url>
					
						<a href="${raceURL}">					
							<s:property value="nom"/>
						</a>
					</td>
					<td><s:property value="dispo"/></td>
					<td><s:property value="calculRenduXp()"/></td>
			
			</tr>
			</s:iterator>	
	
		</table>
		
	</div>


</body>
</html>