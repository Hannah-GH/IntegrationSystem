package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * 供客户端调用的远程接口, 里面的方法实际上就是已经写好的GPMS类的方法接口，这里只不过是复制了一下来实现RMI而已
 * @author luMinO
 *
 */
public interface RemoteGPMSService extends Remote{
	/**
	 * 获得所有的团购信息
	 * @return
	 * @throws RemoteException
	 */
	List<GPISerilized> listGroupPurchase() throws RemoteException;
	
	/**
	 * 提交团购购买请求
	 * @param itemId
	 * @param bankAccount
	 * @param password
	 * @param phone
	 * @return
	 * @throws RemoteException
	 */
	boolean submitPurchase(String itemId, String bankAccount, String password, String phone) throws RemoteException;
}
