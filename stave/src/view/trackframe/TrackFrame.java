package view.trackframe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import logic.Instrument;
import logic.ToneMark;
import logic.Track;

@SuppressWarnings("serial")
public class TrackFrame extends JDialog {

	private DisplayPanel display;
	private SlipPanel beat, tone;
	
	private boolean isTrebleClef;
	private int beatNote;
	private int beatsPerBar;
	private ToneMark toneMark;
	private Instrument instrument;
	private int volume;
	private boolean setClef, setBeat, setMark;
	
	private Track track;
	
	private ImageIcon imgTitle = new ImageIcon("uiSrc/trackMod/title.jpg");
	private ImageIcon imgClef1 = new ImageIcon("uiSrc/trackMod/clef1.jpg");
	private ImageIcon imgClef2 = new ImageIcon("uiSrc/trackMod/clef2.jpg");
	Image test = null;
	
	public TrackFrame() {
		
		setClef = setBeat = setMark = false;
		
		this.setSize(500, 260);
		this.setLayout(null);
		this.setResizable(false);
		this.setUndecorated(true);
		this.setLocationRelativeTo(null);
		this.getContentPane().setBackground(Color.WHITE);
		setLookAndFeel();
		
		JLabel title = new JLabel(imgTitle);
		title.setBounds(10, 0, 150, 70);
		add(title);
		
		JButton clef1 = new JButton(imgClef1);
		clef1.setBounds(165, 10, 50, 50);
		clef1.setFocusPainted(false);
		add(clef1);
		clef1.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button){
						isTrebleClef = true;
						setClef = true;
						display.setClef(true);
					}
				}
		);
		JButton clef2 = new JButton(imgClef2);
		clef2.setBounds(220, 10, 50, 50);
		clef2.setFocusPainted(false);
		add(clef2);
		clef2.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button){
						isTrebleClef = false;
						setClef = true;
						display.setClef(false);
					}
				}
		);
		
		String s1[] = {"1/1", "2/2", "2/4", "3/4", "4/4", "3/8", "5/8", "6/8", "7/8", "9/8"};
		
		beat = new SlipPanel(this, s1);
		JScrollPane beatPane = new JScrollPane(beat, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		beatPane.setBounds(10, 80, 260, 50);
		add(beatPane);
		String s2[] = {"C", "G", "D", "A", "E", "B", "#F", "#C", "F", "bB", "bE", "bA", "bD", "bG", "bC"};
		tone = new SlipPanel(this, s2);
		JScrollPane tonePane = new JScrollPane(tone, JScrollPane.VERTICAL_SCROLLBAR_NEVER,
		        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tonePane.setBounds(10, 150, 260, 50);
		add(tonePane);
		
		Font font = new Font("Serif",Font.BOLD,15);
		JLabel l1 = new JLabel("音质");
		l1.setFont(font);
		l1.setBounds(10, 225, 50, 20);
		add(l1);
		String s3[] = {"钢琴", "吉他", "萨克斯", "小提琴"};
		JComboBox<String> instrumental = new JComboBox<String>(s3);
		instrumental.setBounds(50, 220, 80, 30);
		add(instrumental);
		
		JLabel l2 = new JLabel("音量");
		l2.setFont(font);
		l2.setBounds(150, 225, 50, 20);
		add(l2);
		String s4[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		JComboBox<String> volumes = new JComboBox<String>(s4);
		volumes.setBounds(190, 220, 80, 30);
		add(volumes);
		
		display = new DisplayPanel(this);
		display.setLocation(285, 10);
		add(display);
		
		JButton sure = new JButton("确认添加新音轨");
		sure.setBounds(285, 220, 120, 30);
		sure.setFocusPainted(false);
		add(sure);
		sure.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button){
						if (setClef && setBeat && setMark) {
							track = new Track(isTrebleClef, beatNote, beatsPerBar, toneMark, instrument, volume);
							JOptionPane.showMessageDialog(null,"新音轨创建成功", "系统提示",JOptionPane.INFORMATION_MESSAGE);
							dispose();
						}
						else
							JOptionPane.showMessageDialog(null,"新音轨创建失败\n存在信息未选", "系统提示",JOptionPane.WARNING_MESSAGE);
					}
				}
		);
		
		JButton cancel = new JButton("取消");
		cancel.setBounds(415, 220, 60, 30);
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
	
	public Track getTrack() {
		
		return track;
	}

	public void setBeat(int beatsPerBar, int beatNote, int index) {
		
		this.beatNote = beatNote;
		this.beatsPerBar = beatsPerBar;
		display.setBeat(index);
		setBeat = true;
	}

	public void setToneMark(int index) {
		
		toneMark = ToneMark.values()[index];
		display.setToneMark(toneMark);
		setMark = true;
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