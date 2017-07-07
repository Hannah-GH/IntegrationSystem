package banksystem;

import java.util.ArrayList;

/**
 * Created by phoebegl on 2017/7/6.
 */
public class Record {

    private String from;
    private String target;
    private double amount;

    public Record() {
    }

    public Record(String from, String target, double amount) {
        this.from = from;
        this.target = target;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
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
