package entity.armurerie;

import java.io.Serializable;

/**
 * Classe Arme permettant au joueur de s'équiper pour attaquer
 * @author OlivB
 *
 */
public class Arme implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private String nom;
//	private Race race;
	private int encombrement;
	private int prix;
	private String monnaie;
	
//Constructeurs de la classe	
	public Arme() {
		super();
	}
	
	public Arme(String nom, int encombrement, int prix, String monnaie) {
		super();
		this.nom = nom;
		this.encombrement = encombrement;
		this.prix = prix;
		this.monnaie = monnaie;
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

}
