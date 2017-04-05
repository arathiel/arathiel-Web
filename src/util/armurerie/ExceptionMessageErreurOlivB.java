package util.armurerie;

public enum ExceptionMessageErreurOlivB {

	DOUBLON_ARME 		("L'arme existe d�j�"),
	ARME_NULL 			("L'arme est vide"),
	ARME_INEXISTANTE 	("L'arme recherch�e n'existe pas"),
	NO_LISTE_ARME 		("Liste d'armes inexistante"),
	NOM_ARME_INEXISTANT ("Le nom de l'arme est obligatoire"),
	NO_LISTE_JOUEUR 	("Il n'existe aucun joueur"),
	NO_JOUEUR 			("Le joueur n'existe pas"),
	DOUBLON_ARMEJOUEUR 	("Le joueur poss�de d�j� cette arme"),
	ARMEJOUR_NULL 		("L'arme est vide"),
	ENCOM_OBLIG 		("L'encombrement est obligatoirement sup�rieur � 0"),
	PRIX_OBLIG 			("le prix de l'arme est obligatoirement sup�rieur � 1"),
	RACE_INEXISTANTE 	("Aucune race n'est associ�e � l'arme"),
	NO_LISTE_RACE 		("Liste de race in�xistante"),
	NO_RACE 			("La race n'existe pas");

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

	public String getEnumException() {
		switch(this) {
		case DOUBLON_ARME : 
			return "L'arme existe d�j�";
		case ARME_NULL :
			return "L'arme est vide";
		case ARME_INEXISTANTE :
			return "L'arme recherch�e n'existe pas";
		case NO_LISTE_ARME : 
			return "Liste d'armes inexistante";
		case NOM_ARME_INEXISTANT :
			return "Le nom de l'arme est obligatoire";		
		case NO_LISTE_JOUEUR :
			return "Il n'existe aucun joueur";
		case NO_JOUEUR :
			return "Le joueur n'existe pas";		
		case DOUBLON_ARMEJOUEUR :
			return "Le joueur poss�de d�j� cette arme";
		case ARMEJOUR_NULL :
			return "L'arme est vide";
		case ENCOM_OBLIG :
			return "L'encombrement est obligatoirement sup�rieur � 0";
		case PRIX_OBLIG :
			return "le prix de l'arme est obligatoirement sup�rieur � 1";
		case RACE_INEXISTANTE :
			return "Aucune race n'est associ�e � l'arme";		
		case NO_LISTE_RACE :
			return "Liste de race in�xistante";
		case NO_RACE :
			return "La race n'existe pas";
		default : 
			return "";
		}
	}
}

