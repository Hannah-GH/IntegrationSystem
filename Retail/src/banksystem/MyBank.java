package banksystem;

import banksystem.Bank;
import banksystem.BankImplService;
import banksystem.MyList;
import banksystem.Record;

import java.net.URL;
import java.util.ArrayList;

/**
 * Created by phoebegl on 2017/7/7.
 */
public class MyBank {

    private static Bank bank;

    public static Bank getBank(){
        if( bank == null ) {
            try{
                URL url = new URL("http://192.168.0.105:8081/banksystem?wsdl");
                bank = new BankImplService(url).getBankImplPort();
            }catch(Exception e){
                System.out.println("无法与银行服务器建立WSDL连接！请检查银行服务是否开启");
                System.exit(0);
            }
        }
        return bank;
    }

}
