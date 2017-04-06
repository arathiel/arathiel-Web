package beanAction.trait.gestionnaire;

import java.util.LinkedHashMap;
import java.util.Map;

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
	private Map<String, String> map;
	private Traits 				listTrait;
	private Trait				trait;
	private Comportements 		listComp;
	private Comportement		comp;
	private int					id;
	private String				visi;
	private String				dispo;
	private String				malus;
	
	private String				type;
	
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
	 * Méthode pour l'affichage du formulaire d'ajout de trait
	 * @return
	 */
	public String frmAdd() {		
		return MethodReturn.FORMADD;
	}
	
	/**
	 * Suppression d'un trait
	 * @return
	 */
	public String delete() {
		// Initialisation des services
		this.initConn();
		
		//Suppression du trait (si utilisé dans un bonus, lève une exception)
		try {
			service.supprimerTrait(getId());
		} catch (UserException e) {
			System.out.println(e.getMessage());
		}

		return MethodReturn.DELETE;		
	}
	
		
	/* ========================================== */ 
	/*  			COMPORTEMENT				  */
	/* ========================================== */

	/**
	 * Méthode permettant le remplissage dynamique du select des comportement selon le type choisi
	 * @return
	 */
	public String dynamicSelect() {
		System.out.println("Dans méthode dynamicSelect");
		// Initialisation des services
		this.initConn();
		
		//Initialisation de la variable
		map		 = new LinkedHashMap<String, String>();		
		
		//Vérification de la valeur du type choisi et en l'insert dans un objet MAP (Format JSON pour le traité côté client)
		if(type != null) {
			if (!type.isEmpty()) {
				
				switch (type) {
				  case "Caractéristique":
				    listComp = service.consulterListCompCar();
				    if(listComp != null) {
				    	if (!listComp.isEmpty()) {
				    		for (Comportement comp : listComp) {
				    			map.put(""+comp.getId(), comp.getLibelle());
				    		}
				    	}
				    }
				    else {
				    	map.put("1", "Aucun comportement");
					}
				    break;
				  
				  case "Roleplay":
					  listComp = service.consulterListCompRP();
					    if(listComp != null) {
					    	if (!listComp.isEmpty()) {
					    		for (Comportement comp : listComp) {
					    			map.put(""+comp.getId(), comp.getLibelle());
					    		}
					    	}
					    }
					    else {
					    	map.put("1", "Aucun comportement");
						}
				    break;
				  
				  case "Tous":
					  listComp = service.consulterListComp();
					    if(listComp != null) {
					    	if (!listComp.isEmpty()) {
					    		for (Comportement comp : listComp) {
					    			map.put(""+comp.getId(), comp.getLibelle());
					    		}
					    	}
					    }
					    else {
					    	map.put("1", "Aucun comportement");
						}
				    break;
				}	
			}
		}		
		
		return MethodReturn.LIST;
	}
	
	
	
	//Getters & Setters (J'ai pas mis toute la javaDoc DSL)
	
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

	/**
	 * Retourne le type du select
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 * Modifie le type du select
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}


	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
	}


	public Comportements getListComp() {
		return listComp;
	}


	public void setListComp(Comportements listComp) {
		this.listComp = listComp;
	}
	
}
