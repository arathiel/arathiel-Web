package util.armurerie;

public class ArmurerieParam {

	public static final String 	FACADE_SERVICE 	= "ejb:/arathiel-EJB/FacadeService!clientServeur.IFacadeService";
	public static final String 	FORGE_SERVICE 	= "ejb:/arathiel-EJB/ForgeArme!clientServeur.IForge";
	public static final String 	destinationName = "/ConnectionFactory";
	public static final String 	JMS_QUEUE_JNDI	 = "/jboss/exported/jms/queue/TestDdevilQueue"; 
	public static final String 	JMS_USERNAME	 = "jmsuser";       
	public static final String 	JMS_PASSWORD	 = "jmsuser@123";

}
