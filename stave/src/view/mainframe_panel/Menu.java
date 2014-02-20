package view.mainframe_panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.MainFrame;
import view.component.MenuButton;

public class Menu extends JPanel {
	
	private MainFrame frame;
	private MenuButton menu1, menu2, menu3;
	
	public Menu(final MainFrame frame) {
		
		this.frame = frame;
		int width = 3*frame.getScreenWidth()/4;
		
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.setSize(width, 50);
		
		menu1 = new MenuButton(this, "�ļ�");
		menu1.setItsBounds(0, 5, width/5, 40);
		menu1.setWidth(width/5);
		String[] s1 = {"�½�", "��", "����", "����", "�˳�"};
		menu1.setMenuItem(s1);
		add(menu1);
		
		menu2 = new MenuButton(this, "����");
		menu2.setItsBounds(width/5, 5, width/5, 40);
		menu2.setWidth(width/5);
		String[] s2 = {"ȫ������", "ϵͳ����", "�Զ���ģ��"};
		menu2.setMenuItem(s2);
		add(menu2);
		
		menu3 = new MenuButton(this, "��������");
		menu3.setItsBounds(2*width/5, 5, width/5, 40);
		menu3.setWidth(width/5);
		String[] s3 = {"�����", "��Ƥ��", "��������", "��дע��"};
		menu3.setMenuItem(s3);
		add(menu3);
		
		JButton track = new JButton("������");
		track.setBounds(3*width/5, 5, width/5, 40);
		track.setFocusPainted(false);
		add(track);
		track.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
						
						closeAllMenu();
						frame.displayTrackMod();
					}
				}
		);
		
		JButton play = new JButton("���Ų˵�");
		play.setBounds(4*width/5, 5, width/5, 40);
		play.setFocusPainted(false);
		add(play);
		play.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button) {
						
						closeAllMenu();
						frame.displayPlayMenu();
					}
				}
		);
	}
	
	public void action(String title, int index) {
		
		frame.action(title, index);
	}
	
	public void closeAllMenu() {
		
		menu1.close();
		menu2.close();
		menu3.close();
	}

}