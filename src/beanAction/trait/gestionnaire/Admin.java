package beanAction.trait.gestionnaire;

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
 * Classe d'action pour l'administration de trait
 * @author Jonathan Fuentes
 *
 */
public class Admin extends ApplicationSupport{

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
	private int				id;
	private String			visi;
	private String			dispo;
	private String			malus;
	
	
	
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
	
	public String frmAdd() {
		// Initialisation des services
		this.initConn();
		
		System.out.println("Dans la méthode");
		
		return MethodReturn.FORMADD;
	}
	
	
	/**
	 * Suppression d'un trait
	 * @return
	 */
	public String delete() {
		// Initialisation des services
		this.initConn();
		
		//Suppression du trait
		try {
			service.supprimerTrait(getId());
		} catch (UserException e) {
			//TODO Gérer les soucis
			System.out.println(e.getMessage());
		}

		return MethodReturn.DELETE;		
	}
	
		
	/* ========================================== */ 
	/*  			COMPORTEMENT				  */
	/* ========================================== */

	//Getters & Setters
	
	/**
	 * Retourne l'ID
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Modifie l'ID
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	
}
