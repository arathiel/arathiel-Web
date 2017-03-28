package entity.race_bonus_carac.bonus;



import entity.race_bonus_carac.caracteristique.Caracteristique;
import parametres.race_bonus_carac.bonus.ParamBonus;

/**
 * Classe fabriquée par la Classe {@link}FabriqueBonus
 * 
 * 
 * @author François Georgel
 *
 */



public class BonusCarac extends Bonus{
	
	private static final long serialVersionUID = 1L;

	private Caracteristique caracAssociee;
	
	public BonusCarac(){		
	}
	
	public BonusCarac(Caracteristique carac, int valeur){
		this.caracAssociee = carac;
		this.setValeurBonus(valeur);
	}
	
	public Caracteristique getCaracAssociee() {
		return caracAssociee;
	}

	public void setCaracAssociee(Caracteristique caracAssociee) {
		this.caracAssociee = caracAssociee;
	}


	@Override
	public void calculerCoutXp() {
		int cout = this.getValeurBonus()*ParamBonus.COUT_XP_CARAC_PAR_POINT;
		this.setCoutXp(cout);
	}
	
	public String toString() {
		return "Bonus Carac Id: "+this.getIdBonus()+" Valeur= "+this.getValeurBonus();  
	}
	
}
