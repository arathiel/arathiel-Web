package beanAction.races;

import java.util.ArrayList;
import java.util.Map;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import clientServeur.race_bonus_carac.interfaces.IFabriqueBonus;
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
	
	private ArrayList<Race> listeRace = new ArrayList<Race>();
	private ArrayList<Caracteristique> listeCarac= new ArrayList<Caracteristique>();
	private ArrayList<Competence> listeComp= new ArrayList<Competence>();
	private ArrayList<Trait> listeTrait= new ArrayList<Trait>();
	private String selectCarac;
	private String selectTrait;
	private String selectComp;
	private String chkAcad;
	private String nomRace;
	private String idRace;
	private String raceAjax;


	private HttpServletRequest request;
	
	

	public void init() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			fService = (IFacadeService)  ctx.lookup("ejb:/arathiel-EJB/FacadeService!clientServeur.IFacadeService");
			fabBonus 	= (IFabriqueBonus) 	ctx.lookup("ejb:/ArathielFakeEJB/FabriqueBonus!clientServeur.race_bonus_carac.interfaces.IFabriqueBonus");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Methode qui recupère les données de la page creerRace.jsp,
	 * recrée une race et l'envoie pour insertion
	 * 
	 */
	public String creer() {
		init();
		System.out.println("incroyable on arrive dans creer race avec"+this.nomRace+this.idRace);
		Race race = new Race();
		
		
		Map<String, String[]> map = request.getParameterMap();
		System.out.println("request :"+ map.size());

		for (int i=0; i<(map.size()-2)/3; i++){					//le nombre de bonus de la map sera le nombre total -2 (nom et id) et /3 (un bonus contient 3 clefs/valeurs)
			System.out.println("bonus"+i);
			
			for (String s : map.keySet()){						//On parcours la map par ses clefs
				int valeur = 0;
				boolean acad = false;
				Bonus bonus = null;
				
				if (s.startsWith("listeBonus["+i+"]")) {					//on teste ce que représente la clef en cours
					//System.out.println("Key = "+ s + " Valeur = "+map.get(s)[0]);
					
					String sub = (s.substring(14, 17));
					
					if (sub.equals("idB")) {								//si la clef concerne le bonus en cours...
						String typeBonus = map.get(s)[0].substring(0, 3);	//on va chercher de quel type de bonus il s'agit et la valeur de l'id à rechercher
						String idBonussable = map.get(s)[0].substring(3).trim();
								
						if (typeBonus.equals("Com")) {						//c'est un bonus de competence
							System.out.println("bonus comp d'Id="+idBonussable);
						}
						
						if (typeBonus.equals("Car")) {						//c'est un bonus de caractéristique
							System.out.println("bonus carac d'Id="+idBonussable);
						}
						
						if (typeBonus.equals("Tra")) {						//c'est un bonus de trait
							System.out.println("bonus trait d'Id="+idBonussable);
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
		}
//		
//		Race race = new Race(this.nomRace, false);
//		
//		try {
//			fService.enregistrerRace(race);
//		} catch (UserExceptionRBC e) {
//			System.out.println("***********************BUG REC RACE **************************");
//			e.printStackTrace();
//		}
		
		//Gson gson = new Gson();
		

		//RaceAjax bonusAjax = gson.fromJson(getRaceAjax(), RaceAjax.class);

		//System.out.println(bonusAjax);	
		
		return SUCCESS;
	}
	
	
	
	public String modifier() {
		init();
	//TODO
		return SUCCESS;
	}
	
	public String supprimer() {
		init();
	//TODO
		return SUCCESS;
	}
	
	public ArrayList<Race> getListeRace() {
		return listeRace;
	}


	public void setListeRace(ArrayList<Race> listeRace) {
		this.listeRace = listeRace;
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


	public String getSelectCarac() {
		return selectCarac;
	}


	public void setSelectCarac(String selectCarac) {
		this.selectCarac = selectCarac;
	}


	public String getSelectTrait() {
		return selectTrait;
	}


	public void setSelectTrait(String selectTrait) {
		this.selectTrait = selectTrait;
	}


	public String getSelectComp() {
		return selectComp;
	}


	public void setSelectComp(String selectComp) {
		this.selectComp = selectComp;
	}


	public String getChkAcad() {
		return chkAcad;
	}


	public void setChkAcad(String chkAcad) {
		this.chkAcad = chkAcad;
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




	public String getRaceAjax() {
		return raceAjax;
	}


	public void setRaceAjax(String raceAjax) {
		this.raceAjax = raceAjax;
	}


	@Override
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;		
	}


	public HttpServletRequest getRequest() {
		return request;
	}



	

}
