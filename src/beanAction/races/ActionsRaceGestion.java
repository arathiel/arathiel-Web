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
	
//	private ArrayList<Race> listeRace = new ArrayList<Race>();
	private ArrayList<Caracteristique> listeCarac= new ArrayList<Caracteristique>();
	private ArrayList<Competence> listeComp= new ArrayList<Competence>();
	private ArrayList<Trait> listeTrait= new ArrayList<Trait>();
	private ArrayList<Bonus> listeBonus = new ArrayList<Bonus>();
	private Race race;
//	private String selectCarac;
//	private String selectTrait;
//	private String selectComp;
//	private String chkAcad;
	private String nomRace;
	private String idRace;
	private String dispo;
	private String nomRech;
	private HttpServletRequest request;
	
	

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
	
//	/**
//	 * Methode qui envoie la propriété race de ce bean pour insertion
//	 * 
//	 */
//	public String rech() {
//		init();
//System.out.println("on est dans recherche avec " + nomRech);
//
//		try {
//			this.race = fService.RechRaceParNom(nomRech);
//			idRace = String.valueOf(race.getId());
//			nomRace = race.getNom();
//			listeBonus = (ArrayList<Bonus>) race.getListeBonus();
//			
//		} catch (UserExceptionRBC e) {
//			e.printStackTrace();
//			return ERROR;			
//		}
//		
//		return "editer";
//	}
	
	
	
	/**
	 * Methode qui envoie la propriété race de ce bean pour insertion
	 * 
	 */
	public String creer() {
		init();
		construireRace();
System.out.println("on revient dans creer avec " + race.toString());
		
		try {
			fService.enregistrerRace(race);
		} catch (UserExceptionRBC e) {
			e.printStackTrace();
			return ERROR;			
		}
		
		return "creer";
	}
	
	
	/**
	 * Methode qui envoie la propriété race de ce bean pour modification
	 * 
	 */
	public String modifier() {
		init();
		construireRace();
System.out.println("on revient dans modifier avec " + race.toString());
		
		try {
			fService.modifierRace(race);
			
		} catch (UserExceptionRBC e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "editer";
	}
	
	/**
	 * Methode qui envoie la propriété race de ce bean pour suppression
	 * 
	 */
	public String supprimer() {
		init();
		construireRace();
System.out.println("on revient dans supprimer avec " + race.toString());

		try {
			fService.supprimerRace(race);
		} catch (UserExceptionRBC e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "editer";
	}
	
	
	/**
	 * Methode qui recupère les données du flux pour
	 * recréer une race et la set dans la propriété race de ce bean
	 * 
	 */
	public void construireRace(){
System.out.println("incroyable on arrive dans construire race avec nom= "+this.nomRace+" id= "+this.idRace+" dispo = "+this.dispo);
		Race race = new Race(this.nomRace, false);
		if ((this.dispo).equals("true")) {race.setDispo(true);}
		if (this.idRace!="0" && this.idRace!=null){race.setId(Integer.parseInt(idRace));}
			
				
		Map<String, String[]> map = request.getParameterMap();
System.out.println("request :"+ map.size());

		//le nombre de bonus de la map sera le nombre total -3 (id, nom et dispo) et /3 (un bonus contient 3 clefs/valeurs)
		for (int i=0; i<(map.size()-3)/3; i++){					
System.out.println("bonus"+i);
			int valeur = 0;
			boolean acad = false;
			Bonus bonus = null;
			String typeBonus = "";
			String idBonussable = "";
			
			for (String s : map.keySet()){						//On parcours la map par ses clefs
				
				if (s.startsWith("listeBonus["+i+"]")) {					//on teste si la clef concerne le bonus en cours
//System.out.println("Key = "+ s + " Valeur = "+map.get(s)[0]);
					
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
System.out.println("académique = "+acad);
					}
					
					if (sub.equals("val")) {								//On récupère la valeur du bonus
						valeur = Integer.parseInt(map.get(s)[0]);
System.out.println("valeur du bonus = "+valeur);
					}
				}
			}
			
			
			//On récupère toutes les données pour recreer un bonus avec la factory
			if (typeBonus.equals("Comp")) {							//c'est un bonus de competence
				Competence comp = fService.rechCompParId(Integer.parseInt(idBonussable));
				bonus = fabBonus.creerBonus(comp, valeur, acad);
System.out.println("Compétence concernée = "+comp.getNom());
			}
			
			if (typeBonus.equals("Carac")) {						//c'est un bonus de caractéristique
				Caracteristique carac = fService.rechCaracParId(idBonussable);
				bonus = fabBonus.creerBonus(carac, valeur);
System.out.println("Carac concernée = "+carac.getNomCarac());
				
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
				
System.out.println("Trait concerné = "+trait.getLibelle());
			}
			
System.out.println("Bonus créé : "+bonus.toString());
			//On ajoute le bonus à la liste des bonus de la race
			race.ajouterBonus(bonus);			
		}
	
System.out.println("Race crée : "+race.toString());
		this.race = race;
	}
	
//	public ArrayList<Race> getListeRace() {
//		return listeRace;
//	}
//
//
//	public void setListeRace(ArrayList<Race> listeRace) {
//		this.listeRace = listeRace;
//	}
//
//
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
//
//
//	public String getSelectCarac() {
//		return selectCarac;
//	}
//
//
//	public void setSelectCarac(String selectCarac) {
//		this.selectCarac = selectCarac;
//	}
//
//
//	public String getSelectTrait() {
//		return selectTrait;
//	}
//
//
//	public void setSelectTrait(String selectTrait) {
//		this.selectTrait = selectTrait;
//	}
//
//
//	public String getSelectComp() {
//		return selectComp;
//	}
//
//
//	public void setSelectComp(String selectComp) {
//		this.selectComp = selectComp;
//	}
//
//
//	public String getChkAcad() {
//		return chkAcad;
//	}
//
//
//	public void setChkAcad(String chkAcad) {
//		this.chkAcad = chkAcad;
//	}


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



	

}
