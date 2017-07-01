package message;

import assignment3.ShortMessageSender;
import assignment3.ShortMessageSenderFactory;
import util.Logger;
import util.SideType;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MessageHandler implements MessageListener{
	private ShortMessageSender sender = ShortMessageSenderFactory.createShortMessageSender();

	@Override
	public void onMessage(Message msg) {
		try {
			Logger.log(SideType.消息服务器, "已收到客户端发来的消息", this);
			
			String message = ((TextMessage)msg).getText();
			
			String[] parts = message.split("&");
			
			if( parts==null || parts.length<2 )
				throw new Exception("消息为：" + message);
			
			String mobile = parts[0];
			String content = parts[1];
			
			//发给本地真正的消息处理类
			sender.sendMessage(mobile, content);
			
		} catch (Exception e) {
			Logger.log(SideType.消息服务器, "消息处理异常", e, this);
		}
	}
	
}