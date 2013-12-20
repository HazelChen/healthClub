package view.mainframe_panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import view.MainFrame;

public class Notes extends JDialog {

	private int num = 6;
	
	public Notes(MainFrame frame) {
		
		int width = 3*frame.getScreenWidth()/4;
		int height = 50;
		
		this.setSize(width, height);
		this.setUndecorated(true);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setVisible(false);
		
		JButton line = new JButton("︵  连音");
		line.setFocusPainted(false);
		line.setBounds(0, 5, width/num, 40);
		add(line);
		line.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton line3 = new JButton("3︵  三连音");
		line3.setFocusPainted(false);
		line3.setBounds(width/num, 5, width/num, 40);
		add(line3);
		line3.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton snap = new JButton("^  促音");
		snap.setFocusPainted(false);
		snap.setBounds(2*width/num, 5, width/num, 40);
		add(snap);
		snap.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton accent = new JButton("▪  重音");
		accent.setFocusPainted(false);
		accent.setBounds(3*width/num, 5, width/num, 40);
		add(accent);
		accent.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton increase = new JButton("<  音量增加");
		increase.setFocusPainted(false);
		increase.setBounds(4*width/num, 5, width/num, 40);
		add(increase);
		increase.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton decrease = new JButton(">  音量减小");
		decrease.setFocusPainted(false);
		decrease.setBounds(5*width/num, 5, width/num, 40);
		add(decrease);
		decrease.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
	}
}