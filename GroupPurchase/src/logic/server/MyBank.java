package logic.server;

import assignment3.BankSystem;
import ws.banksystem.Bank;

/**
 * Created by phoebegl on 2017/7/6.
 */
public class MyBank implements BankSystem {

    private Bank mybank;

    public MyBank(Bank bank) {
        this.mybank = bank;
    }

    @Override
    public boolean transfer(String s, String s1, String s2, double v) {
        return mybank.transfer(s,s1,s2,v);
    }
}
