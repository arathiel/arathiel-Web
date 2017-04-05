package beanAction.trait.consultation;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import clientServeur.exception.UserException;
import entity.trait.Trait;
import entity.trait.comportement.Comportement;
import technic.trait.Comportements;
import technic.trait.Traits;
import util.trait.MethodReturn;
import util.trait.Parameter;

/**
 * Classe d'action pour la consultation de trait
 * 
 * @author Jonathan Fuentes
 *
 */
public class Consult extends ApplicationSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//Attributs service
	private InitialContext	initialContext;
	private IFacadeService	service;
	
	//Attributs fonctionnels
	private Traits 			listTrait;
	private Trait			trait;
	private Comportements 	listComp;
	private Comportement	comp;	
	private String			visi;
	private String			dispo;
	private String			malus;
	
	private String 			libSearch;
	private int				selectId;
		

	/**
	 * Initialisation des services
	 * 
	 * @return
	 */
	public void initConn() {
		try {
			initialContext 	= new InitialContext();
			service 		= (IFacadeService) initialContext.lookup(Parameter.SERVICE_ARATHIEL);
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	/* ========================================== */ 
	/*  				TRAIT					  */
	/* ========================================== */
	
	/**
	 * R�cup�re la liste de trait disponible de la BDD Pour la page frmListTrait
	 * @return
	 */
	public String list() {
		this.initConn();
		listTrait = null;

		//TODO AFFICHER LA LISTE COMPLETE ?
		
		return MethodReturn.LIST;
	}
	
	/**
	 * Permet la recherche dynamique des traits pour la page frmListTrait
	 * @return
	 */
	public String search() {
		// Initialisation de la connexion au service
		this.initConn();
		
		//Initialisation de la variable
		listTrait 	= null;
		
		//Initialisation des variables
		listTrait = service.consulterListTraitByLib(libSearch);
			
		return MethodReturn.SEARCH;	
	}
		
	/**
	 * Affiche la page frmDetailTrait
	 * @return
	 */
	public String detail() {
		// Initialisation de la connexion au service
		this.initConn();
		
		//Initialisation de la variable
		trait 		= null;
		visi		= null;
		dispo		= null;
		malus		= null;
		listComp	= new Comportements();
		
		// Recherche du trait via ID
		try {
			trait = service.consulterTraitById(selectId);
		} catch (UserException e) {
			//TODO Message d'erreur
			System.out.println("Erreur");
		}
		
		// V�rification de l'existence du trait
		if (trait != null) {
			
			// S'il existe on traite certaines de ses informations pour les afficher dans frmDetailTrait
			
			//Les bool�ens
			if (trait.isVisiPublic())	visi = "Publique";
			else {
				visi = "Ma�tre du jeu";
			}
			
			if (trait.isDispoCrea())	dispo = "Cr�ation";
			else {
				dispo = "Toujours";
			}
			
			if (trait.isMalus())		malus = "Malus";
			else {
				malus = "Bonus";
			}
			
			//La liste de comportement
			if (trait.getListComp() != null){
				if (!trait.getListComp().isEmpty()) listComp = trait.getListComp();
			}
		}
		
		return MethodReturn.DETAIL;
	}
	
	/* ========================================== */ 
	/*  			COMPORTEMENT				  */
	/* ========================================== */

	
	public String getListComp() {
		// Initialisation des services
		this.initConn();
		
		//R�cup�ration des listes
		
		
		return MethodReturn.LIST;
	}

	//Getters & Setters

	/**
	 * Retourne la liste de Trait
	 * @return
	 */
	public Traits getListTrait() {
		return listTrait;
	}

	/**
	 * Modifie la liste de Trait
	 * @param listTrait
	 */
	public void setListTrait(Traits listTrait) {
		this.listTrait = listTrait;
	}

	/**
	 * Retourne un trait
	 * @return
	 */
	public Trait getTrait() {
		return trait;
	}


	/**
	 * Modifie le trait
	 * @param trait
	 */
	public void setTrait(Trait trait) {
		this.trait = trait;
	}

	/**
	 * Retourne le libell� saisie dasn frmlist.jsp
	 * @return
	 */
	public String getLibSearch() {
		return libSearch;
	}

	/**
	 * Modifie le libell� de recherche
	 * @param libelle
	 */
	public void setLibSearch(String libSearch) {
		this.libSearch = libSearch;
	}

	/**
	 * Retourne l'Id s�lectionn�
	 * @return
	 */
	public int getSelectId() {
		return selectId;
	}

	/**
	 * Modifie l'id s�lectionn�
	 * @param selectId
	 */
	public void setSelectId(int selectId) {
		this.selectId = selectId;
	}

	public String getVisi() {
		return visi;
	}


	public void setVisi(String visi) {
		this.visi = visi;
	}


	public String getDispo() {
		return dispo;
	}


	public void setDispo(String dispo) {
		this.dispo = dispo;
	}


	public String getMalus() {
		return malus;
	}


	public void setMalus(String malus) {
		this.malus = malus;
	}
	
}
