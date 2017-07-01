package logic.server;

import assignment3.BankSystem;
import util.Logger;
import util.SideType;
import ws.bank.BankPort;

/**
 * 银行服务的代理于远程银行系统交互，接了BankSystem接口，给本地的GPMS提供服务
 * @author luMinO
 *
 */
public class BankProxy implements BankSystem{
	private BankPort bankPort;

	public BankProxy(BankPort bankPort) {
		this.bankPort = bankPort;
	}

	@Override
	public boolean transfer(String account, String password, String target, double amount) {
		Logger.log(SideType.团购服务器, "请求转账！", this);
		
		boolean result = bankPort.transfer(account, password, target, amount);
		
		return result;
	}

}
