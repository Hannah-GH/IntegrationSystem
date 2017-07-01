package bank;

import util.Logger;
import util.SideType;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import java.util.LinkedList;
import java.util.List;

@WebService(endpointInterface = "bank.BankPort")
@SOAPBinding(style= Style.DOCUMENT)
public class BankImpl implements BankPort{
	//实现本地的转账记录
	private List<Record> records = new LinkedList<Record>();

	@Override
	public boolean transfer(String account, String password, String target,
			double amount) {
		Logger.log(SideType.银行服务器, "进行转账！To "+target+": $"+amount, this);
		
		records.add(new Record(account, target, amount));
		
		return true;
	}

	@Override
	public List<Record> listHistory(String account, String password) {
		List<Record> targetRecords = new LinkedList<Record>();
		
		for( Record r: records ){
			if( r.getTarget().equals(account) ){
				targetRecords.add(r);
			}
		}
		return targetRecords;
	}
}
