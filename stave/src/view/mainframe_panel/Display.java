package view.mainframe_panel;

import java.awt.Color;

import javax.swing.JPanel;

import logic.NoteSimplified;

import view.MainFrame;

public class Display extends JPanel {

	public Display(MainFrame frame) {
		
		int width = 3*frame.getScreenWidth()/4;
		int height = frame.getScreenHeight()-50;
		
		this.setBackground(Color.YELLOW);
		this.setLayout(null);
		this.setSize(width, height);
	}
	
	public void addNote(NoteSimplified note) {
		
	}
	
	public void modLastNoteTo(NoteSimplified note) {
		
	}
	
	public void deleteLastNote() {
		
	}
}