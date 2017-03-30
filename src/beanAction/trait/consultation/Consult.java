package beanAction.trait.consultation;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import technic.trait.Traits;
import util.trait.MethodeReturn;

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

	
	//Attributs
	private IFacadeService	service;
	private Traits 			listTrait;
	private String 			saisieNom;
	
	
	/**
	 * Récupère la liste de trait disponible de la BDD
	 * @return
	 */
	public String list() {

		
	System.out.println("Dans la méthode list");
	
	System.out.println("saisieNom = " + saisieNom);

		
		return MethodeReturn.LIST;	
	}


	//Getters & Setters
	public IFacadeService getService() {
		return service;
	}


	public void setService(IFacadeService service) {
		this.service = service;
	}


	public Traits getListTrait() {
		return listTrait;
	}


	public void setListTrait(Traits listTrait) {
		this.listTrait = listTrait;
	}


	public String getSaisieNom() {
		return saisieNom;
	}


	public void setSaisieNom(String saisieNom) {
		this.saisieNom = saisieNom;
	}
	
	
}
