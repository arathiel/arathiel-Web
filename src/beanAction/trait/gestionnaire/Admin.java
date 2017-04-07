package beanAction.trait.gestionnaire;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import clientServeur.exception.UserException;
import clientServeur.trait.EnrichisseurRP;
import entity.trait.Trait;
import entity.trait.comportement.Comportement;
import technic.trait.Comportements;
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
	private EnrichisseurRP	fabriqueTr;
	
	//Attributs utilis� par tous	
	private Trait			trait;
	private Comportements 	listComp;
	private int				id;
	private String			message;
	
	//Pour dynamicSelect
	private String				type;
	private Map<String, String> map;

	//R�cup�ration depuis frmAddTr
	private String				visi;
	private String				dispo;
	private String				malus;
	private ArrayList<String>	selectListComp;
	
	//Reconstruction de Trait
	private boolean	 	typeTr;
	private boolean	 	visiPublic;
	private boolean	 	dispoCrea;
	
	/**
	 * Initialisation des services
	 * 
	 * @return
	 */
	public void initConn() {
		try {
			initialContext 	= new InitialContext();
			service 		= (IFacadeService) initialContext.lookup(Parameter.SERVICE_ARATHIEL);
			fabriqueTr		= (EnrichisseurRP) initialContext.lookup(Parameter.ENRICHISSEUR_ARA);
			
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	/* ========================================== */ 
	/*  				TRAIT					  */
	/* ========================================== */
	
	/**
	 * M�thode pour l'affichage du formulaire d'ajout de trait
	 * @return
	 */
	public String frmAdd() {		
		return MethodReturn.FORMADD;
	}

	
	/**
	 * M�thode d'enregistrement du trait
	 * @return
	 */
	public String add() {
		// Initialisation des services
		this.initConn();
	
		//Instanciation des bool�ens / False par d�faut
		if (malus != null) {
			if (malus.equals("Malus")) typeTr = true;
		}
		else {
			typeTr = false;
		}
		
		if (visi != null) {
			if (visi.equals("Publique")) visiPublic = true;
		}
		else {
			visiPublic = false;
		}
		
		if (dispo != null) {
			if (dispo.equals("A la cr�ation")) dispoCrea = true;
		}
		else {
			dispoCrea = false;
		}
	
		// V�rification du libell� (seule chose obligatoire) J'ai r�alis� une fabrique, mais je ne m'en sers pas, car bcp de contr�le, et j'avais peur de ne pouvoir finir l'ECF...
		if(trait.getLibelle() != null) {
			if (!trait.getLibelle().isEmpty()) {
				
				Trait traitEnr = new Trait(trait.getLibelle(), visiPublic, dispoCrea, typeTr, getComp(selectListComp), trait.getDescription());
				
				try {
					service.ajouterTrait(traitEnr);
				} catch (UserException e) {
					System.out.println("Probl�me d'enregistrement : "+e.getMessage());
				}
			}
			else {
				//TODO a remonter
				System.out.println("Erreur libell� vide");
			}
		}
		else {
			//TODO a remonter
			System.out.println("Erreur libell� null");
		}
		
		return MethodReturn.ADD;	
	}
	
	/**
	 * Suppression d'un trait
	 * @return
	 */
	public String delete() {
		// Initialisation des services
		this.initConn();
		
		//Suppression du trait (si utilis� dans un bonus, l�ve une exception)
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
	 * M�thode permettant le remplissage dynamique du select des comportement selon le type choisi
	 * @return
	 */
	public String dynamicSelect() {
		// Initialisation des services
		this.initConn();
		
		//Initialisation de la variable
		map	= new LinkedHashMap<String, String>();		
		
		//V�rification de la valeur du type choisi et en l'insert dans un objet MAP (Format JSON pour le trait� c�t� client)
		if(type != null) {
			if (!type.isEmpty()) {
				
				switch (type) {
				  case "Caract�ristique":
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
	
	/**
	 * R�cup�re la liste des comportement dans la base depuis une liste de ID rensign� (pas bcp de contr�le)
	 * @param listId
	 * @return
	 */
	private Comportements getComp(ArrayList<String> listId) {
		//Initialisation de la connection
		this.initConn();

		//Instanciation d'une liste de comportement
		Comportements listCompOut = new Comportements();
				
		if(listId != null) {	
			for(String id : listId) {
				try {
					Comportement comp = service.consulterCompById(Integer.parseInt(id));
					listCompOut.add(comp);
				} catch (NumberFormatException | UserException e) {
					System.out.println("M�thode getComp : "+e.getMessage());
				}
			}
		}
		else {
			listCompOut = null;
		}
		return listCompOut;		
	}

	
	//Getters & Setters (J'ai pas mis la javaDoc car �a �voluait bcp. DSL)

	public Trait getTrait() {
		return trait;
	}


	public void setTrait(Trait trait) {
		this.trait = trait;
	}


	public Comportements getListComp() {
		return listComp;
	}


	public void setListComp(Comportements listComp) {
		this.listComp = listComp;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Map<String, String> getMap() {
		return map;
	}


	public void setMap(Map<String, String> map) {
		this.map = map;
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


	public ArrayList<String> getSelectListComp() {
		return selectListComp;
	}


	public void setSelectListComp(ArrayList<String> selectListComp) {
		this.selectListComp = selectListComp;
	}

}
