package util.armurerie;

public enum ExceptionMessageErreurOlivB {
	
	DOUBLON_ARME ("L'arme existe d�j�"),
	ARME_NULL ("L'arme est vide"),
	ARME_INEXISTANTE ("L'arme recherch�e n'existe pas"),
	NO_LISTE_ARME ("Liste d'armes inexistante"),
	NOM_ARME_INEXISTANT ("Le nom de l'arme est obligatoire"),
	DOUBLON_ARMEJOUEUR ("Le joueur poss�de d�j� cette arme"),
	ENCOM_OBLIG ("L'encombrement est obligatoirement sup�rieur � 0"),
	PRIX_OBLIG ("le prix de l'arme est obligatoirement sup�rieur � 1"),
	RACE_INEXISTANTE ("Aucune race n'est associ�e � l'arme"),
	NO_LISTE_RACE ("Liste de race in�xistante"),
	NO_RACE ("La race n'existe pas");
	
	public String message;

	private ExceptionMessageErreurOlivB(String message) {
		this.setMessage(message);
	}
	public String getMessage() {
		return this.message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
