package rmi;

import assignment3.GroupPurchaseItem;
import assignment3.GroupPurchaseManagementSystem;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * RMI远程接口的实现，实际上就是把远程RMI的调用转给本地已经存在的GPMS来完成任务
 * 但是比较麻烦的是，个别方法（listGroupPurchase）所使用到的类（GroupPurchaseIte）由于要通过RMI传输，因此必须要实现Serializable接口
 * 可类库中实现的类（GroupPurchaseItem）并没有实现这个接口！
 * 因此只能使用GPISerilized类复制其所有字段值再进行传输 - -#
 * @author luMinO
 *
 */
public class RemoteGPMSImpl extends UnicastRemoteObject implements RemoteGPMSService {
	private GroupPurchaseManagementSystem core;
	
	public RemoteGPMSImpl(GroupPurchaseManagementSystem core) throws RemoteException{
		this.core = core;
	}

	@Override
	public List<GPISerilized> listGroupPurchase() throws RemoteException{
		List<GroupPurchaseItem> items =  core.listGroupPurchase();
		
		List<GPISerilized> returnList = GPISerilized.serilizeInList(items);
		return returnList;
	}

	@Override
	public boolean submitPurchase(String itemId, String bankAccount,
			String password, String phone) throws RemoteException{
		boolean result = core.submitPurchase(itemId, bankAccount, password, phone);
		
		return result;
	}

}
