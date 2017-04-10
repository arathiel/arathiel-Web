//package beanAction.passion;
//
//import javax.jms.JMSException;
//import javax.jms.Queue;
//import javax.jms.QueueConnection;
//import javax.jms.QueueConnectionFactory;
//import javax.jms.QueueSender;
//import javax.jms.QueueSession;
//import javax.jms.Session;
//import javax.jms.TextMessage;
//import javax.naming.Context;
//import javax.naming.InitialContext;
//
//public class ClientMessage {
//
//	private static QueueConnection	connection 	= null;
//	private static QueueSession 	session 	= null;
//	private static QueueSender     sender		= null;
//
//	public static void envoyer(String message) {
//
//		final String destinationName = "/ConnectionFactory";
//		final String JMS_QUEUE_JNDI	 = "/jboss/exported/jms/queue/TestDMQueue"; 
//		final String JMS_USERNAME	 = "jmsuser";       
//		final String JMS_PASSWORD	 = "jmsuser@123";  
//
//		try {         
//			Context ctx = new InitialContext();
//			QueueConnectionFactory connectionFactory = (QueueConnectionFactory) ctx.lookup(destinationName); 
//
//			connection  = connectionFactory.createQueueConnection(JMS_USERNAME, JMS_PASSWORD); 
//			session 	= connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
//			Queue queue = (Queue) ctx.lookup(JMS_QUEUE_JNDI);
//			sender 	= session.createSender(queue);
//			connection.start();
//
//			TextMessage msg = null;
//			
//				msg = session.createTextMessage("Message du sender : " + message);
//				sender.send(msg);			
//
//
//		}
//		catch (Exception exc) {
//			exc.printStackTrace();
//		}
//		finally {         
//
//
//			if (connection != null)   {
//				try {
//					connection.close();
//				} catch (JMSException e) {                    
//					e.printStackTrace();
//				}
//			} 
//		}
//
//	}
//	
//}
