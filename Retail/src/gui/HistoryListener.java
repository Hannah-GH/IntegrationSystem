package gui;

import banksystem.MyBank;
import banksystem.MyList;
import banksystem.Record;
import util.Logger;
import util.SideType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class HistoryListener implements ActionListener{
	private JTextArea area;

	public void setTextArea(JTextArea area) {
		this.area = area;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if( area == null ){
			Logger.log(SideType.零售商客户端, "历史记录监听器没有获取用于输出的Area！请检查是否正确设置", this);
		}

		MyList temp = MyBank.getBank().listHistory("buyer", "123");

		List<Record> records = temp.getHistoryList();

		StringBuilder builder = new StringBuilder();
		for( Record r: records ){
			String s = r.getFrom()+" -> "+r.getTarget()+" ("+r.getAmount()+")\n";
			builder.append(s);
		}

		area.setText(builder.toString());
	}
}
