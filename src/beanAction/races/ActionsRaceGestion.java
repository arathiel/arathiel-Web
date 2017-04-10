package beanAction.races;

import java.util.ArrayList;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import clientServeur.exception.UserException;
import clientServeur.race_bonus_carac.interfaces.IFabriqueBonus;
import clientServeur.race_bonus_carac.userException.UserExceptionRBC;
import entity.competence.Competence;
import entity.race_bonus_carac.bonus.Bonus;
import entity.race_bonus_carac.caracteristique.Caracteristique;
import entity.race_bonus_carac.race.Race;
import entity.trait.Trait;


public class ActionsRaceGestion extends ApplicationSupport implements ServletRequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static IFacadeService fService;
	private static IFabriqueBonus fabBonus;
	

	private ArrayList<Caracteristique> listeCarac= new ArrayList<Caracteristique>();
	private ArrayList<Competence> listeComp= new ArrayList<Competence>();
	private ArrayList<Trait> listeTrait= new ArrayList<Trait>();
	private ArrayList<Bonus> listeBonus = new ArrayList<Bonus>();
	private Race race;
	private String nomRace;
	private String idRace;
	private String dispo;
	private String nomRech;
	private HttpServletRequest request;
	private String message;
	
	

	public void init() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			fService = (IFacadeService)  ctx.lookup("ejb:/arathiel-EJB/FacadeService!clientServeur.IFacadeService");
			fabBonus 	= (IFabriqueBonus) 	ctx.lookup("ejb:/arathiel-EJB/FabriqueBonus!clientServeur.race_bonus_carac.interfaces.IFabriqueBonus");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}


	@Override
	public void validate(){
		if((nomRace.trim().length())>40){
			setMessage("ATTENTION: Le nom ne doit pas comporter plus de 40 caractères.");
			addFieldError("nomRace", message);
		}
		
		if((nomRace.trim()).isEmpty()){
			setMessage("ATTENTION: Le champ Nom ne doit pas être vide. ");
			addFieldError("nomRace", message);
		}
	}
	
	
	/**
	 * Methode qui envoie la propriété race de ce bean pour insertion
	 * 
	 */
	public String creer() {
		init();
		construireRace();

		try {
			fService.enregistrerRace(race);
			setMessage("Cette race à été enregistrée avec succès !");
		} catch (UserExceptionRBC e) {
			setMessage(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	
	/**
	 * Methode qui envoie la propriété race de ce bean pour modification
	 * 
	 */
	public String modifier() {
		init();
		construireRace();
		
		try {
			fService.modifierRace(race);
			setMessage("Cette race à bien été modifiée !");
			
		} catch (UserExceptionRBC e) {
			setMessage(e.getMessage());
		}
		
		return SUCCESS;
	}
	
	/**
	 * Methode qui envoie la propriété race de ce bean pour suppression
	 * 
	 */
	public String supprimer() {
		init();
		construireRace();

		try {
			fService.supprimerRace(race);
			setMessage("Cette race à bien été supprimée !");
		} catch (UserExceptionRBC e) {
			setMessage(e.getMessage());
		}
		return SUCCESS;
	}
	
	
	/**
	 * Methode qui recupère les données du flux pour
	 * recréer une race et la set dans la propriété race de ce bean
	 * 
	 */
	public void construireRace(){

		Race race = new Race(this.nomRace, false);
		if ((this.dispo).equals("true")) {race.setDispo(true);}
		if (this.idRace!="0" && this.idRace!=null){race.setId(Integer.parseInt(idRace));}
			
				
		Map<String, String[]> map = request.getParameterMap();


		//le nombre de bonus de la map sera le nombre total -3 (id, nom et dispo) et /3 (un bonus contient 3 clefs/valeurs)
		for (int i=0; i<(map.size()-3)/3; i++){					

			int valeur = 0;
			boolean acad = false;
			Bonus bonus = null;
			String typeBonus = "";
			String idBonussable = "";
			
			for (String s : map.keySet()){						//On parcours la map par ses clefs
				
				if (s.startsWith("listeBonus["+i+"]")) {					//on teste si la clef concerne le bonus en cours
					
					String sub = (s.substring(14, 17));						//Teste les caractères de la clef qui correspondent à id, valeur ou académique
					
					if (sub.equals("idB")) {								//si la clef concerne le bonus en cours...
						String typeB = map.get(s)[0].substring(0, 3);		//on va chercher de quel type de bonus il s'agit et la valeur de l'id à rechercher
						idBonussable = map.get(s)[0].substring(3).trim();
								
						switch(typeB) {
						case "Com" : typeBonus = "Comp";
							break;
						case "Tra" : typeBonus = "Trait";
							break;
						case "Car" : typeBonus = "Carac";	
						}
					}
					
					if (sub.equals("aca")) {								//On teste si la valeur académique est vraie ou fausse et on renseigne le booleen
						if ((map.get(s)[0]).equals("true")){
							acad = true;
						}
					}
					
					if (sub.equals("val")) {								//On récupère la valeur du bonus
						valeur = Integer.parseInt(map.get(s)[0]);
					}
				}
			}
			
			
			//On récupère toutes les données pour recreer un bonus avec la factory
			if (typeBonus.equals("Comp")) {							//c'est un bonus de competence
				Competence comp = fService.rechCompParId(Integer.parseInt(idBonussable));
				bonus = fabBonus.creerBonus(comp, valeur, acad);
			}
			
			if (typeBonus.equals("Carac")) {						//c'est un bonus de caractéristique
				Caracteristique carac = fService.rechCaracParId(idBonussable);
				bonus = fabBonus.creerBonus(carac, valeur);
			}
			
			if (typeBonus.equals("Trait")) {						//c'est un bonus de trait
				Trait trait = null;
				try {
					trait = fService.consulterTraitById(Integer.parseInt(idBonussable));
					bonus= fabBonus.creerBonus(trait, valeur);
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (UserException e) {
					e.printStackTrace();
				}
			}

			//On ajoute le bonus à la liste des bonus de la race
			race.ajouterBonus(bonus);			
		}
	
		this.race = race;
	}
	

	public ArrayList<Caracteristique> getListeCarac() {
		return listeCarac;
	}


	public void setListeCarac(ArrayList<Caracteristique> listeCarac) {
		this.listeCarac = listeCarac;
	}


	public ArrayList<Competence> getListeComp() {
		return listeComp;
	}


	public void setListeComp(ArrayList<Competence> listeComp) {
		this.listeComp = listeComp;
	}


	public ArrayList<Trait> getListeTrait() {
		return listeTrait;
	}


	public void setListeTrait(ArrayList<Trait> listeTrait) {
		this.listeTrait = listeTrait;
	}


	public String getNomRace() {
		return nomRace;
	}


	public void setNomRace(String nomRace) {
		this.nomRace = nomRace;
	}


	public String getIdRace() {
		return idRace;
	}


	public void setIdRace(String idRace) {
		this.idRace = idRace;
	}



	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;		
	}


	public HttpServletRequest getRequest() {
		return request;
	}

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

	public String getNomRech() {
		return nomRech;
	}

	public void setNomRech(String nomRech) {
		this.nomRech = nomRech;
	}

	public ArrayList<Bonus> getListeBonus() {
		return listeBonus;
	}

	public void setListeBonus(ArrayList<Bonus> listeBonus) {
		this.listeBonus = listeBonus;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
}
