package beanAction.trait.consultation;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import clientServeur.exception.UserException;
import clientServeur.trait.EnrichisseurRP;
import entity.trait.Trait;
import entity.trait.comportement.Comportement;
import technic.trait.Comportements;
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
	private EnrichisseurRP	fabriqueTrait;
	
	//Attribut de manipulation d'information
	private Trait	trait;
	private Traits 	listTrait;
	private String 	saisieNom;
	



	/**
	 * Initialisation des services
	 * 
	 * @return
	 */
	public void initConn() {
		try {
			initialContext 	= new InitialContext();
			service 		= (IFacadeService) initialContext.lookup(Parameter.SERVICE_ARATHIEL);
			fabriqueTrait 	= (EnrichisseurRP) initialContext.lookup(Parameter.ENRICHISSEUR_ARA);
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
		// Initialisation de la connexion au service
		this.initConn();
		
		//Initialisation de la liste de trait
		listTrait 	= null;

		//Instanciation de la liste depuis une requète BDD
		listTrait = service.consulterListTrait();
		
		return MethodReturn.LIST;
	}
	
	/**
	 * Permet la recherche dynamique des traits pour la page frmListTrait
	 * @return
	 */
	public String search() {
		// Initialisation de la connexion au service
		this.initConn();
		listTrait = null;
		
		//Initialisatino des variables
		listTrait = service.consulterListTraitByLib(saisieNom);
		
//		listTrait = service.consulterListTraitByLib(saisieNom);
		
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

	/**
	 * Retourne les caractères saisies dans la frmListTrait
	 * @return
	 */
	public String getSaisieNom() {
		return saisieNom;
	}

	/**
	 * Modifie saisieNom
	 * @param saisieNom
	 */
	public void setSaisieNom(String saisieNom) {
		this.saisieNom = saisieNom;
	}
	
	
	
	
	




	public Trait getTrait() {
		return trait;
	}


	public void setTrait(Trait trait) {
		this.trait = trait;
	}
	
}
