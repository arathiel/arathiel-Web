<jsp:directive.page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" />

<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>

<html lang="fr">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Arathiel - Création de Trait</title>
	
	<!-- CSS -->
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<link rel="stylesheet" href="<s:url namespace="" action="cssArathiel" />" />
</head>

<body>

	<!-- Include du Header -->
	<jsp:include page="/WEB-INF/include/header.jsp"></jsp:include>

	<!-- Include du menu -->
	<jsp:include page="/WEB-INF/include/menu.jsp"  ></jsp:include>
		
<div class="container">

<!-- Zone d'affichage du message -->
	<br /><br />
	
	<s:if test="%{message != null}">
		<div class="alert alert-info">
  			<strong>
  				<s:property value="%{message}"/>
  			</strong>
		</div>
	</s:if>	
	
	<br />

	<div class="row">
		<s:form 
			class		="form-horizontal" 
			role		="form" 
			theme		="simple"
			namespace	="/trait" 
			action		="updateAdm" 
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
			
				<h2>Modification de trait</h2>
				<br />
                
                <!-- Nom du trait -->             
                <div class="form-group">
  					<label class="col-md-2 control-label" for="nom">Nom :</label>  
  					<div class="col-md-4">
  						<s:textfield 
  							id				="nom" 
  							name			="trait.libelle" 
  							placeholder		="Nom du trait" 
  							class			="form-control input-md" 
  							type			="text"/>
    
  					</div>
				</div>
						
				<!-- Les selction du type et du Comportement -->
				<div id="compBox" class="row">
				
    				<!-- Selection du type -->
    				<label class="col-md-2 control-label" for="type">Comportement :</label>                   
                    <div class="col-md-2">
                        <s:select
                        	id			="type"
                        	class		="form-control"
            				list		="{'Caractéristique', 'Roleplay', 'Tous'}"	
            				headerKey	="-1" 
            				headerValue	="Choisissez un type"/>
                    </div>
                    
    				 <!-- Selection du comportement -->
                    <div class="col-md-3">
                        <s:select
                        	id			="comp"
                         	class		="form-control"
            				name		="selectListComp"
            				listKey		="key"
            				list		="listComp"
            				listValue	="libelle"
            				headerKey	="-1" 
            				headerValue	="comportement(s)"
            				multiple	="true"/>				
					</div>
				</div>
   				
   				<br />
   				
                <!-- Description du trait -->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="thresholdvalue">Descriptions :</label>
                    <div class="col-md-4">
                        <s:textarea
                        	placeholder	="Description" 
                         	name		="trait.description.contenu"
                        	type		="text" 
                        	class		="form-control input-md"/>
                    </div>
                </div>
                
                <!-- Choix Bonus/Malus -->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="reqType">Type :</label>
                    <div class="col-md-4">
                        <s:radio
             				name			="malus"
            				labelposition	="inline"
            				list			="{'Bonus', 'Malus'}" 
            				class			="radio-inline"/>                       
                    </div>
                </div>
                
                <!-- Choix de la visibilité -->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="dataFormat">Visibilité :</label>
                    <div class="col-md-4">
                    <s:radio
            			label			="Visibilité"
            			name			="visi"
            			labelposition	="inline"
            			list			="{'Maître jeu', 'Publique'}"
            			class			="radio-inline"/>
                    </div>
                </div>
                
                <!-- Choix de la disponibilité -->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="dataFormat">Disponibilité :</label>
                    <div class="col-md-4">
                        <s:radio
            				label			="Disponibilité"
            				name			="dispo"
            				labelposition	="inline"
            				list			="{'A la création', 'Toujours'}"
            				class			="radio-inline"/>	
                    </div>
                </div>
 
                <!-- Bouton d'action -->
                <div class="form-group">
                    <label class="col-md-2 control-label" for="submitButton"></label>
                    <div class="col-md-8">
                        <s:submit class="btn btn-success" value="Enregistrer"/>                    
                        <button name="btnCancel" class="btn btn-danger" type="reset">Annuler</button>
                        
                       <s:hidden name="id" value="%{trait.id}"/>
                    </div>
                </div>
            </fieldset>
        </s:form>
	</div>
</div>


	<!-- JQuery et AngularJs -->
  	<script src="<s:url namespace="" 	action="jQuery" />"> 	</script>
	<script src="<s:url namespace="" 	action="angularjs" />">	</script>
	
	<!-- JavaScript -->
	<script src="<s:url namespace="/trait" 	action="jsTrait" />" > </script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>


