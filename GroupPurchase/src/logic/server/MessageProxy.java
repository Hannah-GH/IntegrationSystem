package logic.server;

import assignment3.ShortMessageSender;
import jms.MessageSender;
import launcher.Application;
import launcher.Sender;

/**
 * 消息服务的代理于远程消息系统交互，接了ShortMessageSender接口，给本地的GPMS提供服务
 *
 * @author luMinO
 */
public class MessageProxy implements ShortMessageSender {
    private MessageSender sender;

    public MessageProxy() throws Exception {
        sender = new MessageSender();
    }

    @Override
    public boolean sendMessage(String mobile, String content) {
        boolean result = ((Sender) Application.ctx.getBean("sender")).sendMessage(mobile, content);

        return result;
    }

}
