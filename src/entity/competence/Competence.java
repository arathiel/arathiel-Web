package entity.competence;

import java.io.Serializable;

public class Competence implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	
	
	public Competence() {		
	}
	
	public Competence(int id, String nom){
		this.id= id;
		this.nom = nom;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	

}
