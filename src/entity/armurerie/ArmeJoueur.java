package entity.armurerie;

import java.io.Serializable;

import util.armurerie.Etat;


public class ArmeJoueur implements Serializable{

	private static final long serialVersionUID = 1L;

	private Arme 	arme;
	private Joueur 	joueur;
	private Etat 	etat;

	public ArmeJoueur() {
		super();
	}

	public ArmeJoueur(Etat etat) {
		super();
		this.etat = etat;
	}

	public ArmeJoueur(Arme arme, Joueur joueur, Etat etat) {
		this.setArme(arme);
		this.setJoueur(joueur);
		this.setEtat(etat);
	}

	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}


	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return "ArmeJoueur [arme=" + arme + ", joueur=" + joueur + ", etat=" + etat + "]";
	}
}
