package banksystem;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoebegl on 2017/7/6.
 */
@WebService(endpointInterface = "banksystem.Bank")
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BankImpl implements Bank {

    List<Record> localRecord = new ArrayList<>();

    @Override
    public MyList listHistory(String account, String password) {
        ArrayList<Record> list = new ArrayList<>();
        for(Record r : localRecord) {
            if(r.getFrom().equals(account))
                list.add(r);
        }
        MyList result = new MyList();
        result.setHistoryList(list);
        return result;
    }

    @Override
    public boolean transfer(String account, String password, String target, double amount) {
        Record record = new Record(account,target,amount);
        localRecord.add(record);
        System.out.println("从"+account+"到"+target+"转账"+amount+"元");
        return true;
    }
}
