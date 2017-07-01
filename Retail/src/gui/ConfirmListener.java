package gui;

import gpms.GPMSPort;
import gpms.RetailProxy;
import util.Logger;
import util.SideType;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfirmListener implements ActionListener{
	private JTextField confirm;
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GPMSPort gpms = RetailProxy.getPort();
		boolean confirmResult = gpms.confirmPurchase(RetailProxy.KEY, confirm.getText());
		
		if( confirmResult == true ){
			Logger.log(SideType.零售商客户端, "团购确认成功！", this);
		}
	}

	public void setInputFields(JTextField confirm) {
		this.confirm = confirm;
	}
}
