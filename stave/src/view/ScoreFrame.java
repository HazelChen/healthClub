package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import view.trackframe.TrackFrame;

public class ScoreFrame extends JDialog {

	private boolean newScore;
	private String name, subtitle, author, speed;
	
	private JTextField field1, field2, field3, field4;
	
	public ScoreFrame(boolean isNewScore) {
		
		this.newScore = isNewScore;
		this.setSize(500, 300);
		this.setLayout(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		setLookAndFeel();
		
		JLabel title = new JLabel();
		if (newScore) {
			title.setText("创建乐谱");
			name = subtitle = author = speed = "";
		}
		else {
			title.setText("乐谱修改");
		}
		title.setFont(new Font("Serif", Font.BOLD, 30));
		title.setBounds(185, 15, 200, 40);
		add(title);
		
		Font font = new Font("Serif", Font.BOLD, 24);
		JLabel sub1 = new JLabel("谱    名");
		sub1.setFont(font);
		sub1.setBounds(45, 80, 80, 30);
		add(sub1);
		field1 = new JTextField(name);
		field1.setBounds(140, 80, 300, 30);
		add(field1);
		
		JLabel sub2 = new JLabel("副标题");
		sub2.setFont(font);
		sub2.setBounds(45, 120, 80, 30);
		add(sub2);
		field2 = new JTextField(subtitle);
		field2.setBounds(140, 120, 300, 30);
		add(field2);
		
		JLabel sub3 = new JLabel("作    者");
		sub3.setFont(font);
		sub3.setBounds(45, 160, 80, 30);
		add(sub3);
		field3 = new JTextField(author);
		field3.setBounds(140, 160, 300, 30);
		add(field3);
		
		JLabel sub4 = new JLabel("速    度");
		sub4.setFont(font);
		sub4.setBounds(45, 200, 80, 30);
		add(sub4);
		field4 = new JTextField(speed);
		field4.setBounds(140, 200, 150, 30);
		add(field4);
		JLabel sub5 = new JLabel("个四分音符 / 分钟");
		sub5.setFont(new Font("Serif", Font.BOLD, 16));
		sub5.setBounds(305, 202, 150, 30);
		add(sub5);
		
		JButton sure = new JButton("确认");
		sure.setBounds(160, 250, 80, 40);
		sure.setFocusPainted(false);
		add(sure);
		sure.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button){
						dispose();
					}
				}
		);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(260, 250, 80, 40);
		cancel.setFocusPainted(false);
		add(cancel);
		cancel.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button){
						dispose();
					}
				}
		);
	}
	
	private void setLookAndFeel() {
		
		try {
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
		} catch (Exception ex) {
			Logger.getLogger(TrackFrame.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}