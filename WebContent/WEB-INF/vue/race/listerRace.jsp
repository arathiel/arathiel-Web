<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
	<link rel="stylesheet" href="<s:url namespace="/race" 	action="cssRaceEdit" />" />
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/race/choixRace.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-3.2.0.min.js"></script>
	<title>Page de listing des races</title>
</head>
<body>
	<!-- HEADER -->
	<!-- Menu en haut à droite et bannière -->
	<jsp:include page="../../include/header.jsp" />
	<jsp:include page="../../include/menu.jsp"></jsp:include>
	
	
	<h1> Page de Listing des Races</h1>
	<div id="listeRaceDiv">
	<span>Cliquez sur le nom d'une race pour accéder à sa page d'édition</span>
	
	
	
		<table id="tableRaces">
			<tr>
				<th class="thNom">Nom</th>
				<th class="thAcad">Dispo</th>
				<th class="thXp">Xp Rendue</th>
			</tr>
			
			
			<s:iterator value="listeRace" var="race">
				<tr>
					<td><s:url namespace="/race" action="pageediter" var="raceURL">
							<s:param name="nomRace"><s:property value="nom"/></s:param>
						</s:url>
						
						<a href="${raceURL}">					
							<s:property value="nom"/>
						</a>
					</td>
					
					<td>
						<s:if test="%{#race.dispo}">
							<s:set var="acad">oui</s:set>
						</s:if>
						<s:else>
							<s:set var="acad">non</s:set>
						</s:else>	
						<s:property value="#acad"/>
					</td>				
						
							
					
<%-- 					<s:property value="dispo"/></td> --%>
					<td><s:property value="calculRenduXp()"/></td>	 
				</tr>			
			</s:iterator>	
	
		</table>
		
	</div>


</body>
</html>