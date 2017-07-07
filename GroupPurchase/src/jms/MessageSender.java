package jms;

import util.ConfigManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class MessageSender {
	//private ConnectionFactory connectionFactory;
	//private Destination dest;

	public MessageSender() throws Exception {
//		Context ctx = getInitialContext();
//
//		connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
//		dest = (Destination) ctx.lookup(ConfigManager.getValue("queuename"));
	}

	public boolean send(String target, String msg) {
//		try {
//			Connection connection = connectionFactory.createConnection();
//			Session session = connection.createSession(false,
//					Session.AUTO_ACKNOWLEDGE);
//			MessageProducer sender = session.createProducer(dest);
//
//			sender.setDeliveryMode(DeliveryMode.PERSISTENT);
//			sender.setTimeToLive(1000);
//
//			TextMessage message = session.createTextMessage();
//			message.setStringProperty("Contype", "txt");
//			message.setText(target + "&" + msg);
//
//			sender.send(message);
//			session.close();
//			connection.close();
//
//			return true;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		return true;
	}

	private Context getInitialContext() {
		Context ctx = null;

//		try {
//			Properties props = new Properties();
//			props.put(Context.INITIAL_CONTEXT_FACTORY,
//					"org.jnp.interfaces.NamingContextFactory");
//			props.put(Context.PROVIDER_URL, ConfigManager.getValue("jnpuri"));
//
//			ctx = new InitialContext(props);
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}

		return ctx;
	}

}
