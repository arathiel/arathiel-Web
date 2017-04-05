package util.armurerie;

public enum Etat {
	
	NEUF ("neuf"),
	USAGE ("usage"),
	CASSE ("casse");
	
	private String etat;

	private Etat(String etat) {
		this.etat = etat;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public Etat convertEtat(String etat) {
		Etat etatEtat = Etat.valueOf(etat);
		return etatEtat;
	}
	
	
}
