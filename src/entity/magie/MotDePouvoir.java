package entity.magie;

import java.io.Serializable;

public abstract class MotDePouvoir implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int id;


	private String libelle;

	/**
	 * Constructeur par défaut
	 * 
	 */
	public MotDePouvoir() {
		super();
	}

	/**
	 * Constructeur avec l'ensemble des paramètres
	 * 
	 * @param id
	 * @param libelle
	 */
	public MotDePouvoir(int id, String libelle) {
		super();
		this.id = id;
		this.libelle = libelle;
	}

	/**
	 * Constructeur avec seulement le nom du mot de pouvoir, l'id est géré par
	 * la table
	 * 
	 * @param id
	 * @param libelle
	 */
	public MotDePouvoir(String libelle) {
		super();
		this.libelle = libelle;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return "MotDePouvoir [id=" + id + ", libelle=" + libelle + "]";
	}

}
