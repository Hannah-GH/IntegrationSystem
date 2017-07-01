package bank;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.List;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface BankPort {
	@WebMethod
	@WebResult(name="result")
	boolean transfer(
            @WebParam(name = "account")
                    String account,
            @WebParam(name = "password")
                    String password,
            @WebParam(name = "target")
                    String target,
            @WebParam(name = "amount")
                    double amount);
	
	@WebMethod
	@WebResult(name="recordList")
	List<Record> listHistory(
            @WebParam(name = "account")
                    String account,
            @WebParam(name = "password")
                    String password);
}
