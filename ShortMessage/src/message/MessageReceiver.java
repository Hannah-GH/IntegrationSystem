package message;

import util.ConfigManager;
import util.Logger;
import util.SideType;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;


public class MessageReceiver {

	public void launch() {
		try{
			//创建初始化上下文
			Context ctx = getInitialContext();
			//连接工厂
			ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ConnectionFactory");
			//消息目的地
			Destination dest = (Destination) ctx.lookup(ConfigManager.getValue("queuename"));
			
			//创建连接和会话
			Connection connection = connectionFactory.createConnection();
			connection.start();
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			//进入信息的接收
			MessageConsumer receiver = session.createConsumer(dest);
			
			//异步接收消息
			receiver.setMessageListener(new MessageHandler());
			
			Logger.log(SideType.消息服务器, "消息服务器已启动", this);
			
			for( int i=0; i<100; i++ ){
				Thread.sleep(1000);
			}
			
			session.close();
			connection.close();
			
		}catch(Exception e){
			Logger.log(SideType.消息服务器, "启动消息服务器失败, 放弃启动（是否没有启动JBoss或者没有使用 -b 参数绑定正确的IP地址？）", e, this);
		}
	}
	
	
	private Context getInitialContext() {
		Context ctx = null;

		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"org.jnp.interfaces.NamingContextFactory");
			props.put(Context.PROVIDER_URL, ConfigManager.getValue("jnpuri"));
			
			ctx = new InitialContext(props);
		} catch (NamingException e) {
			Logger.log(SideType.消息服务器, "Naming异常", e, this);
		}
		
		return ctx;
	}

}


