package webApp.armurerie.arme;

import java.util.ArrayList;
import java.util.List;

import appli.armurerie.ManageArme;
import beanAction.ApplicationSupport;
import entity.armurerie.Arme;
import entity.armurerie.ArmeJoueur;
import entity.armurerie.Joueur;
import entity.race_bonus_carac.race.Race;
import exception.armurerie.ServiceOlivBException;
import util.armurerie.ExceptionMessageErreurOlivB;

/**
 * Classe d'action du CU Armurerie
 * utilisation de 2Wild Cards dans le fichier armurerie.xml avec unilisation d'une seule classe d'action
 * @author OlivB
 *
 */
public class ActionArme extends ApplicationSupport{


	private static final long serialVersionUID = 1L;

	private Arme			armeDto;
	private Joueur 			joueurDto;
	private ArmeJoueur 		armeJoueurDto;
	private ManageArme 		manArme;
	private List<Race> 		races;	
	private List<String>	nomRaces;
	private List<String>	raceArme;	
	private List<Arme>		armes;
	private List<Joueur> 	joueurs;
	private String[] 		tabRaces;
	private int 			joueurId;
	private int 			armeId;
	private String 			etat;
	private String			messageErreur;


	//===============METHODE VALIDATE=============================================	
	@Override
	public void validate() {
		System.out.println("m�thode validate() en cours");
		try {
			afficheRace();
		
		
		if (armeDto.getNom().isEmpty()){
			addFieldError("armeDto.nom", getText("nom.obligatoire"));
		}
		if (tabRaces.length == 0) {
			addFieldError("tabRaces", getText("race.obligatoire"));
		}
		if (armeDto.getEncombrement() < 1) {
			addFieldError("armeDto.encombrement", getText("encom.obligatoire"));
		}
		if (armeDto.getPrix() < 1) {
			addFieldError("armeDto.prix", getText("prix.obligatoire"));
		}
		if (hasFieldErrors()) {
			addActionError( "Des champs de saisie sont vides");
			addActionMessage("Merci de renseigner tous les champs");
		}
		} catch (ServiceOlivBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//===============METHODES POUR L'AFFICHAGE DES PAGES DE CREATION, MODIFICATION ET SUPPRESSION==================
	public String creationAffiche() 	throws ServiceOlivBException {
		afficheRace();
		return "afficheOK";
	}
	public String modificationAffiche() throws ServiceOlivBException {
		afficheListeArme();
		afficheRace();
		return "afficheOK";
	}
	public String suppressionAffiche() 	throws ServiceOlivBException {
		afficheListeArme();
		afficheRace();
		return "afficheOK";
	}
	
	public String joueurAffiche() 		throws ServiceOlivBException {
		afficheListeArme();
		afficheListeJoueur();
		return "afficheOK";
	}

	public String rechercheAffiche()	throws ServiceOlivBException {
		manArme = new ManageArme();
		armes = new ArrayList<Arme>();
		armes = manArme.afficheArmesRace();
		return "afficheOK";
	}

	//=================METHODES POUR LA VALIDATION DES FORMULAIRES==================================================
	public String creationValide() 		throws ServiceOlivBException {
		System.out.println("m�thode creationValide() OK");
		if (validationArme(armeDto)) {
			getTabRacesSelectedValues();
			manArme = new ManageArme();
			try {
				manArme.createArme(armeDto, raceArme);
			}
			catch (Exception e) {
				throw new ServiceOlivBException(ExceptionMessageErreurOlivB.DOUBLON_ARME);
			}
		}
		return SUCCESS;
	}
	public String modificationValide() 	throws ServiceOlivBException {
		if (validationArme(armeDto)) {
			getTabRacesSelectedValues();
			manArme = new ManageArme();
			try {
				manArme.modif(armeDto, raceArme);
			}
			catch (Exception e) {
				throw new ServiceOlivBException(ExceptionMessageErreurOlivB.ARME_INEXISTANTE);
			}
		}
		return SUCCESS;
	}
	public String suppressionValide() 	throws ServiceOlivBException {
		if (validationArme(armeDto)) {
			getTabRacesSelectedValues();
			manArme = new ManageArme();
			try {
				manArme.suppr(armeDto);
			}
			catch (Exception e) {
				throw new ServiceOlivBException(ExceptionMessageErreurOlivB.ARME_INEXISTANTE);
			}
		}
		return SUCCESS;
	}
	
	public String joueurValide() throws ServiceOlivBException {
		manArme = new ManageArme();
		manArme.ajouteArmeJoueur(armeJoueurDto, joueurId, armeId, etat);
		return SUCCESS;
		
	}
	public String rechercheValide() {
		//TODO
		return SUCCESS;
	}

	//=====================GETTERS ET SETTERS==================================================================

	public Arme getArmeDto() {
		return armeDto;
	}
	public void setArmeDto(Arme armeDto) {
		this.armeDto = armeDto;
	}
	public List<Race> getRaces() {
		return races;
	}
	public void setRaces(List<Race> races) {
		this.races = races;
	}
	public String[] getTabRaces() {
		return tabRaces;
	}
	public void setTabRaces(String[] tabRaces) {
		this.tabRaces = tabRaces;
	}
	public List<Arme> getArmes() {
		return armes;
	}
	public void setArmes(List<Arme> armes) {
		this.armes = armes;
	}


	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	//M�thode de recherche liste des Armes pour affichage dans les jsp modificationArme et suppressionArme
	private List<Arme> afficheListeArme() 	throws ServiceOlivBException {
		manArme = new ManageArme();
		armes = new ArrayList<Arme>();
		armes = manArme.afficheArmes();
		return armes;		
	}

	//M�thode de recherche liste de races pour la CheckBoxList
	private List<Race> afficheRace() 		throws ServiceOlivBException {
		manArme = new ManageArme();
		races = new ArrayList<Race>();
		races = manArme.afficheRaces();
		return races;

	}
	
	private List<Joueur> afficheListeJoueur() throws ServiceOlivBException {
		manArme = new ManageArme();
		joueurs = new ArrayList<Joueur>();
		joueurs = manArme.afficheJoueurs();
		return joueurs;
	}


	// m�thode de r�cup�ration des valeurs des checkBox de Race
	public List<String> getTabRacesSelectedValues() throws ServiceOlivBException {
		try {
			return getValue(tabRaces);
		}
		catch (Exception e) {
			throw new ServiceOlivBException(ExceptionMessageErreurOlivB.RACE_INEXISTANTE);
		}
	}

	//m�thode de conversion d'un tableau List
	public List<String> getValue(String[] tabRaces) throws ServiceOlivBException {
		if (tabRaces.length == 0) throw new ServiceOlivBException(ExceptionMessageErreurOlivB.NO_RACE);
		raceArme = new ArrayList<String>();
		try {
			for (String value : tabRaces) {
				System.out.println(value);
				raceArme.add(value);
			}
		}

		catch (Exception e) {
			throw new ServiceOlivBException(ExceptionMessageErreurOlivB.RACE_INEXISTANTE);
		}
		return raceArme;
	}

	public boolean validationArme(Arme armeDto) throws ServiceOlivBException {
		boolean bool = true;
		if (armeDto == null) {
			bool = false;
		}
		else {
			if (armeDto.getNom().isEmpty()) 
				throw new ServiceOlivBException(ExceptionMessageErreurOlivB.NOM_ARME_INEXISTANT);
			if (armeDto.getEncombrement() == 0) 
				throw new ServiceOlivBException(ExceptionMessageErreurOlivB.ENCOM_OBLIG);
			if (armeDto.getPrix() < 1) 
				throw new ServiceOlivBException(ExceptionMessageErreurOlivB.PRIX_OBLIG);
		}
		return bool;
	}

	public Joueur getJoueurDto() {
		return joueurDto;
	}

	public void setJoueurDto(Joueur joueurDto) {
		this.joueurDto = joueurDto;
	}

	public List<String> getRaceArme() {
		return raceArme;
	}

	public void setRaceArme(List<String> raceArme) {
		this.raceArme = raceArme;
	}

	public ManageArme getManArme() {
		return manArme;
	}

	public int getArmeId() {
		return armeId;
	}

	public void setArmeId(int armeId) {
		this.armeId = armeId;
	}

	public void setManArme(ManageArme manArme) {
		this.manArme = manArme;
	}

	public ArmeJoueur getArmeJoueurDto() {
		return armeJoueurDto;
	}

	public void setArmeJoueurDto(ArmeJoueur armeJoueurDto) {
		this.armeJoueurDto = armeJoueurDto;
	}

	public List<Joueur> getJoueurs() {
		return joueurs;
	}

	public void setJoueurs(List<Joueur> joueurs) {
		this.joueurs = joueurs;
	}

	public int getJoueurId() {
		return joueurId;
	}

	public void setJoueurId(int joueurId) {
		this.joueurId = joueurId;
	}

	public List<String> getNomRaces() {
		return nomRaces;
	}

	public void setNomRaces(List<String> nomRaces) {
		this.nomRaces = nomRaces;
	}

	public String getMessageErreur() {
		return messageErreur;
	}

	public void setMessageErreur(String messageErreur) {
		this.messageErreur = messageErreur;
	}

}
