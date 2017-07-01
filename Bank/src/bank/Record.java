package bank;

public class Record {
	private String source;
	private String target;
	private double amount;
	
	public Record(){}
	
	public Record(String source, String target, double amount){
		this.source = source;
		this.target = target;
		this.amount = amount;
	}
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
}
