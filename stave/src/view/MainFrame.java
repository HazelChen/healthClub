package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import logic.NoteSimplified;
import view.mainframe_panel.Display;
import view.mainframe_panel.Input;
import view.mainframe_panel.Menu;
import view.mainframe_panel.Notes;
import view.mainframe_panel.Play;
import view.mainframe_panel.Selection;
import view.trackframe.TrackFrame;

public class MainFrame extends JFrame {
	
	private int screenWidth, screenHeight;
	private boolean displayPlay, displayNotes;
	
	private Menu menu;
	private Input input;
	private Selection selection;
	private Display display;
	private Notes notes;
	private Play play;
	
	public MainFrame() {
		
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screen.width-300;
		screenHeight = screen.height-200;
		displayPlay = displayNotes = false;
		init();
	}
	
	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}

	private void init() {
		
		this.setSize(screenWidth, screenHeight);
		this.setUndecorated(true);
		this.setLayout(null);
		this.getContentPane().setBackground(Color.WHITE);
		setLookAndFeel();
		
		menu = new Menu(this);
		menu.setLocation(0, 0);
		add(menu);
		
		input = new Input(this);
		input.setLocation(3*screenWidth/4, 0);
		add(input);
		
		selection = new Selection(this);
		selection.setLocation(3*screenWidth/4, 2*screenHeight/3);
		add(selection);
		
		display = new Display(this);
		display.setLocation(0, 50);
		add(display);
		
		notes = new Notes(this);
		notes.setLocation(0, 50);
		
		play = new Play(this);
		play.setLocation(0, 50);
	}
	
	public void action(String title, int index) {
		
		if (title.equals("文件")) {
			switch (index) {
			case 0:
				ScoreFrame score = new ScoreFrame(true);
				score.setVisible(true);
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				System.exit(0);
			}
		}
		
		if (title.equals("设置")) {
			switch (index) {
			case 0:
				ScoreFrame score = new ScoreFrame(false);
				score.setVisible(true);
				break;
			case 1:
				break;
			case 2:
				break;
			}
		}
		
		if (title.equals("主屏操作")) {
			switch (index) {
			case 0:
				notes.setVisible(false);
				play.setVisible(false);
				displayPlay = false;
				displayNotes = false;
				break;
			case 1:
				notes.setVisible(false);
				play.setVisible(false);
				displayPlay = false;
				displayNotes = false;
				break;
			case 2:
				if (!displayNotes) {
					notes.setVisible(true);
					play.setVisible(false);
					displayPlay = false;
				}
				else
					notes.setVisible(false);
				displayNotes = !displayNotes;
				break;
			case 3:
				notes.setVisible(false);
				play.setVisible(false);
				displayPlay = false;
				displayNotes = false;
				break;
			}
		}
	}
	
	public void displayTrackMod() {
		
		TrackFrame frame = new TrackFrame();
		frame.setVisible(true);
	}
	
	public void displayPlayMenu() {
		
		if (!displayPlay) {
			play.setVisible(true);
			notes.setVisible(false);
			displayNotes = false;
		}
		else
			play.setVisible(false);
		displayPlay = !displayPlay;
	}
	
	public void addNote(NoteSimplified note) {
		
		display.addNote(note);
	}
	
	public void modLastNoteTo(NoteSimplified note) {
		
		display.modLastNoteTo(note);
	}
	
	public void deleteLastNote() {
		
		display.deleteLastNote();
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