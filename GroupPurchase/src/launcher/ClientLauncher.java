package launcher;

import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseWeb;
import logic.client.GPMSProxy;
import rmi.RemoteGPMSService;
import util.ConfigManager;

import java.rmi.Naming;

/**
 * 客户端启动器
 * 
 * @author luMinO
 * 
 */
public class ClientLauncher {

	public static void main(String[] args){
		new ClientLauncher().launch();
	}

	public void launch(){
		// 获取RMI接口，用这个RMI接口生成本地的GPMS实现
		RemoteGPMSService remoteService;
		try {
			remoteService = (RemoteGPMSService) Naming.lookup(ConfigManager.getValue("rmi"));
			
			GroupPurchaseManagementSystem gpms = new GPMSProxy(remoteService);

			GroupPurchaseWeb client = new GroupPurchaseWeb();

			// launch方法只接受一个gpms接口，所以上面搞那么复杂没办法，只能这么写
			client.launch(gpms);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
