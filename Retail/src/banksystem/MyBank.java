package banksystem;

import banksystem.Bank;
import banksystem.BankImplService;
import banksystem.MyList;
import banksystem.Record;

import java.util.ArrayList;

/**
 * Created by phoebegl on 2017/7/7.
 */
public class MyBank {

    private static Bank bank;

    public static Bank getBank(){
        if( bank == null )
            bank = new BankImplService().getBankImplPort();
        return bank;
    }

}
