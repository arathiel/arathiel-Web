package beanAction.races;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

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
		//TODO
		return SUCCESS;
	}
	
	
	
	public String editer() {
		//TODO
		return SUCCESS;
	}
	
	
	
	
	
	public ArrayList<Race> getListeRace() {
		return listeRace;
	}


	public void setListeRace(ArrayList<Race> listeRace) {
		this.listeRace = listeRace;
	}



}
