package appli.armurerie;

import java.util.List;

import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
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

	private IFacadeService 			serviceArme;
	private IForge 					forgeArme;
	private IArme 					arme;
	private Arme					armeRech;
	private String 					message;
	private static QueueConnection	connection 	= null;
	private static QueueSession 	session 	= null;
	private static QueueSender     	sender		= null;

	

	public ManageArme() {
		super();
	}

	//Méthode d'initialisation du contexte
	public void init() {
		Context context;
		final String destinationName = "/ConnectionFactory";
		final String JMS_QUEUE_JNDI	 = "/jboss/exported/jms/queue/TestDdevilQueue"; 
		final String JMS_USERNAME	 = "jmsuser";       
		final String JMS_PASSWORD	 = "jmsuser@123";
		try {
			context 	= new InitialContext();
			serviceArme = (IFacadeService) 	context.lookup(ArmurerieParam.FACADE_SERVICE);
			forgeArme 	= (IForge) 			context.lookup(ArmurerieParam.FORGE_SERVICE);
		}
		catch (NamingException e) {
			e.printStackTrace(); 
			}
	try {         
		context = new InitialContext();
		QueueConnectionFactory connectionFactory = (QueueConnectionFactory) context.lookup(destinationName); 
		connection  = connectionFactory.createQueueConnection(JMS_USERNAME, JMS_PASSWORD); 
		session 	= connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue = (Queue) context.lookup(JMS_QUEUE_JNDI);
		sender 	= session.createSender(queue);
		connection.start();
	} 
	catch (Exception exc) {
		exc.printStackTrace();
	}
}

//=================méthodes d'appel vers la couche service pour affichage==========================

public List<Race> afficheRaces() throws ServiceOlivBException {
	init();
	return serviceArme.listerRaces();

}
public List<Arme> afficheArmes() throws ServiceOlivBException {
	init();
	return serviceArme.listerArmes();
}

public void createArme(Arme armeDto, List<String> raceArme) throws ServiceOlivBException, JMSException  {
	init();
	arme = forgeArme.creerArme(armeDto.getNom(), armeDto.getEncombrement(), armeDto.getPrix(), armeDto.getMonnaie());
	serviceArme.createArme(arme, raceArme);	
	message = "Trop fort, une nouvelle arme !!!";
	envoyerEJBMessage(message);			
}



public void modif(Arme armeDto, List<String> raceArme) throws ServiceOlivBException, JMSException {
	init();
	arme = forgeArme.creerArme(armeDto.getIdArme(), armeDto.getNom(), armeDto.getEncombrement(), armeDto.getPrix(), armeDto.getMonnaie());
	serviceArme.modifArme(arme, raceArme);
	message = "Trop fort, une arme modifiée!!!";
	envoyerEJBMessage(message);	

	
}

public void suppr(Arme armeDto) throws ServiceOlivBException, JMSException {
	init();
	arme = forgeArme.creerArme(armeDto.getIdArme(), armeDto.getNom(), armeDto.getEncombrement(), armeDto.getPrix(), armeDto.getMonnaie());
	serviceArme.supprArme(arme);
	message = "Pourquoi supprimer une arme !!!";
	envoyerEJBMessage(message);	
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

//méthode d'envoie message EJB Message
private void envoyerEJBMessage(String message) throws JMSException {
	TextMessage txtMessage;
	try {
		txtMessage = session.createTextMessage();
		txtMessage.setText(message);
		sender.send(txtMessage);
		
	} catch (JMSException e) {
		e.printStackTrace();
	}
	
	sender.close();
	session.close();
	connection.close();		
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public Arme getArmeRech() {
	return armeRech;
}

public void setArmeRech(Arme armeRech) {
	this.armeRech = armeRech;
}

}
