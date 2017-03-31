package entity.trait;

import java.io.Serializable;

/**
 * Classe de persistance de Description associée à Trait
 * @author Jonathan Fuentes
 *
 */
public class Description implements Serializable{

	// Attributs de classe
	private static final long serialVersionUID = 1L;
	private String 	contenu;

	// Constructeur
	/**
	 * Constructeur par défaut
	 */
	public Description () {
	}
	
	/**
	 * Constructeur
	 * @param id
	 * @param contenu
	 */
	public Description(String contenu) {
		this.contenu 	= contenu;
	}


	/**
	 * Retourne le contenu de la description
	 * @return
	 */
	public String getContenu() {
		return contenu;
	}

	/**
	 * Modifie le contenu de la Description
	 * @param contenu
	 */
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	/**
	 * Affiche Description
	 */
	@Override
	public String toString() {
		return "Description = " + contenu;
	}
	
}// Fin classe
