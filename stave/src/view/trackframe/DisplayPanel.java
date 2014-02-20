package view.trackframe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import logic.ToneMark;

class DisplayPanel extends JPanel {
	
	private Image clef, beat;
	private Image clef1, clef2;
	private Image rising, falling;
	private Image empty;
	private ArrayList<Image> beatlist;
	private ArrayList<Image> risinglist, fallinglist;
	
	private TrackFrame frame;
	
	DisplayPanel(TrackFrame frame) {
		
		this.frame = frame;
		this.setLayout(null);
		this.setSize(190, 190);
		this.setBackground(Color.BLACK);
		
		clef = null;
		try {
			clef1 = ImageIO.read(new File("uiSrc/trackMod/bigCelf1.png"));
			clef2 = ImageIO.read(new File("uiSrc/trackMod/bigCelf2.png"));
			rising = ImageIO.read(new File("uiSrc/trackMod/rising.png"));
			falling = ImageIO.read(new File("uiSrc/trackMod/falling.png"));
			empty = ImageIO.read(new File("uiSrc/trackMod/empty.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		beat = clef = empty;
		
		beatlist = new ArrayList<Image>();
		try {
			for (int i=0; i<10; i++)
					beatlist.add(ImageIO.read(new File("uiSrc/trackMod/beat"+i+".png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		risinglist = new ArrayList<Image>();
		fallinglist = new ArrayList<Image>();
		for (int i=0; i<7; i++) {
			risinglist.add(empty);
			fallinglist.add(empty);
		}
		
		this.setVisible(true);
	}
	
	public void setClef(boolean big) {
		
		if (big)
			clef = clef1;
		else
			clef = clef2;
		frame.repaint();
	}
	
	public void setBeat(int index) {
		
		beat = beatlist.get(index);
		frame.repaint();
	}
	
	public void setToneMark(ToneMark mark) {
		
		for (int i=0; i<7; i++) {
			risinglist.set(i, empty);
			fallinglist.set(i, empty);
		}
		
		if ((mark == ToneMark.D) || (mark == ToneMark.A) || (mark == ToneMark.E) || (mark == ToneMark.B)
				|| (mark == ToneMark.RISING_F) || (mark == ToneMark.RISING_C))
			risinglist.set(0, rising);
		if ((mark == ToneMark.E) || (mark == ToneMark.B) || (mark == ToneMark.RISING_F) || (mark == ToneMark.RISING_C))
			risinglist.set(1, rising);
		if ((mark == ToneMark.RISING_F) || (mark == ToneMark.RISING_C))
			risinglist.set(2, rising);
		if ((mark == ToneMark.G) ||(mark == ToneMark.D) || (mark == ToneMark.A) || (mark == ToneMark.E)
				|| (mark == ToneMark.B) || (mark == ToneMark.RISING_F) || (mark == ToneMark.RISING_C))
			risinglist.set(3, rising);
		if ((mark == ToneMark.A) || (mark == ToneMark.E) || (mark == ToneMark.B)
				|| (mark == ToneMark.RISING_F) || (mark == ToneMark.RISING_C))
			risinglist.set(4, rising);
		if ((mark == ToneMark.B) || (mark == ToneMark.RISING_F) || (mark == ToneMark.RISING_C))
			risinglist.set(5, rising);
		if (mark == ToneMark.RISING_C)
			risinglist.set(6, rising);
		
		if ((mark == ToneMark.FALLING_G) || (mark == ToneMark.FALLING_C))
			fallinglist.set(0, falling);
		if ((mark == ToneMark.FALLING_A) || (mark == ToneMark.FALLING_D) || (mark == ToneMark.FALLING_G) || (mark == ToneMark.FALLING_C))
			fallinglist.set(1, falling);
		if ((mark == ToneMark.FALLING_B) || (mark == ToneMark.FALLING_E) || (mark == ToneMark.FALLING_A)
				|| (mark == ToneMark.FALLING_D) || (mark == ToneMark.FALLING_G) || (mark == ToneMark.FALLING_C))
			fallinglist.set(2, falling);
		if (mark == ToneMark.FALLING_C)
			fallinglist.set(3, falling);
		if ((mark == ToneMark.FALLING_D) || (mark == ToneMark.FALLING_G) || (mark == ToneMark.FALLING_C))
			fallinglist.set(4, falling);
		if ((mark == ToneMark.FALLING_E) || (mark == ToneMark.FALLING_A) || (mark == ToneMark.FALLING_D)
				|| (mark == ToneMark.FALLING_G) || (mark == ToneMark.FALLING_C))
			fallinglist.set(5, falling);
		if ((mark == ToneMark.F) ||(mark == ToneMark.FALLING_B) || (mark == ToneMark.FALLING_E) || (mark == ToneMark.FALLING_A)
				|| (mark == ToneMark.FALLING_D) || (mark == ToneMark.FALLING_G) || (mark == ToneMark.FALLING_C))
			fallinglist.set(6, falling);
		
		frame.repaint();
	}
	
	@Override
	public void paint(Graphics g) {
		
	    g.drawLine(10, 40, 185, 40);
	    g.drawLine(10, 70, 185, 70);
	    g.drawLine(10, 100, 185, 100);
	    g.drawLine(10, 130, 185, 130);
	    g.drawLine(10, 160, 185, 160);
	    g.drawImage(clef,0,20,clef.getWidth(null),clef.getHeight(null),null);
	    g.drawImage(beat,125,25,beat.getWidth(null),beat.getHeight(null),null);
	    
	    g.drawImage(risinglist.get(0),65,70,risinglist.get(0).getWidth(null),risinglist.get(0).getHeight(null),null);
	    g.drawImage(risinglist.get(1),85,55,risinglist.get(1).getWidth(null),risinglist.get(1).getHeight(null),null);
	    g.drawImage(risinglist.get(2),105,40,risinglist.get(2).getWidth(null),risinglist.get(2).getHeight(null),null);
	    g.drawImage(risinglist.get(3),55,25,risinglist.get(3).getWidth(null),risinglist.get(3).getHeight(null),null);
	    g.drawImage(risinglist.get(4),75,10,risinglist.get(4).getWidth(null),risinglist.get(4).getHeight(null),null);
	    g.drawImage(risinglist.get(5),95,100,risinglist.get(5).getWidth(null),risinglist.get(5).getHeight(null),null);
	    g.drawImage(risinglist.get(6),115,85,risinglist.get(6).getWidth(null),risinglist.get(6).getHeight(null),null);
	    
	    g.drawImage(fallinglist.get(0),105,70,fallinglist.get(0).getWidth(null),fallinglist.get(0).getHeight(null),null);
	    g.drawImage(fallinglist.get(1),85,55,fallinglist.get(1).getWidth(null),fallinglist.get(1).getHeight(null),null);
	    g.drawImage(fallinglist.get(2),65,40,fallinglist.get(2).getWidth(null),fallinglist.get(2).getHeight(null),null);
	    g.drawImage(fallinglist.get(3),115,130,fallinglist.get(3).getWidth(null),fallinglist.get(3).getHeight(null),null);
	    g.drawImage(fallinglist.get(4),95,115,fallinglist.get(4).getWidth(null),fallinglist.get(4).getHeight(null),null);
	    g.drawImage(fallinglist.get(5),75,100,fallinglist.get(5).getWidth(null),fallinglist.get(5).getHeight(null),null);
	    g.drawImage(fallinglist.get(6),55,85,fallinglist.get(6).getWidth(null),fallinglist.get(6).getHeight(null),null);
	}
}