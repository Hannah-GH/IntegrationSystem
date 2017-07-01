package gui;

import gpms.GPMSPort;
import gpms.RetailProxy;
import util.Logger;
import util.SideType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PublishListener implements ActionListener{
	private GPMSPort gpms;
	
	private JTextField nameField;
	private JTextField introField;
	private JTextField priceField;
	private JTextField limitField;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if( gpms == null )
			gpms = RetailProxy.getPort();
		
		String name = nameField.getText();
		String intro = introField.getText();
		
		double price = 0.0;
		int limit;
		try{
			price = Double.parseDouble(priceField.getText());
			limit = Integer.parseInt(limitField.getText());
			
			//调用团购服务器发布
			gpms.publishGroupPurchaseItem(RetailProxy.KEY, name, intro, price, limit);
			
		}catch(Exception ex){
			Logger.log(SideType.零售商客户端, "输入数据无法转换成数字", ex, this);
		}
	}

	public void setInputFields(JTextField name, JTextField intro,
			JTextField price, JTextField limit) {
		this.nameField = name;
		this.introField = intro;
		this.priceField = price;
		this.limitField = limit;
	}
}
