package entity.race_bonus_carac.bonus;


import entity.trait.Trait;
import parametres.race_bonus_carac.bonus.ParamBonus;


/**
 * Classe fabriquée par la Classe {@link}FabriqueBonus
 * 
 * 
 * @author François Georgel
 *
 */


public class BonusTrait extends Bonus{


	private static final long serialVersionUID = 1L;

	
	public Trait traitAssocie;
	
	public BonusTrait(){
		
	}

	public BonusTrait (Trait trait, int valeur) {
		this.traitAssocie = trait;
		this.setValeurBonus(valeur);
		this.calculerCoutXp();
	}

	
	public Trait getTraitAssocie() {
		return traitAssocie;
	}


	public void setTraitAssocie(Trait traitAssocie) {
		this.traitAssocie = traitAssocie;
	}


	@Override
	public void calculerCoutXp() {
		int cout = 0;
		if (this.getValeurBonus() == 0) {
			cout = ParamBonus.COUT_XP_TRAIT_VALEUR_0;
		}			
		else if (this.getValeurBonus() <= 4) {
			cout = ParamBonus.COUT_XP_TRAIT_VALEUR_3;
		}
		else if (this.getValeurBonus() >4) {
			cout = ParamBonus.COUT_XP_TRAIT_VALEUR_5;
		}
		
		this.setCoutXp(cout);
	}
	
	public String toString() {
		return "Bonus Trait Id: "+this.getIdBonus()+" Valeur= "+this.getValeurBonus();  
	}
}
