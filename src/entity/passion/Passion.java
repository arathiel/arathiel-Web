package entity.passion;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import entity.magie.MDPFondamental;
import entity.race_bonus_carac.race.Race;

/**
 * EJB Entity repr�sentant le concept de Passion, ou caract�re du personnage
 * 
 * RG: Une passion est reli�e � une et une seule race Une race est li�e � une et
 * une seule passion
 * 
 * @author Ana�s
 *
 */

public class Passion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int id;

	
	private String nom;

	private String description;

	
	private Race race;

	private Collection<MDPFondamental> magies = new ArrayList<MDPFondamental>();

	/**
	 * Constructeur par d�faut
	 */
	public Passion() {
		super();
	}

	/**
	 * Constructeur avec param�tre, l'id est g�n�r� par la base de donn�es
	 * 
	 * @param nom
	 * @param description
	 */
	public Passion(String nom, String description) {
		super();
		this.nom = nom;
		this.description = description;
	}

	/**
	 * Constructeur avec param�tre id
	 * 
	 * @param nom
	 * @param description
	 */
	public Passion(int id, String nom, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Race getRace() {
		return race;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public Collection<MDPFondamental> getMagies() {
		return magies;
	}

	public void setMagies(Collection<MDPFondamental> magies) {
		this.magies = magies;
	}

	
	public void addMagie(MDPFondamental magie) {
		if (magie != null) {
			if (magies == null)
				magies = new ArrayList<MDPFondamental>();
			if (!magies.contains(magie)) {
				magies.add(magie);
			}
		}
	}

	@Override
	public String toString() {

		String idRace = "";
		String lesMagies = "";

		if (this.race != null){
			idRace = String.valueOf(race.getId());
		}else{
			idRace= "aucune";
		}
		if (this.magies != null)
			lesMagies = this.magies.toString();

		return "Passion [id=" + getId() + ", nom=" + getNom() + ", description=" + getDescription()
				+ ", race=" + idRace + ", magies=" + lesMagies + "]";
	}

}
