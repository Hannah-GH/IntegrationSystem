package launcher;

import assignment3.BankSystem;
import assignment3.GroupPurchaseManagementSystem;
import assignment3.GroupPurchaseManagementSystemFactory;
import assignment3.ShortMessageSender;
import logic.server.SystemLinker;
import rmi.RemoteGPMSImpl;
import rmi.RemoteGPMSService;
import util.ConfigManager;
import util.Logger;
import util.SideType;
import ws.gpms.GPMSImpl;

import javax.xml.ws.Endpoint;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 服务器端启动器，请务必在启动客户端之前启动，因为使用了RMI客户端要调用
 * @author luMinO
 *
 */
public class ServerLauncher {
	private SystemLinker linker = new SystemLinker();
	
	private GroupPurchaseManagementSystem gpms;

	public static void main(String[] args) {
		new ServerLauncher().launch();
	}

	public void launch() {
		//获取创建管理系统必要的外部系统，这里获取的实际上是远程系统的代理
		BankSystem bank = linker.getBankSystem();
		ShortMessageSender messageSystem = linker.getMessageSystem();
		
		//创建团购管理系统
		//【注意 GroupPurchaseManagementSystem团购管理系统 将简写为GPMS!】
		gpms = GroupPurchaseManagementSystemFactory.createGroupPurchaseManagementSystem(messageSystem, bank);
		
		//预先放置一点数据进去，零售客户端也是通过这个方法来发布商品的
		gpms.publishGroupPurchaseItem("_seller_a_s3cret_k3y", "长矛", "捡的", 200, 120);
		
		//设置RMI，这部分功能将提供给 【团购客户端】 来使用
		setUpRMI(gpms);
		
		//RMI的搭建以上已经完成，下面开始搭建WebService
		
		//创建团购系统的WebService实现，这部分功能将提供给 【零售商客户端】 来使用
		GPMSImpl gpmsWS = new GPMSImpl();
		gpmsWS.setGPMS(gpms);
		
		//发布WSDL
		Endpoint.publish(ConfigManager.getValue("gpmswsdl"), gpmsWS);
		
		Logger.log(SideType.团购服务器, "团购服务器已启动", this);
	}

	
	/**
	 * 搭建RMI的服务，该服务最终调用本地的GPMS完成功能再返回
	 * @param core 本地GPMS系统，客户端通过RMI调用方法的时候实际上调用到的就是服务器上的这个东西
	 */
	private void setUpRMI(GroupPurchaseManagementSystem core) {
		try {
			//将本地的GPMS对象通过RMI暴露出来
			RemoteGPMSService service = new RemoteGPMSImpl(core);
			
			//发布RMI的常规套路
			try{
				String portStr = ConfigManager.getValue("rmiport");
				int port = Integer.parseInt(portStr);
				LocateRegistry.createRegistry(port);
				Naming.rebind(ConfigManager.getValue("rmi"), service);
			}catch(Exception e){
				Logger.log(SideType.团购服务器, "获取并使用rmi端口失败！", this);
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
