package launcher;

import gui.RetailPanel;

import javax.swing.*;


public class RetailLauncher {

	public static void main(String[] args) {
		new RetailLauncher().launch();
	}

	public void launch() {
		JFrame frame = new JFrame("零售系统");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new RetailPanel());
		frame.pack();
		frame.setLocation(500, 350);
		frame.setVisible(true);
		frame.setResizable(false);
	}
}
