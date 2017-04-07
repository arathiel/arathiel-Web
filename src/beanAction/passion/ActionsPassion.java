package beanAction.passion;

import java.util.ArrayList;
import java.util.List;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import clientServeur.exception.ExceptionService;
import clientServeur.race_bonus_carac.userException.UserExceptionRBC;
import entity.magie.MDPFondamental;
import entity.passion.Passion;
import entity.race_bonus_carac.race.Race;

public class ActionsPassion extends ApplicationSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static IFacadeService serviceFacade;

	private List<Race> listeRace = new ArrayList<Race>();
	private List<MDPFondamental> listeMdpFond = new ArrayList<MDPFondamental>();
	private List<Passion> listePassions;
	private Passion passion;
	private Race race;
	private String codeRetour;

	// Récupération des données de la jsp
	private String passionNom;
	private String passionDescription;
	private String passionId;
	private String selectionRace;
	private String selectionMagie;
	private String lettres;
	private String messErreur;
	private String nomPassion;
	private String passionMagie;
	private String[] magieMod;

	/*
	 * Méthode permettant d'initialiser le contexte
	 * 
	 */
	public void init() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			serviceFacade = (IFacadeService) ctx.lookup("ejb:/arathiel-EJB/FacadeService!clientServeur.IFacadeService");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	public String affiche() {
		init();
		codeRetour = "affiche";
		listeBdd();
		return codeRetour;
	}

	public String ajouter() {
		init();
		System.out.println("Coucou je suis dans ajouter");
		codeRetour = SUCCESS;

		String[] magie = selectionMagie.split(",");

		/* Création de l'objet Passion */
		passion = new Passion(passionNom, passionDescription);
		/* Création de l'objet Race, et association avec la passion */
		System.out.println(selectionRace);
		System.out.println(selectionRace.isEmpty());

		if (selectionRace != null || selectionRace != "" || !selectionRace.isEmpty() || selectionRace != "0") {
			// Race race = serviceFacade.RechRaceParNom(selectionRace);
//			System.out.println(raceP);
			Race raceP = new Race(selectionRace, true);
			passion.setRace(raceP);
		}
		for (int i = 0; i < magie.length; i++) {
			if (magie[i] != null) {
				// System.out.println(magie[i]);
				MDPFondamental mot = new MDPFondamental(magie[i]);
				// System.out.println(mot);
				passion.addMagie(mot);
			}
		}
		try {
			serviceFacade.addPassion(passion);
		} catch (UserExceptionRBC | ExceptionService e) {
			System.out.println(e.getMessage());
			messErreur= e.getMessage();
			codeRetour = "probleme";
		}

		System.out.println(codeRetour);
		return codeRetour;
	}

	/**
	 * Méthode permettant d'afficher la page de recherche d'une passion
	 * 
	 * @return
	 */
	public String liste() {
		System.out.println("dans liste");
		codeRetour = "liste";
		return codeRetour;
	}

	/**
	 * Méthode permettant d'afficher le détail d'une passion sélectionnée
	 * précédemment
	 * 
	 * @return
	 */
	public String detail() {
		System.out.println("Dans détail");
		codeRetour = "detail";

		listeBdd();
		System.out.println(passionId);
		int id = Integer.parseInt(passionId);
		try {
			passion = serviceFacade.getPassion(id);
			System.out.println(passion.getRace());
			System.out.println(passion.getMagies());
		} catch (ExceptionService /* | UserExceptionRBC */ e) {
			messErreur = e.getMessage();
			codeRetour = "erreur";
			return codeRetour;
		}
		return codeRetour;
	}

	/**
	 * Méthode utilisée pour rechercher en base des passions
	 * 
	 * @return
	 */
	public String recherche() {
		init();
		System.out.println("dans recherche");
		listePassions = null;

		System.out.println("les lettres sont : " + lettres);

		// Initialisation des variables
		listePassions = serviceFacade.getPassionsByLettres(lettres);

		System.out.println("La listePassion est : " + listePassions);
		codeRetour = "recherche";
		return codeRetour;
	}

	/**
	 * Méthode utilisée pour supprimer une passion
	 * 
	 * @return
	 */
	public String supprimer() {
		init();
		System.out.println("dans supprimer");
		codeRetour = SUCCESS;
		System.out.println(passionNom);
		try {
			serviceFacade.delPassion(passionNom);
		} catch (ExceptionService e) {
			messErreur = e.getMessage();
			codeRetour = "erreur";
		}
		return codeRetour;
	}

	/**
	 * Méthode utilisée pour modifier une passion en base de données
	 * 
	 * @return
	 */
	public String modifier() {
		init();
		// System.out.println("dans modifier");
		// System.out.println(passionNom);
		// System.out.println(passionDescription);
		// System.out.println(selectionRace);
		// System.err.println(selectionMagie);
		codeRetour = SUCCESS;
		// System.out.println(nomPassion);

		String[] magie = selectionMagie.split(",");

		/* Création de l'objet Passion */
		passion = new Passion(passionNom, passionDescription);
		/* Création de l'objet Race, et association avec la passion */
		System.out.println(selectionRace);
		System.out.println(selectionRace.isEmpty());

		//Si la race n'est pas sélectionnée selectionRace = ? undefined:undefined ?
		
		if (selectionRace != null || 
				selectionRace != "" || 
				!selectionRace.isEmpty() || 
				selectionRace != "0" || 
				selectionRace != "? undefined:undefined ?") {
			Race raceP = new Race(selectionRace, true);
			System.out.println(raceP);
			passion.setRace(raceP);
		}

		for (int i = 0; i < magie.length; i++) {
			if (magie[i] != null) {
				// System.out.println(magie[i]);
				MDPFondamental mot = new MDPFondamental(magie[i]);
				// System.out.println(mot);
				passion.addMagie(mot);
			}
		}
//		try {
//			//serviceFacade.updatePassion(passion);
//		} catch (ExceptionService e) {
//			messErreur = e.getMessage();
//			codeRetour = "erreur";
//		} catch (UserExceptionRBC e) {
//			messErreur = e.getMessage();
//			codeRetour = "erreur";
//		}
		return codeRetour;
	}

	/**
	 * Méthode permettant de remplir les listes pour la sélection de race et des
	 * mots de pouvoir
	 */
	private void listeBdd() {
		listeRace = serviceFacade.getRaceLibre();
		listeMdpFond = serviceFacade.getMDPFondamentalTrieNom();
	}

	@Override
	public void validate() {
		if (passion.getNom().trim().isEmpty())
			addFieldError("nomPassion", "Le nom de la passion est obligatoire");
		if (hasFieldErrors()) {
			addActionError("actionError : Vous faites n'importe quoi !!! ");
			addActionMessage("actionMessage : Veuillez vérifier votre saisie ;)");
		}
	}

	/* Getter et setter */

	public List<Race> getListeRace() {
		return listeRace;
	}

	public List<MDPFondamental> getListeMdpFond() {
		return listeMdpFond;
	}

	public Passion getPassion() {
		return passion;
	}

	public void setPassion(Passion passion) {
		this.passion = passion;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public String getSelectionRace() {
		return selectionRace;
	}

	public void setSelectionRace(String selectionRace) {
		this.selectionRace = selectionRace;
	}

	public String getSelectionMagie() {
		return selectionMagie;
	}

	public void setSelectionMagie(String selectionMagie) {
		this.selectionMagie = selectionMagie;
	}

	public String getMessErreur() {
		return messErreur;
	}

	public void setMessErreur(String messErreur) {
		this.messErreur = messErreur;
	}

	public String getPassionNom() {
		return passionNom;
	}

	public void setPassionNom(String passionNom) {
		this.passionNom = passionNom;
	}

	public String getPassionDescription() {
		return passionDescription;
	}

	public void setPassionDescription(String passionDescription) {
		this.passionDescription = passionDescription;
	}

	public List<Passion> getListePassions() {
		return listePassions;
	}

	public void setListePassions(List<Passion> listePassions) {
		this.listePassions = listePassions;
	}

	public String getLettres() {
		return lettres;
	}

	public void setLettres(String lettres) {
		this.lettres = lettres;
	}

	public String getPassionId() {
		return passionId;
	}

	public void setPassionId(String passionId) {
		this.passionId = passionId;
	}

	public String getNomPassion() {
		return nomPassion;
	}

	public void setNomPassion(String nomPassion) {
		this.nomPassion = nomPassion;
	}

	public String getPassionMagie() {
		return passionMagie;
	}

	public void setPassionMagie(String passionMagie) {
		this.passionMagie = passionMagie;
	}

	public String[] getMagieMod() {
		return magieMod;
	}

	public void setMagieMod(String[] magieMod) {
		this.magieMod = magieMod;
	}
}
