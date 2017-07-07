package launcher;

import assignment3.ShortMessageSender;
import jms.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jmx.JmxException;
import org.springframework.stereotype.Component;

/**
 * Created by dora on 2017/7/2.
 */

@Component
public class Sender implements ShortMessageSender {

    @Autowired
    private JmsTemplate jmsTemplate;

    public boolean sendMessage(String to, String body){
        System.out.println("向"+to+"发送一条短信：验证码是"+body);
        try {
            jmsTemplate.convertAndSend("mailbox", new Email(to, body));
        }catch (JmxException | JmsException e) {
            e.printStackTrace();
//            return false;
        }
        return true;
    }
}
