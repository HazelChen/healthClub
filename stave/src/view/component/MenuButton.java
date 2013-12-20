package view.component;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import view.mainframe_panel.Menu;

public class MenuButton extends JButton {

	private String title;
	private JDialog frame;
	private boolean hasSetFrame;
	private int width;
	
	private Menu panel;
	
	public MenuButton(final Menu panel, String name) {
		
		title = name;
		this.panel = panel;
		this.setText(name);
		this.setFocusPainted(false);
		width = 100;
		hasSetFrame = false;
		frame = new JDialog();
		initFrame();
		
		this.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
						
					if (hasSetFrame) {
						panel.closeAllMenu();
						frame.setVisible(true);
					}
				}
		});
	}
	
	public void close() {
		
		frame.setVisible(false);
	}
	
	public void setWidth(int width) {
		
		this.width = width;
	}

	public void setItsBounds(int a, int b, int c, int d) {
		
		this.setBounds(a, b, c, d);
		frame.setLocation(a, b+d);
	}
	
	public void setMenuItem(String[] item) {
		
		hasSetFrame = true;
		for (int i=0; i<item.length; i++) {
			
			JButton tmp = new JButton(item[i]);
			tmp.setFocusPainted(false);
			tmp.setBounds(0, 30*i, width, 30);
			tmp.setName(""+i);
			frame.add(tmp);
			tmp.addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent Button) {
							
							String name = ((JButton)Button.getSource()).getName();
							int index = Integer.parseInt(name);
							panel.action(title, index);
							frame.setVisible(false);
						}
					}
			);
		}
		frame.setSize(width, 30*item.length);
	}
	
	private void initFrame() {
		
		frame.setUndecorated(true);
		frame.setLayout(null);
		frame.getContentPane().setBackground(Color.GRAY);
		frame.setVisible(false);
	}
}