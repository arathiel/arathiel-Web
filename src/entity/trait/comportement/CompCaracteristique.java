package entity.trait.comportement;

import java.io.Serializable;

import entity.race_bonus_carac.caracteristique.Caracteristique;

/**
 * Classe permettant la gestion de comportement influençant les caractéristiques
 * @author Jonathan Fuentes
 *
 */

public class CompCaracteristique extends Technique implements Serializable{

	// Attribut de classe
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	

	private Caracteristique caracteristique;
		
	// Constructeur
	/**
	 * Constructeur par défaut
	 */
	public CompCaracteristique() {
	}
	
	/**
	 * Constructeur avec Id pour manipulation en sorti de BDD
	 * @param id
	 * @param libelle
	 * @param effet
	 */
	public CompCaracteristique(int id, String libelle, Caracteristique caracteristique) {
		super(id, libelle);
		this.caracteristique = caracteristique;
	}
	
	/**
	 * Constructeur sans ID pour premier ajout dans la BDD (Id auto généré par Hibernate)
	 * @param libelle
	 * @param effet
	 */
	public CompCaracteristique(String libelle, Caracteristique caracteristique) {
		super(libelle);
		this.caracteristique = caracteristique;
	}
	
	
	// Getters & Setters

	/**
	 * Retourne la caractéristique associée au comportement
	 * @return
	 */
	public Caracteristique getCaracteristique() {
		return caracteristique;
	}

	/**
	 * Modifie la caractéristique associée au comportement
	 * @param caracteristique
	 */
	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}

	/**
	 * Affiche CompCaracterique
	 */
	@Override
	public String toString() {
		return super.toString() 
			+(caracteristique != null ? ", Caracteristique  = " + caracteristique.getNomCarac() : "");
	}
	


	
}// Fin classe


