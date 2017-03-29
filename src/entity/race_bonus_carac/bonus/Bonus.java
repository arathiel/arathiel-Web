package entity.race_bonus_carac.bonus;

import java.io.Serializable;


public abstract class Bonus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	private String idBonus;
	private int valeurBonus;
	private int coutXp;
	

	public Bonus(){		
	}
	
	public String getIdBonus() {
		return idBonus;
	}

	public void setIdBonus(String idBonus) {
		this.idBonus = idBonus;
	}

	public int getValeurBonus() {
		return valeurBonus;
	}

	public void setValeurBonus(int valeurBonus) {
		this.valeurBonus = valeurBonus;
	}

	public int getCoutXp() {
		return coutXp;
	}

	public void setCoutXp(int coutXp) {
		this.coutXp = coutXp;
	}
	
	public void calculerCoutXp() {
		this.coutXp = 0;
	}
	

}
