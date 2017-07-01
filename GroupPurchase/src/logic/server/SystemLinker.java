package logic.server;

import assignment3.BankSystem;
import assignment3.ShortMessageSender;
import assignment3.ShortMessageSenderFactory;
import util.Logger;
import util.SideType;
import ws.bank.BankImplService;
import ws.bank.BankPort;

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
	public BankSystem getBankSystem(){
		if( bank == null ){
			try{
				BankPort bankPort = new BankImplService().getBankImplPort();
				BankSystem bank = new BankProxy(bankPort);
				return bank;
			}catch(Exception e){
				Logger.log(SideType.团购服务器, "无法与银行服务器建立WSDL连接！请检查银行服务是否开启", e, this);
				//没有什么替代方案，只能停止系统了
				Logger.log(SideType.团购服务器, "启动终止", this);
				System.exit(0); 
			}
		}
		
		return bank;
	}
}
