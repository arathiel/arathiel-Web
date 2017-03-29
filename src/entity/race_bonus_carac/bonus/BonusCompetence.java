package entity.race_bonus_carac.bonus;


import entity.competence.Competence;
import parametres.race_bonus_carac.bonus.ParamBonus;

/**
 * Classe fabriquée par la Classe {@link}FabriqueBonus
 * 
 * 
 * @author François Georgel
 *
 */


public class BonusCompetence extends Bonus{

	private static final long serialVersionUID = 1L;

	private Competence compAssociee;
	private boolean academique;
	
	public BonusCompetence(){
		
	}
	
	public BonusCompetence(Competence comp, int valeur, boolean acad){
		this.compAssociee = comp;
		this.academique = acad;
		this.calculerCoutXp();
	}

	public Competence getCompAssociee() {
		return compAssociee;
	}

	public void setCompAssociee(Competence compAssociee) {
		this.compAssociee = compAssociee;
	}

	public boolean isAcademique() {
		return academique;
	}

	public void setAcademique(boolean academique) {
		this.academique = academique;
	}
	
	@Override
	public void calculerCoutXp() {
		int cout = this.getValeurBonus()*ParamBonus.COUT_XP_COMP_PAR_POINT;
		if (this.isAcademique()) {
			cout = cout * ParamBonus.MULTIPLICATEUR_COMP_ACAD;
		}
		this.setCoutXp(cout);
	}
	
	public String toString() {
		return "Bonus Comp Id: "+this.getIdBonus()+" Valeur= "+this.getValeurBonus()+"Academique = "+this.isAcademique();  
	}
}
