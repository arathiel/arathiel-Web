package beanAction.trait.consultation;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import technic.trait.Traits;
import util.trait.MethodReturn;
import util.trait.Parameter;

/**
 * Classe d'actino pour la consultation de trait
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
	
	//Attribut de manipulation d'information
	private Traits 	listTrait;
	private String 	libelle;
	



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
	
	
	/**
	 * Récupère la liste de trait disponible de la BDD Pour la page frmListTrait
	 * @return
	 */
	public String list() {
		System.out.println("Affichage de la page de recherche");
		
		return MethodReturn.LIST;
	}
	
	/**
	 * Permet la recherche dynamique des traits pour la page frmListTrait
	 * @return
	 */
	public String search() {
		// Initialisation de la connexion au service
		this.initConn();
		listTrait 	= null;
		
		System.out.println("le libSaisie est : "+libelle);
		
		//Initialisation des variables
		listTrait = service.consulterListTraitByLib(libelle);
		
		System.out.println("La listTrait est : "+ listTrait);
		
		return MethodReturn.SEARCH;	
	}
	
	
	
	/**
	 * Affiche la page frmDetailTrait
	 * @return
	 */
	public String detail() {
		return MethodReturn.DETAIL;
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


	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	
	
}
