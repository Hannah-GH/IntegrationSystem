package banksystem;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;

/**
 * Created by phoebegl on 2017/7/6.
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface Bank {

    @WebMethod
    MyList listHistory(String account, String password);

    @WebMethod
    boolean transfer(String account,String password,String target,double amount);
}
