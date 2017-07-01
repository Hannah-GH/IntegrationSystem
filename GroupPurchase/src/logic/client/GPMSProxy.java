package logic.client;

import assignment3.GroupPurchaseItem;
import assignment3.GroupPurchaseManagementSystem;
import rmi.GPISerilized;
import rmi.RemoteGPMSService;

import java.rmi.RemoteException;
import java.util.List;

/**
 * 客户端使用的GroupPurchaseManagementSystem实现，内部通过RMI调用服务器端实际的功能实现
 * @author luMinO
 *
 */
public class GPMSProxy implements GroupPurchaseManagementSystem{
	private RemoteGPMSService service;
	
	public GPMSProxy(RemoteGPMSService remoteService){
		this.service = remoteService;
	}

	@Override
	public boolean submitPurchase(String itemId, String bankAccount, String password,
			String phone) {
		boolean result = false;
		
		try {
			result =  service.submitPurchase(itemId, bankAccount, password, phone);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<GroupPurchaseItem> listGroupPurchase(){
		try {
			List<GPISerilized> serilizedList = service.listGroupPurchase();
			
			return GPISerilized.deserilizeInList(serilizedList);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean publishGroupPurchaseItem(String arg0, String arg1,
			String arg2, double arg3, int arg4) {
		//零售商的功能，不实现
		return false;
	}

	@Override
	public boolean confirmPurchase(String arg0, String arg1) {
		//零售商的功能，不实现
		return false;
	}

}
