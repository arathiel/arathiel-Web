package entity.armurerie;

import java.io.Serializable;
import java.util.Collection;

import clientServeur.IArme;
import entity.race_bonus_carac.race.Race;


/**
 * Classe Arme permettant au joueur de s'équiper pour attaquer
 * @author OlivB
 *
 */
public class Arme implements IArme, Serializable{


	private static final long serialVersionUID = 1L;
	
	private int idArme;
	private String nom;
	private int encombrement;
	private int prix;
	private String monnaie;
	private Collection<Race> races;
	
//Constructeurs de la classe	
	public Arme() {
		super();
	}
	
	public Arme(int idArme) {
		super();
		this.idArme = idArme;
	}
	
	public Arme(int idArme, String nom) {
		super();
		this.idArme = idArme;
		this.nom = nom;
	}

	public Arme(String nom, int encombrement, int prix, String monnaie) {
		super();
		this.nom = nom;
		this.encombrement = encombrement;
		this.prix = prix;
		this.monnaie = monnaie;
	}

	public void setIdArme(int idArme) {
		this.idArme = idArme;
	}

	//Getters et Setters
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEncombrement() {
		return encombrement;
	}
	public void setEncombrement(int encombrement) {
		this.encombrement = encombrement;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	public String getMonnaie() {
		return monnaie;
	}
	public void setMonnaie(String monnaie) {
		this.monnaie = monnaie;
	}


	@Override
	public int getIdArme() {
		return idArme;
	}

	@Override
	public Collection<Race> getRaces() {
		return races;
	}

	@Override
	public void setRaces(Collection<Race> races) {
		this.races = races;
	}

	@Override
	public String toString() {
		return "Arme [idArme=" + idArme + ", nom=" + nom + ", encombrement=" + encombrement + ", prix=" + prix
				+ ", monnaie=" + monnaie + ", races=" + races + "]";
	}	

}