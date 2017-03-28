package entity.trait.comportement;

import java.io.Serializable;


/**
 * Classe de persistence des comportement influen�ant le Roleplay
 * @author Jonathan Fuentes
 *
 */

public class CompRoleplay extends Comportement implements Serializable{

	//Attributs
	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;

	
	//Constructeur
	/**
	 * Constructeur par d�faut
	 */
	public CompRoleplay() {
	}
	
	/**
	 * Constructeur avec Id pour manipulation en sorti de BDD
	 * @param id
	 * @param libelle
	 * @param effet
	 */
	public CompRoleplay(int id, String libelle) {
		super(id, libelle);
	}
	
	/**
	 * Constructeur sans ID pour premier ajout dans la BDD (Id auto g�n�r� par Hibernate)
	 * @param libelle
	 * @param effet
	 */
	public CompRoleplay(String libelle) {
		super(libelle);
	}
	
}
