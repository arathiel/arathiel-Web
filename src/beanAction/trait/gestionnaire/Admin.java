package beanAction.trait.gestionnaire;

import java.util.ArrayList;
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
			
		} 
		catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M�thode de v�rification des champs deu des formulaires
	 */
	@Override
	public void validate() {
		if (trait.getLibelle().isEmpty()) 			addFieldError("trait.libelle", getText("libelle.vide"));
		if (trait.getLibelle().length() >24)		addFieldError("trait.libelle", getText("libelle.long"));
		if (trait.getContenuDesc().length() >249)	addFieldError("trait.libelle", getText("libelle.long"));
		
		}
	
	/**
	 * Vide les objets pour l'ajout
	 */
	public void vider() {
		trait 	 = null;
		malus	 = null;
		visi	 = null;
		dispo	 = null;
		listComp = null;
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
		
		// Initialisation du message
		message = null;
	
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

		Trait traitEnr = new Trait(trait.getLibelle(), visiPublic, dispoCrea, typeTr, getComp(selectListComp), trait.getDescription());
				
			try {
				service.ajouterTrait(traitEnr);
				message = getText("addTrait.success");
			} catch (UserException e) {
				message = e.getMessage();
	 		}
			
		// On remet � z�ro pour vider les champs
		this.vider();
		
		return MethodReturn.ADD;	
	}
	
	
	/**
	 * M�thode pour l'affichage du formulaire d'ajout de trait
	 * @return
	 */
	public String frmUpdate() {
		// Initialisation de la connexion au service
		this.initConn();
		
		System.out.println("Dans m�thode frmUpdate");

		//Initialisation des variables
		visi		= null;
		dispo		= null;
		malus		= null;
		listComp	= new Comportements();
		message		= null;

		// Recherche du trait via libell�		
		try {
			trait = service.consulterTraitByLib(trait.getLibelle());
			// S'il existe on traite certaines de ses informations pour les afficher dans frmUpDateTrait

			//Les bool�ens
			if (trait.isVisiPublic())	visi = "Publique";
			else {
				visi = "Ma�tre du jeu";
			}

			if (trait.isDispoCrea())	dispo = "A la cr�ation";
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
						
		} catch (UserException e) {
			message = e.getMessage();
		}
	
		return MethodReturn.FORMUPD;
	}
	
	/**
	 * Modifie le trait
	 * @return
	 */
	public String update() {
		// Initialisation de la connexion au service
		this.initConn();
	
		// Initialisation du message
		message = null;

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
		
		//R�cup�ration du trait par son ID
		Trait traitEnr;
		try {
			traitEnr = service.consulterTraitById(id);
			
			//Mis � jour des �l�ments
			traitEnr.setLibelle(trait.getLibelle());
			traitEnr.setDescription(trait.getDescription());
			traitEnr.setDispoCrea(dispoCrea);
			traitEnr.setMalus(typeTr);
			traitEnr.setVisiPublic(visiPublic);
			traitEnr.setListComp(getComp(selectListComp));
			
			service.modiferTrait(traitEnr);
			
			message = getText("updateTrait.sucess");
		} catch (UserException e) {
			message = e.getMessage();
		}

		return MethodReturn.UPDATE;
	}
	
	
	/**
	 * Suppression d'un trait
	 * @return
	 */
	public String delete() {
		// Initialisation des services
		this.initConn();
		
		// Initialisation du message
		message = null;
		
		//Suppression du trait (si utilis� dans un bonus, l�ve une exception)
		try {
			service.supprimerTrait(getId());
			message = getText("delTrait.success");
		} catch (UserException e) {
			message = e.getMessage();
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
