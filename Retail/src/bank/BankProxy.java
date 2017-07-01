package bank;

public class BankProxy {
	public static final String KEY = "_seller_a_s3cret_k3y";
	
	private static BankPort bank;
	
	public static BankPort getPort(){
		if( bank == null ) 
			bank = new BankImplService().getBankImplPort();
		return bank;
	}
}
