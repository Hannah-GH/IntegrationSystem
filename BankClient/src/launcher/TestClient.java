package launcher;

import assignment3.BankSystem;
import banksystem.ArrayList;
import banksystem.Bank;
import banksystem.BankImplService;

/**
 * Created by phoebegl on 2017/7/6.
 */
public class TestClient {

    public static void main(String[] args){
        // 获取service
        Bank bankPort = new BankImplService().getBankImplPort();
        BankSystem bank = TestClient.getBankSystem();
        System.out.print(bank.transfer("buyer","123","retail",2000));
    }

    public static BankSystem getBankSystem(){
        BankSystem bank = null;
        try{
            Bank bankPort = new BankImplService().getBankImplPort();
            bank = new MyBank(bankPort);
            return bank;
        }catch(Exception e){
            System.out.println("无法与银行服务器建立WSDL连接！请检查银行服务是否开启");
            System.exit(0);
        }
        return bank;
    }
}
