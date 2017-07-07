package banksystem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by phoebegl on 2017/7/7.
 * WebService复杂对象传递要借助第三方对象。。。
 */
public class MyList {
    private ArrayList<Record> historyList;

    public ArrayList<Record> getHistoryList() {
        return historyList;
    }

    public void setHistoryList(ArrayList<Record> historyList) {
        this.historyList = historyList;
    }
}
