package entity.race_bonus_carac.caracteristique;

import java.io.Serializable;

import clientServeur.race_bonus_carac.interfaces.IBonussable;

/** 
 * Classe 
 * 
 * N.B. cette classe qui doit pourvoir �tre modifiable par la suite dans l'appli web n'est pour le moment pas
 * �ditable. 
 * La table, cr�e au moment du lancement du serveur sera compl�t�e "� la main"
 * 
 * 
 * @author Fran�ois Georgel
 *
 */


public class Caracteristique implements IBonussable, Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private String idCarac;
	private String nomCarac;
	private Aspect aspect;
	private Qualite qualite;
	
	public Caracteristique() {	
	}
	
	public Caracteristique(String id, String nom){
		this.idCarac = id;
		this.nomCarac = nom;
	}
	
	public Caracteristique(String nom, Aspect aspect, Qualite qualite) {
		this.nomCarac = nom;
		this.aspect = aspect;
		this.qualite = qualite;
	}
	
	public Caracteristique (String id, String nom, Aspect aspect, Qualite qualite) {
		this.idCarac = id;
		this.nomCarac = nom;
		this.aspect = aspect;
		this.qualite = qualite;
	}
	
	public String getIdCarac() {
		return idCarac;
	}
	public void setIdCarac(String idCarac) {
		this.idCarac = idCarac;
	}
	public String getNomCarac() {
		return nomCarac;
	}
	public void setNomCarac(String nomCarac) {
		this.nomCarac = nomCarac;
	}
	
	public Aspect getAspect() {
		return aspect;
	}
	
	public void setAspect(Aspect aspect) {
		this.aspect = aspect;
	}
	
	public Qualite getQualite() {
		return qualite;
	}
	
	public void setQualite(Qualite qualite) {
		this.qualite = qualite;
	}
	

}
