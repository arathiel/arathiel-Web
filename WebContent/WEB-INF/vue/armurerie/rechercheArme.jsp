<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
	<p> Lister les armes par race : <s:textfield id="listerArmeRace"/>
	<table class="listArme">
				<tr id="tr1">
					<th>Nom</th>
					<th>Races</th>
					<th>Encombrement</th>
					<th>Prix</th>
					<th>Monnaie</th>
				</tr>		
		        <s:iterator value="listArme">
			        <tr id="tr2">
						<td class="nom">			<s:property 	value="nom"/></td>
						<td class="races">			<s:property 	value="races"/></td>
						<td class="encombrement">	<s:property 	value="encombrement"/></td>
						<td class="prix">			<s:property 	value="prix"/></td>
						<td class="monnaie">		<s:property 	value="monnaie"/></td>
			        </tr>
		 		</s:iterator>
	 </table>