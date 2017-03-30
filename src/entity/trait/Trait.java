package entity.trait;

import java.io.Serializable;

import entity.trait.comportement.Comportement;
import technic.trait.Comportements;

/**
 * Classe de persistance de la fonctionnalit� Trait
 * @author Jonathan Fuentes
 *
 */

public class Trait implements Serializable{
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;


	//Attributs de classe
	private int				id;
	private	String			libelle;
	private boolean 		visiPublic;
	private boolean			dispoCrea;
	private boolean			malus;
	private Comportements 	listComp;
	private Description 	description;
	
	// Constructeurs
	
	/**
	 * Constructeur par d�faut pour fonctionnement de la persistance
	 */
	public Trait () {
	}
	
	/**
	 * Constructeur complet avec Id pour manipulation en sorti de BDD
	 * @param id
	 * @param libelle
	 * @param visiPublic
	 * @param dispoCrea
	 * @param malus
	 * @param listComp
	 * @param description
	 */
	public Trait(int id, String libelle, boolean visiPublic, boolean dispoCrea, boolean malus,
			Comportements listComp, Description description) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.visiPublic = visiPublic;
		this.dispoCrea = dispoCrea;
		this.malus = malus;
		this.listComp = listComp;
		this.description = description;
	}

	/**
	 * Constructeur complet de persistance complet sans ID (Id auto g�n�r� par Hibernate)
	 * @param libelle
	 * @param visiPublic
	 * @param dispoCrea
	 * @param malus
	 * @param listComp
	 * @param description
	 */
	public Trait(String libelle, boolean visiPublic, boolean dispoCrea, boolean malus,
			Comportements listComp, Description description) {
		super();
		this.libelle = libelle;
		this.visiPublic = visiPublic;
		this.dispoCrea = dispoCrea;
		this.malus = malus;
		this.listComp = listComp;
		this.description = description;
	}

	/**
	 * Constructeur de persistance sans comportements (optionnel � la cr�ation) et sans ID (Id auto g�n�r� par Hibernate)
	 * @param libelle
	 * @param visiPublic
	 * @param dispoCrea
	 * @param malus
	 * @param description
	 */
	public Trait(String libelle, boolean visiPublic, boolean dispoCrea, boolean malus, Description description) {
		super();
		this.libelle = libelle;
		this.visiPublic = visiPublic;
		this.dispoCrea = dispoCrea;
		this.malus = malus;
		this.description = description;
	}
	
	/**
	 * Constructeur de persistance sans description (optionnel � la cr�ation) et sans ID (Id auto g�n�r� par Hibernate)
	 * @param libelle
	 * @param visiPublic
	 * @param dispoCrea
	 * @param malus
	 * @param listComp
	 */
	public Trait(String libelle, boolean visiPublic, boolean dispoCrea, boolean malus,
			Comportements listComp) {
		this.libelle = libelle;
		this.visiPublic = visiPublic;
		this.dispoCrea = dispoCrea;
		this.malus = malus;
		this.listComp = listComp;
	}
	
	/**
	 * Constructeur de persistance sans description ni comportements (optionnel � la cr�ation) et sans ID (Id auto g�n�r� par Hibernate)
	 * @param libelle
	 * @param visiPublic
	 * @param dispoCrea
	 * @param malus
	 */
	public Trait(String libelle, boolean visiPublic, boolean dispoCrea, boolean malus) {
		super();
		this.libelle = libelle;
		this.visiPublic = visiPublic;
		this.dispoCrea = dispoCrea;
		this.malus = malus;
	}
	
	/**
	 * Permet d'enrichir la liste de comportement du trait
	 * @param comportement
	 */
	public void addComp(Comportement comportement) {
		this.listComp.add(comportement);
	}
	
	public Trait getDto () {
		Trait traitDto = new Trait(this.id, this.libelle, this.visiPublic, this.dispoCrea, this.malus, this.listComp, this.description);

		// on ajoute les comportements du persistantBag dans le nouveau docDto
		if (this.getListComp() != null) {
			Comportements listeDto = new Comportements();
			for (Comportement c : this.getListComp()) {
				listeDto.add(c);
			}
			traitDto.setListComp(listeDto);
		}
		return traitDto;
	}
	
	
	// Getters & Setters
	/**
	 * Retourne l'ID
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * Retourne le libell�
	 * @return
	 */
	public String getLibelle() {
		return libelle;
	}

	/**
	 * Modifie le libell�
	 * @param libelle
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/**
	 * Retourne bool�en informant si le trait � une visibilit� public (par tous)
	 * @return
	 */
	public boolean isVisiPublic() {
		return visiPublic;
	}

	/**
	 * Modifie la visibilit� du trait
	 * @param visiPublic
	 */
	public void setVisiPublic(boolean visiPublic) {
		this.visiPublic = visiPublic;
	}

	/**
	 * Retourne bool�en informant si le trait est disponible � la cr�ation
	 * @return
	 */
	public boolean isDispoCrea() {
		return dispoCrea;
	}

	/**
	 * Modifie la disponibilit� du trait � la cr�ation
	 * @param dispoCrea
	 */
	public void setDispoCrea(boolean dispoCrea) {
		this.dispoCrea = dispoCrea;
	}

	/**
	 * Retourne un bool�en informant si le trait est un malus ou bonus
	 * @return
	 */
	public boolean isMalus() {
		return malus;
	}

	/**
	 * Modifie la nature du trait
	 * @param malus
	 */
	public void setMalus(boolean malus) {
		this.malus = malus;
	}

	/**
	 * Retourne la liste des comportements du trait
	 * @return
	 */
	public Comportements getListComp() {
		return listComp;
	}

	/**
	 * Modifie la liste de comportement du trait
	 * @param listComp
	 */
	public void setListComp(Comportements listComp) {
		this.listComp = listComp;
	}

	/**
	 * Retourne la description du trait
	 * @return
	 */
	public Description getDescription() {
		return description;
	}

	/**
	 * Modifie la description du trait
	 * @param description
	 */
	public void setDescription(Description description) {
		this.description = description;
	}

	
	@Override
	public String toString() {
		return "id : " 								+ id 
				+ ", libelle = " 					+ libelle
				+ ", Visibilit� publique = " 		+ visiPublic 
				+ ", Disponible � la cr�ation = " 	+ dispoCrea
				+ ", Maluse = " + malus 
				+ (listComp    != null ? ", Comportements = " + listComp : "")
				+ (description != null ? ", description   = " + description.getContenu() : "");
	}
	
}// Fin classe
