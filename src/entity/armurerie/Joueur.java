package entity.armurerie;

import java.io.Serializable;

public class Joueur implements Serializable{

	private static final long serialVersionUID = 1L;

	private int idJoueur;
	private String nomJoueur;
	
	public Joueur() {
		super();
	}
	
	public Joueur(int idJoueur) {
		super();
		this.idJoueur = idJoueur;
	}

	public Joueur(String nomJoueur) {
		super();
		this.nomJoueur = nomJoueur;
	}

	public Joueur(int idJoueur, String nomJoueur) {
		super();
		this.idJoueur = idJoueur;
		this.nomJoueur = nomJoueur;
	}


	public int getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(int idJoueur) {
		this.idJoueur = idJoueur;
	}

	public String getNomJoueur() {
		return nomJoueur;
	}

	public void setNomJoueur(String nomJoueur) {
		this.nomJoueur = nomJoueur;
	}

	@Override
	public String toString() {
		return "Joueur [idJoueur=" + idJoueur + ", nomJoueur=" + nomJoueur + "]";
	}
}
