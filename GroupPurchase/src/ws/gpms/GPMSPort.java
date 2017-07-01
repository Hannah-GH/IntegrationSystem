package ws.gpms;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface GPMSPort {
	@WebMethod
	@WebResult(name="result")
	boolean confirmPurchase(
            @WebParam(name = "SecretKey")
                    String sellerSecretKey,
            @WebParam(name = "confirm")
                    String confirm);

	
	@WebMethod
	@WebResult(name="result")
	boolean publishGroupPurchaseItem(
            @WebParam(name = "SecretKey")
                    String sellerSecretKey,
            @WebParam(name = "productName")
                    String productName,
            @WebParam(name = "introduction")
                    String introduction,
            @WebParam(name = "price")
                    double price,
            @WebParam(name = "limit")
                    int limit);
}
