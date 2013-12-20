package view.mainframe_panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

import view.MainFrame;

public class Play extends JDialog {

	public Play(MainFrame frame) {
		
		int width = 3*frame.getScreenWidth()/4;
		int height = 50;
		
		this.setSize(width, height);
		this.setUndecorated(true);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		this.setVisible(false);
		
		JButton play = new JButton("▷  播放");
		play.setFocusPainted(false);
		play.setBounds(0, 5, width/5, 40);
		add(play);
		play.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton playFromStart = new JButton("|-▷  从头播放");
		playFromStart.setFocusPainted(false);
		playFromStart.setBounds(width/5, 5, width/5, 40);
		add(playFromStart);
		playFromStart.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton pause = new JButton("||  暂停");
		pause.setFocusPainted(false);
		pause.setBounds(2*width/5, 5, width/5, 40);
		add(pause);
		pause.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton stop = new JButton("■ 停止");
		stop.setFocusPainted(false);
		stop.setBounds(3*width/5, 5, width/5, 40);
		add(stop);
		stop.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
		
		JButton beat = new JButton("♫  节拍器");
		beat.setFocusPainted(false);
		beat.setBounds(4*width/5, 5, width/5, 40);
		add(beat);
		beat.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
					}
				}
		);
	}
}