package gpms;

public class RetailProxy {
	public static final String KEY = "_seller_a_s3cret_k3y";
	
	private static GPMSPort gpms;
	
	public static GPMSPort getPort(){
		if( gpms == null ) 
			gpms = new GPMSImplService().getGPMSImplPort();
		return gpms;
	}
}
