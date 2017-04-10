<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Consultation de Trait</title>

	<!-- CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
</head>

<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>


	<div class="row container">
		<s:form 
			class		="form-horizontal" 
			role		="form" 
			theme		="simple"
			method		="post">
			
			<fieldset>
			<!-- Zone d'affichage du message -->
			<br />	
			<s:if test="%{message != null}">
				<div class="alert alert-info">
  					<strong>
  						<s:property value="%{message}"/>
  					</strong>
				</div>
			</s:if>		
			<br />
			
			<h2>Consultation détaillée</h2>
			<br />
			
				<!-- Nom du trait -->
				<div class="form-group">
					<label class="col-md-2 control-label" for="nom">Nom :</label>
					<div class="col-md-4">
						<s:textfield id="nom" 
							name		="trait.libelle"
							value		="%{trait.libelle}"
							placeholder	="Nom du trait" 
							class		="form-control input-md disable"
							type		="text" 
							disabled	="true"/>

					</div>
				</div>

				<!-- Description du trait -->
				<div class="form-group ">
					<label class="col-md-2 control-label" for="thresholdvalue">Descriptions :</label>
					<div class="col-md-4">
						<s:textarea 
							placeholder	="Description"
							name		="trait.description.contenu" 
							type		="text"
							value		="%{trait.description.contenu}" rows="10" cols="30"
							class		="form-control input-md disable" 
							disabled	="true"/>
					</div>
				</div>

				<!-- Choix Bonus/Malus -->
				<div class="form-group">
					<label class="col-md-2 control-label" for="reqType">Type :</label>
					<div class="col-md-4">
						<s:radio 
							name			="malus"
							value			="%{malus}"
							labelposition	="inline"
							list			="{'Bonus', 'Malus'}" 
							class			="radio-inline disable"
							disabled		="true"/>
					</div>
				</div>

				<!-- Choix de la visibilité -->
				<div class="form-group">
					<label class="col-md-2 control-label" for="dataFormat">Visibilité :</label>
					<div class="col-md-4">
						<s:radio 
							label			="Visibilité" 
							name			="visi"
							value			="%{visi}" 
							labelposition	="inline"
							list			="{'Maître jeu', 'Publique'}" 
							class			="radio-inline disable"		
							disabled		="true"/>
					</div>
				</div>

				<!-- Choix de la disponibilité -->
				<div class="form-group">
					<label class="col-md-2 control-label" for="dataFormat">Disponibilité :</label>
					<div class="col-md-4">
						<s:radio 
							label			="Disponibilité" 
							name			="dispo"
							value			="%{dispo}" 
							labelposition	="inline" 
							list			="{'A la création', 'Toujours'}"
							class			="radio-inline disable"
							disabled		="true"/>
					</div>
				</div>

				<!-- Affichage d'un tableau avec les comportements du trait (l'idéal aurait été de traiter l'objet dans un DTO dans bean pour affichage, non ici)-->
				<div class="container col-md-10 listComp">
					<s:if test="%{trait.listComp.size()>0}">

						<table class="table table-striped">
							<caption>Comportement(s)</caption>
							<thead>
								<tr>
									<th>Nom</th>
									<th>Type</th>
									<th>Modificateur</th>
								</tr>
							</thead>


							<s:iterator value="trait.listComp" var="comp">
								<br />
								<tbody>
									<tr>
										<!-- Affichage du libellé -->
										<td align="left"><s:property value="libelle" /></td>

										<!-- Affichage du type de comportement -->
										<s:if
											test="%{#comp instanceof entity.trait.comportement.CompCaracteristique}">
											<td align="left">Caractéristique</td>
										</s:if>
										<s:elseif
											test="%{#comp instanceof entity.trait.comportement.CompRoleplay}">
											<td align="left">Roleplay</td>
										</s:elseif>

										<!-- Affichage du modificateur -->
										<s:if
											test="%{#comp instanceof entity.trait.comportement.CompCaracteristique}">
											<s:if test="%{caracteristique != null}">
												<td align="left"><s:property
														value="caracteristique.nomCarac" /></td>
											</s:if>
											<s:else>
												<td align="left">Aucune caractéristique associée</td>
											</s:else>
										</s:if>
										<s:elseif
											test="%{#comp instanceof entity.trait.comportement.CompRoleplay}">
											<td align="left">jeu d'acteur</td>
										</s:elseif>
									</tr>
								</tbody>
							</s:iterator>

						</table>
					</s:if>
					<s:else>
						<h4> Aucun comportement associé </h4>
					</s:else>
				</div>

				<br />

				<!-- Boutons Modifier et supprimer -->
				<div class="form-group">
					<div class="col-md-4">
						<s:url namespace="/trait" action="frmUpdateAdm" var="frmUpdateAdm" />
						<s:submit formaction="${frmUpdateAdm}" class="btn btn-warning" value="Modifier"/>
					
						<s:url namespace="/trait" action="deleteAdm" var="deleteAdm" />
						<s:submit formaction="${deleteAdm}" class="btn btn-danger" value="Supprimer"/>
						
						<s:hidden name="trait.libelle" 	value="%{trait.libelle}"/>
						<s:hidden name="id" 			value="%{trait.id}"		/>
					</div>
				</div>
		
			</fieldset>
		</s:form>
	</div>


	<!-- JQuery et AngularJs -->
  	<script src="<s:url namespace="" 	action="jQuery" 	 />"	></script>
	<script src="<s:url namespace="" 	action="angularjs" 	 />"	></script>
	
	<!-- Js de la page -->
	<!-- JavaScript -->
	<script src="<s:url namespace="/trait" 	action="jsTrait" />" ></script>

</body>

</html>


