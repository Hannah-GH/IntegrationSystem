import banksystem.BankImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by phoebegl on 2017/7/6.
 */
public class BankLauncher {

    public static void main(String[] args) {
        Endpoint.publish("http://192.168.0.105:8081/banksystem", new BankImpl());
        System.out.println("银行系统启动成功!");
    }

}
