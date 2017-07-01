package ws.gpms;

import assignment3.GroupPurchaseManagementSystem;
import util.Logger;
import util.SideType;

import javax.jws.WebService;

@WebService(endpointInterface = "ws.gpms.GPMSPort")
public class GPMSImpl implements GPMSPort {
	private GroupPurchaseManagementSystem gpm;

	@Override
	public boolean confirmPurchase(String sellerSecretKey, String confirm) {
		Logger.log(SideType.团购服务器, "收到购买确认请求，验证确认码", this);
		boolean result = gpm.confirmPurchase(sellerSecretKey, confirm);
		
		return result;
	}

	@Override
	public boolean publishGroupPurchaseItem(String sellerSecretKey,
			String productName, String introduction, double price, int limit) {
		Logger.log(SideType.团购服务器, "收到发布新团购请求", this);
		
		if( gpm != null ){
			boolean result = gpm.publishGroupPurchaseItem(sellerSecretKey, productName, introduction, price, limit);
			
			return result;
		}else{
			Logger.log(SideType.团购服务器, "GPMS为空！", this);
			
			return false;
		}
		
	}

	public void setGPMS(GroupPurchaseManagementSystem gpm) {
		this.gpm = gpm;
	}

}
