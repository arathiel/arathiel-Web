package beanAction.races;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import clientServeur.race_bonus_carac.userException.UserExceptionRBC;
import entity.competence.Competence;
import entity.race_bonus_carac.bonus.Bonus;
import entity.race_bonus_carac.caracteristique.Caracteristique;
import entity.race_bonus_carac.race.Race;
import entity.trait.Trait;


public class ActionsRacePages extends ApplicationSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static IFacadeService fService;
	
	private ArrayList<Race> listeRace = new ArrayList<Race>();
	private ArrayList<Caracteristique> listeCarac= new ArrayList<Caracteristique>();
	private ArrayList<Competence> listeComp= new ArrayList<Competence>();
	private ArrayList<Trait> listeTrait= new ArrayList<Trait>();
	private ArrayList<Bonus> listeBonus = new ArrayList<Bonus>();
	private String selectCarac;
	private String selectTrait;
	private String selectComp;
	private String chkAcad;
	private String nomRace;
	private String idRace;
	private Race race;
	private String message;
	
	
	
	
	public void init() {
		InitialContext ctx;
		try {
			ctx = new InitialContext();
			fService = (IFacadeService)  ctx.lookup("ejb:/arathiel-EJB/FacadeService!clientServeur.IFacadeService");
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public String execute() {
		return SUCCESS;
	}

	
	public String lister() {
		init();		
		setListeRace(fService.listeToutesRaces());
		return SUCCESS;
	}
	
	
	public String creer() {
		init();
		setListeCarac(fService.listeCarac());
		setListeTrait(fService.consulterListTrait());
		setListeComp(fService.listeToutesComp());
		return SUCCESS;
	}
	
	
	
	public String editer() {
		init();
		setListeCarac(fService.listeCarac());
		setListeTrait(fService.consulterListTrait());
		setListeComp(fService.listeToutesComp());

		if (this.nomRace != null) {
			try {
				setRace(fService.rechRaceParNom(this.nomRace));
				this.listeBonus = (ArrayList<Bonus>) race.getListeBonus();
				this.nomRace = race.getNom();
				this.idRace = String.valueOf(race.getId());
				this.chkAcad = String.valueOf(race.isDispo());
				
			} catch (UserExceptionRBC e) {
				setMessage(e.getMessage());
			}
		}
		
		return SUCCESS;
	}
	

	
	public ArrayList<Race> getListeRace() {
		return listeRace;
	}


	public void setListeRace(ArrayList<Race> listeRace) {
		this.listeRace = listeRace;
	}


	public ArrayList<Caracteristique> getListeCarac() {
		return listeCarac;
	}


	public void setListeCarac(ArrayList<Caracteristique> listeCarac) {
		this.listeCarac = listeCarac;
	}


	public ArrayList<Competence> getListeComp() {
		return listeComp;
	}


	public void setListeComp(ArrayList<Competence> listeComp) {
		this.listeComp = listeComp;
	}


	public ArrayList<Trait> getListeTrait() {
		return listeTrait;
	}


	public void setListeTrait(ArrayList<Trait> listeTrait) {
		this.listeTrait = listeTrait;
	}


	public String getSelectCarac() {
		return selectCarac;
	}


	public void setSelectCarac(String selectCarac) {
		this.selectCarac = selectCarac;
	}


	public String getSelectTrait() {
		return selectTrait;
	}


	public void setSelectTrait(String selectTrait) {
		this.selectTrait = selectTrait;
	}


	public String getSelectComp() {
		return selectComp;
	}


	public void setSelectComp(String selectComp) {
		this.selectComp = selectComp;
	}


	public String getChkAcad() {
		return chkAcad;
	}


	public void setChkAcad(String chkAcad) {
		this.chkAcad = chkAcad;
	}


	public ArrayList<Bonus> getListeBonus() {
		return listeBonus;
	}


	public void setListeBonus(ArrayList<Bonus> listeBonus) {
		this.listeBonus = listeBonus;
	}


	public String getNomRace() {
		return nomRace;
	}


	public void setNomRace(String nomRace) {
		this.nomRace = nomRace;
	}


	public String getIdRace() {
		return idRace;
	}


	public void setIdRace(String idRace) {
		this.idRace = idRace;
	}


	public Race getRace() {
		return race;
	}


	public void setRace(Race race) {
		this.race = race;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}

}
