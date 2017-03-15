<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Création Arme</title>
</head>
<body>
	<h3>Création Arme</h3>
	<br/>
	<br/>
	
	<form name="creationArme" method="post" action="<%= request.getContextPath() %>/royaume/armurerie/creation?choix=arme">
		<label class="lblNomArme">Nom de l'arme :
			<input type="text" class="txtNomArme" name="nomArme"/>
		</label>
		<br/>
		<br/>
							
		<label class="lblRace">Race : 
			<input type="checkbox" name="race" value="1"/>Orc
			<input type="checkbox" name="race" value="2"/>Humain
			<input type="checkbox" name="race" value="3"/>Elfe	
		</label>
		<br/>
		<br/>
							
		<label class="lblEncomb">Nbre Encombrement : 
			<select name="encomb" class="encomb">
				<option></option>
				<option>1</option>
				<option>2</option>
				<option>3</option>
				<option>4</option>
			</select>
			</label>
			<br/>
			<br/>
							
			<span class="spanLblPrix">
				<label class="lblPrix">Prix : 
					<input type="text" class="prix" name="prix"/>
				</label>
			</span>
			<span class="comboMonnaie">
				<select name="monnaie" class="monnaie">
					<option>Cuivre</option>
					<option>Argent</option>
					<option>Or</option>
				</select>
			</span>
			<span class="spanDrucks">
				<label class="drucks">Drucks</label>
			</span>
			<br/>
			<br/>
			
			<div class="boutonCreationArme">
				<input type="button" class="verif" value="Vérifier"/>
				<input type="submit" class="submit" value="Valider"/>
				<input type="reset" class="reset" value="Quitter"/>
			</div>
		</form>				
</body>
</html>