package entity.trait.comportement;

import java.io.Serializable;



/**
 * Classe mère des comportements influençant numériquement le jeu
 * @author Jonathan Fuentes
 *
 */

public abstract class Technique extends Comportement implements Serializable{

	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	//Constructeur
	
	/**
	 * Constructeur sans ID pour premier ajout dans la BDD (Id auto généré par Hibernate)
	 * @param libelle
	 * @param effet
	 */
	public Technique() {
	}

	/**
	 * Constructeur avec Id pour manipulation en sorti de BDD
	 * @param id
	 * @param libelle
	 * @param effet
	 */
	public Technique(int id, String libelle) {
		super(id, libelle);
	}
	
	/**
	 * Constructeur sans ID pour premier ajout dans la BDD (Id auto généré par Hibernate)
	 * @param effet
	 */
	public Technique(String libelle) {
		super(libelle);
	}
		
}
