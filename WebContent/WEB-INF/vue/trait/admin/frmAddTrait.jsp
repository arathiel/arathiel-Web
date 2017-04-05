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
		
		
		
		<h2>Création de trait</h2>
		<br />
	
		<s:form action	="">
			
			<s:label 	 for="libelle" value="Nom : " />
			<s:textfield id="libelle"  name = "trait.nom"/>
			
			<s:select
				id			="type"
            	label		="Type"
            	name		="selectType"
            	list		="{'Caractéristique', 'Roleplay'}"	
            	headerKey	="None"
            	emptyOption	="true"
            	headerValue	="Choisissez type"/>
            	
            <s:select
            	id			="modif"
            	label		="Modificateur"
            	name		="selectMod"
            	list		="{'...'}"	
            	headerKey	="None"
            	emptyOption	="true"
            	headerValue	="Choisissez type"
            	disabled="true"/>
            	
			<s:textarea 
				label		="titre" 
				name		="descr"/>
        	 
         	<s:radio
            	label="Effet"
            	name="selectMalus"
            	labelposition="inline"
            	list="{'Bonus', 'Malus'}"/>
            	
            <s:radio
            	label="Disponibilité"
            	name="selectDispo"
            	labelposition="inline"
            	list="{'Création', 'Toujours'}"/>
            	
            <s:radio
            	label="Visibilité"
            	name="selectVisi"
            	labelposition="inline"
            	list="{'MJ', 'Public'}"/>

       		<s:submit value="Enregistrer"/>
		
		</s:form>
		
<div class="container">
	<div class="row">
		<s:form class="form-horizontal" theme="simple">
            <fieldset>
                      
                <!-- Création de nouveau trait -->
                <legend>Création de nouveau trait</legend>
                
                <!-- Nom du trait -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label" for="nom">Nom</s:label>
                    <div class="col-md-6">
                        <s:textfield
                        	id			="nom" 
                        	name		="trait.libelle"
                         	type		="text"
                        	class		="form-control input-md"/>
                    </div>
                </div>
   
                <!-- Selection du type -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label">Type de comportement</s:label>
                    <div class="col-md-4">
                        <s:select
                        	class		="form-control"
            				name		="selectType"
            				list		="{'Caractéristique', 'Roleplay'}"	
            				headerValue	="Choisissez type"/>
                    </div>
                </div>
                
                <!-- Selection du Modificateur -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label">Modificateur du comportement</s:label>
                    <div class="col-md-4">
                        <s:select
                         	class		="form-control"
            				name		="selectType"
            				list		="{}"	
            				headerValue	="Choisissez type"
            				disabled="true"/>
                    </div>
                </div>
                
                <!-- Description du trait -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label" for="thresholdvalue"></s:label>
                    <div class="col-md-4">
                        <s:textarea
                         	name="trait.description.contenu"
                        	type="text" 
                        	class="form-control input-md"/>
                    </div>
                </div>
                
                <!-- Choix Bonus/Malus -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label" for="reqType">Malus</s:label>
                    <div class="col-md-4">
                        <s:radio
             				name="malus"
            				labelposition="inline"
            				list="{'Bonus', 'Malus'}" 
            				class="radio-inline"/>                       
                    </div>
                </div>
                
                <!-- Choix de la visibilité -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label" for="dataFormat">Visibilité</s:label>
                    <div class="col-md-4">
                    <s:radio
            			label="Visibilité"
            			name="visi"
            			labelposition="inline"
            			list="{'MJ', 'Public'}"
            			class="radio-inline"/>
                    </div>
                </div>
                
                <!-- Choix de la disponibilité -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label" for="dataFormat">Data Format</s:label>
                    <div class="col-md-4">
                        <s:radio
            				label="Disponibilité"
            				name="selectDispo"
            				labelposition="inline"
            				list="{'Création', 'Toujours'}"
            				class="radio-inline"/>	
                    </div>
                </div>
 
                <!-- Bouton d'action -->
                <div class="form-group">
                    <s:label class="col-md-4 control-label" for="submitButton"></s:label>
                    <div class="col-md-8">
                        <button name="btnEnr" 	 class="btn btn-success">Enregistrer</button>                       
                        <button name="btnCancel" class="btn btn-inverse">Annuler	</button>
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
	<script src="<s:url namespace="/trait" 	action="jsConsult" />" > </script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>

</html>


