package beanAction.races;

import java.util.ArrayList;

import javax.naming.InitialContext;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;
import entity.race_bonus_carac.race.Race;


public class ActionsRace extends ApplicationSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static IFacadeService fService;
	
	private ArrayList<Race> listeRace = new ArrayList<Race>();

	
	@Override
	public String execute() throws Exception {
		InitialContext ctx = new InitialContext();
		fService = (IFacadeService)  ctx.lookup("ejb:/arathiel-EJB/FacadeService!clientServeur.IFacadeService");
		
		setListeRace(fService.listeToutesRaces());
		
		return SUCCESS;	
	}


	public ArrayList<Race> getListeRace() {
		return listeRace;
	}


	public void setListeRace(ArrayList<Race> listeRace) {
		this.listeRace = listeRace;
	}

}
