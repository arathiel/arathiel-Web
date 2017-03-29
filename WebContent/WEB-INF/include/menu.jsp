<!-- Menu MJ -->

<%@ taglib prefix="s" uri="/struts-tags" %>

<link rel="stylesheet" href="<s:url namespace="" action="cssMenu" />" />

<nav id="menu_accordeon"> 
	<ul>
		<li><s:a namespace="" action="index" >Accueil</s:a></li>
		<li><a href="#">Comp�tence</a>
			<ul>
    			<li><a href="#">Choix1</a></li>
         		<li><a href="#">Choix2</a></li>
         		<li><a href="#">Choix3</a></li>
      		</ul>
   		</li>
   		<li><a href="#">Race</a>
      		<ul>
         		<li><s:a namespace="/race" action="pagecreer" >Creer			</s:a></li>
         		<li><s:a namespace="/race" action="pageediter">Editer			</s:a></li>
         		<li><s:a namespace="/race" action="pagelister">Liste des Races	</s:a></li>
      		</ul>
   		</li>
   		<li><a href="#">Culture</a>
      		<ul>
         		<li><a href="#">Choix1</a></li>
         		<li><a href="#">Choix2</a></li>
         		<li><a href="#">Choix3</a></li>
      		</ul>
   		</li>
   		<li><a href="#">Environnement</a>
      		<ul>
         		<li><a href="#">Choix1</a></li>
         		<li><a href="#">Choix2</a></li>
         		<li><a href="#">Choix3</a></li>
      		</ul>	
   		</li>
   		<li><a href="#">Carri�re</a>
      		<ul>
         		<li><a href="#">Choix1</a></li>
         		<li><a href="#">Choix2</a></li>
         		<li><a href="#">Choix3</a></li>
      		</ul>
   		</li>
   		<li><a href="#">Passion</a>
      		<ul>
         		<li><a href="#">Choix1</a></li>
         		<li><a href="#">Choix2</a></li>
         		<li><a href="#">Choix3</a></li>
      		</ul>
   		</li>
   		<li><a href="#">Trait</a>
      		<ul>
         		<li><s:a namespace="/trait" action="frmAdd" >Ajouter	</s:a></li>
         		<li><s:a namespace="/trait" action="frmList">Consulter	</s:a></li>
				<li><a href="#">Comportement</a>
					<ul>
						<li><a href="#">Ajouter</a></li>
         				<li><a href="#">Consulter</a></li>
         			</ul>
         		</li>
      		</ul>
   		</li>
   		<li><a href="#">Equipement</a>
      		<ul>
         		<li><a href="<%=request.getContextPath()%>/armurerie">Armurerie</a></li>
         		<li><a href="#">Choix2</a></li>
         		<li><a href="#">Choix3</a></li>
      		</ul>
   		</li>
   		<li><a href="#">Niveau social</a>
      		<ul>
         		<li><a href="#">Choix1</a></li>
         		<li><a href="#">Choix2</a></li>
         		<li><a href="#">Choix3</a></li>
      		</ul>
   		</li>
	</ul>
</nav>