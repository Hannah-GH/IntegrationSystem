package logic.server;

import assignment3.BankSystem;
import assignment3.ShortMessageSender;
import assignment3.ShortMessageSenderFactory;
import util.Logger;
import util.SideType;
import ws.banksystem.Bank;
import ws.banksystem.BankImplService;

import java.net.URL;

/**
 * 用来建立系统和外部系统的连接，其实就是远程系统代理的一个获取类
 * @author luMinO
 *
 */
public class SystemLinker {
	//单例
	private ShortMessageSender sender;
	private BankSystem bank;
	
	/**
	 * 获取消息系统的远程代理
	 * @return
	 */
	public ShortMessageSender getMessageSystem(){
		if( sender == null ){
			try{
				sender = new MessageProxy();
			}catch(Exception e){
				Logger.log(SideType.团购服务器, "连接消息服务器出错！（是否没有启动JBoss或者没有使用 -b 参数绑定正确的IP地址？）将在本地建立消息服务！", this);
				//如果不能连上消息服务器，那么就在本地生成一个再返回
				//相当于就把消息服务器架在本地而不是远程了
				sender = ShortMessageSenderFactory.createShortMessageSender();
			}
		}
		
		return sender;
	}
	
	/**
	 * 获取银行系统的远程代理
	 * @return
	 */
	public static BankSystem getBankSystem(){
		BankSystem bank = null;
		try{
			URL url = new URL("http://192.168.43.49:8081/banksystem?wsdl");
			Bank bankPort = new BankImplService(url).getBankImplPort();
			bank = new MyBank(bankPort);
			return bank;
		}catch(Exception e){
			System.out.println("无法与银行服务器建立WSDL连接！请检查银行服务是否开启");
			System.exit(0);
		}
		return bank;
	}
}
