package entity.race_bonus_carac.race;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import clientServeur.race_bonus_carac.interfaces.IPackable;
import entity.race_bonus_carac.bonus.Bonus;
import parametres.race_bonus_carac.bonus.ParamIPackable;


public class Race implements IPackable, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int id;
	
	private String nom;

	private boolean dispo = false;

	private int coutXp = ParamIPackable.COUT_XP_RACE;

	private Collection<Bonus> listeBonus = new ArrayList<Bonus>(); 
	
	
	public Race(){
	}
	
	
	public Race (int id, String nom, boolean dispo) {
		this.id = id;
		this.nom = nom;
		this.dispo = dispo;
	}
	
	
	public Race (String nom, boolean dispo){
		this.nom 	= nom;
		this.dispo 	= dispo;
	}
	
	

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public void setDispo(boolean dispo) {
		this.dispo = dispo;		
	}

	@Override
	public void setCoutXp(int coutXp) {
		this.coutXp = coutXp;		
	}

	@Override
	public void setListeBonus(Collection<Bonus> listeBonus) {
		this.listeBonus = listeBonus;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getNom() {
		return nom;
	}

	@Override
	public boolean isDispo() {
		return dispo;
	}

	@Override
	public int getCoutXp() {
		return coutXp;
	}

	@Override
	public Collection<Bonus> getListeBonus() {
		return this.listeBonus;
	}

	@Override
	public int calculRenduXp() {
		int renduXp = this.getCoutXp();
		
		for (Bonus b: this.getListeBonus()){
			renduXp = renduXp - b.getCoutXp();
		}
		return renduXp;
	}

	@Override
	public void ajouterBonus(Bonus bonus) {
		this.listeBonus.add(bonus);		
	}

	@Override
	public void enleverBonus(Bonus bonus) {
		this.listeBonus.remove(bonus);		
	}
	
	@Override
	public String toString() {
		return ("Id: "+this.getId()+" Nom: "+this.getNom()+" Dispo: "+this.isDispo()+" Nb Bonus: "+this.getListeBonus().size());
	}
	
}
