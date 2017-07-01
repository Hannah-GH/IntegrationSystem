package launcher;

import bank.BankImpl;
import util.ConfigManager;
import util.Logger;
import util.SideType;

import javax.xml.ws.Endpoint;

public class BankLauncher {

	public static void main(String[] args) {
		new BankLauncher().launch();
		
	}

	public void launch() {
		String url = ConfigManager.getValue("bankwsdl");
		
		if( url == null ){
			Logger.log(SideType.银行服务器, "找不到银行服务器的配置！", this);
		}
		
		Endpoint.publish(url, new BankImpl());
		
		Logger.log(SideType.银行服务器, "银行端Web Service启动", this);
	}
}
