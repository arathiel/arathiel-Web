package clientServeur;

import java.util.ArrayList;


import clientServeur.exception.UserException;
import clientServeur.race_bonus_carac.userException.UserExceptionRBC;
import entity.race_bonus_carac.bonus.Bonus;
import entity.race_bonus_carac.caracteristique.Caracteristique;
import entity.race_bonus_carac.race.Race;
import entity.trait.Trait;
import entity.trait.comportement.Comportement;
import technic.trait.Comportements;
import technic.trait.Traits;

/**
 * Interface pour service.FacadeService.class
 * 
 * Contient la liste de toutes les m�thodes accessibles depuis le serveur web.
 * 
 * @author Groupe
 * @version 2017/03/13
 *
 */

public interface IFacadeService {

//-------------------------------------------------------------------------------------------- Jonathan
	
	/* ========================================== */ 
	/*  				TRAIT					  */
	/* ========================================== */
	
	//Administration
	
	/**
	 * Ajoute un trait
	 * @param trait
	 * @throws UserException
	 */
	public void ajouterTrait			(Trait trait) 		throws UserException;
	
	/**
	 * Modifie un trait
	 * @param trait
	 * @throws UserException
	 */
	public void modiferTrait			(Trait trait) 		throws UserException;
	
	/**
	 * Supprime un trait
	 * @param id
	 * @throws UserException
	 */
	public void supprimerTrait			(int id) 			throws UserException;
	
	/**
	 * Supprime tous les traits
	 * @throws UserException
	 */
	public void reinitialiserTrait		() 					throws UserException;
	
	
	//Consultation
	
	/**
	 * Retourne un trait via son ID
	 * @param id
	 * @return
	 * @throws UserException
	 */
	public Trait  consulterTraitById	(int id) 			throws UserException;
	
	/**
	 * Retourne un trait via son libell�
	 * @param libelle
	 * @return
	 * @throws UserException
	 */
	public Trait  consulterTraitByLib	(String libelle) 	throws UserException;
	
	/**
	 * Retourne la liste complete de tous les traits
	 * @return
	 */
	public Traits consulterListTrait	();
	
	/**
	 * Retourne la liste des trait d'apr�s libell�
	 * @return
	 */
	public Traits consulterListTraitByLib(String libelle);
	
	
	/* ========================================== */ 
	/*  			COMPORTEMENT				  */
	/* ========================================== */
	
	// Administration
	
	/**
	 * Ajoute un comportement
	 * @param comportement
	 * @throws UserException
	 */
	public void ajouterComp					(Comportement comportement) throws UserException;
	
	/**
	 * Modifie un comportement
	 * @param comportement
	 * @throws UserException
	 */
	public void modifierComp				(Comportement comportement) throws UserException;
	
	/**
	 * Supprime un comportement
	 * @param id
	 * @throws UserException
	 */
	public void supprimerComp				(int id) 					throws UserException;
	
	/**
	 * Supprime tous les comportements
	 * @throws UserException
	 */
	public void reinitialiserComp 			() 							throws UserException;
	
	
	//Consultation
	
	/**
	 * Retourne un comportement via son ID
	 * @param id
	 * @return
	 * @throws UserException
	 */
	public Comportement  consulterCompById	(int id) 					throws UserException;
	
	/**
	 * Retourne un comportement via son libell�
	 * @param libelle
	 * @return
	 * @throws UserException
	 */
	public Comportement  consulterCompByLib	(String libelle) 			throws UserException;
	
	/**
	 * Retourne la liste compl�te des comportements
	 * @return
	 */
	public Comportements consulterListComp	();
	
	
	//--------------------------------------------------------------------------------------------  Francois
	
	/* ========================================== */ 
	/*  				RACE					  */
	/* ========================================== */
	public void enregistrerRace (Race race) throws UserExceptionRBC;
	public void supprimerRace(Race race) throws UserExceptionRBC;
	public void modifierRace(Race race) throws UserExceptionRBC;
	public ArrayList<Race> listeToutesRaces();
	public ArrayList<Race> listeRacesJouables();
	public Race RechRaceParNom(String nom) throws UserExceptionRBC;
	public Race RechRaceParId(int id) throws UserExceptionRBC;
	
	
	/* ========================================== */ 
	/*  			CARACTERISTIQUE				  */
	/* ========================================== */
	public void insertBonus (Bonus bonus) throws UserExceptionRBC;
	public ArrayList<Bonus> listeTousBonus();
	public void deleteBonus(Bonus bonus) throws UserExceptionRBC;
	
		
	
	/* ========================================== */ 
	/*  				BONUS					  */
	/* ========================================== */
	public void insertCarac (Caracteristique carac);
	public void deleteCarac(Caracteristique carac);	
	public ArrayList<Caracteristique> listeCarac();
	
	
	
	
	

	//-------------------------------------------------------------------------------------------- SUIVANT
	
	
	
}// Fin classe