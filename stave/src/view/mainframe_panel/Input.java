package view.mainframe_panel;

import java.awt.Color;

import javax.swing.JPanel;

import view.MainFrame;

public class Input extends JPanel {

	public Input(MainFrame frame) {
		
		int width = frame.getScreenWidth()/4;
		int height = 2*frame.getScreenHeight()/3;
		
		this.setBackground(Color.BLUE);
		this.setLayout(null);
		this.setSize(width, height);
	}
}