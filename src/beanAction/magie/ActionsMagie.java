package beanAction.magie;

import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import beanAction.ApplicationSupport;
import clientServeur.IFacadeService;


public class ActionsMagie extends ApplicationSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private static IFacadeService fService;
		
	
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
//		init();
//		
//		setListeRace(fService.listeToutesRaces());		
		return SUCCESS;
	}
	
	
	public String creer() {
		init();
		//TODO
		return SUCCESS;
	}
	
	
	
	public String editer() {
		init();

	
		
		return SUCCESS;
	}
	

	
}
