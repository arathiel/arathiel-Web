package clientServeur.race_bonus_carac.userException;

public enum UserExceptionRBCMsg {
	
	
	
	PB_RECH_RACE ("Un probl�me inconnu a emp�ch� la recherche de cette race d'aboutir"),
	PB_INSERT_RACE ("L'enregistrement de la race n'a pas pu aboutir pour des raisons inconnues"),
	PB_UPDATE_RACE ("La modification de la race n'a pas pu aboutir pour des raisons inconnues"),
	PB_DELETE_RACE ("La suppression de la race n'a pas pu aboutir pour des raisons inconnues"),
	
	RACE_NO_EXIST ("La race recherch�e est inconnue"),
	RACE_NOM_INVALIDE ("Le nom de race contient des caract�res non autoris�s"),
	
	DOUBLON_NOM_RACE ("Une race avec ce nom existe d�j�"),
	DOUBLON_ID_RACE ("Une race avec cet Id existe d�j�"),
	
	INSERT_RACE_OK ("La race a �t� correctement sauvegard�e"),
	DELETE_RACE_OK ("La race a �t� correctement supprim�e"),
	UPDATE_RACE_OK ("La race a �t� correctement mise � jour"),
	
	BONUS_NO_EXISTS ("Le bonus recherch� est inconnu"),
	DOUBLON_BONUS ("Ce bonus existe d�j�"),
	BONUS_NULL ("Ce bonus est null"),
	ERR_VAL_BONUS ("Ce bonus poss�de une valeur incorrecte"),
	
	PB_INSERT_BONUS ("Probleme d'insert de bonus"),
	PB_DELETE_BONUS ("Probleme de delete de bonus");
	
	
	private String msg;
	
	private UserExceptionRBCMsg(String msg) {
		this.setMsg(msg);		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
