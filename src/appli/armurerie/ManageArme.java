package appli.armurerie;

import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import clientServeur.IArme;
import clientServeur.IFacadeService;
import clientServeur.IForge;
import entity.armurerie.Arme;
import entity.armurerie.ArmeJoueur;
import entity.armurerie.Joueur;
import entity.race_bonus_carac.race.Race;
import exception.armurerie.ServiceOlivBException;
import util.armurerie.ArmurerieParam;
/**
 * Classe ManageArme servant de lien entre les BeanAction et la couche Service pour les Armes
 * @author OlivB
 *
 */
public class ManageArme {

	private IFacadeService 	serviceArme;
	private IForge 			forgeArme;
	private IArme 			arme;

	

	public ManageArme() {
		super();
	}

	//Méthode d'initialisation du contexte
	public void init() {
		Context context;
		try {
			context 	= new InitialContext();
			serviceArme = (IFacadeService) 	context.lookup(ArmurerieParam.FACADE_SERVICE);
			forgeArme 	= (IForge) 			context.lookup(ArmurerieParam.FORGE_SERVICE);
		}
		catch (NamingException e) { e.printStackTrace(); }
	}

	//=================méthodes d'appel vers la couche service pour affichage==========================

	public List<Race> afficheRaces() throws ServiceOlivBException {
		init();
		return serviceArme.listeToutesRaces();

	}
	public List<Arme> afficheArmes() throws ServiceOlivBException {
		init();
		return serviceArme.listerArmes();
	}

	public void createArme(Arme armeDto, List<String> raceArme) throws ServiceOlivBException {
		init();
		arme = forgeArme.creerArme(armeDto.getNom(), armeDto.getEncombrement(), armeDto.getPrix(), armeDto.getMonnaie());
		System.out.println("**************************************************************");
		serviceArme.createArme(arme, raceArme);	
	}

	public void modif(Arme armeDto, List<String> raceArme) throws ServiceOlivBException {
		init();
		arme = forgeArme.creerArme(armeDto.getIdArme(), armeDto.getNom(), armeDto.getEncombrement(), armeDto.getPrix(), armeDto.getMonnaie());
		serviceArme.modifArme(arme, raceArme);

	}

	public void suppr(Arme armeDto) throws ServiceOlivBException {
		init();
		arme = forgeArme.creerArme(armeDto.getIdArme(), armeDto.getNom(), armeDto.getEncombrement(), armeDto.getPrix(), armeDto.getMonnaie());
		serviceArme.supprArme(arme);
	}

	public List<Arme> afficheArmesRace() throws ServiceOlivBException {
		init();
		return serviceArme.listerArmesRace();
	}

	public List<Joueur> afficheJoueurs() throws ServiceOlivBException {
		init();
		return serviceArme.listerJoueurs();
	}

	public void ajouteArmeJoueur(ArmeJoueur armeJoueurDto, int joueurId, int armeId, String etat) throws ServiceOlivBException {
		init();
		if ( armeJoueurDto == null) armeJoueurDto = new ArmeJoueur();
		serviceArme.createArmeJoueur(armeJoueurDto, joueurId, armeId, etat);

	}

}
