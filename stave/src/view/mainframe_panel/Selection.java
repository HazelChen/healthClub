package view.mainframe_panel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import logic.NoteSimplified;
import view.MainFrame;

public class Selection extends JPanel {

	private JButton[] top;
	private NoteSimplified[] notes;
	
	public Selection(final MainFrame frame) {
		
		int width = frame.getScreenWidth()/4;
		int height = frame.getScreenHeight()/3;
		notes = new NoteSimplified[5];
		top = new JButton[5];
		
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		this.setSize(width, height);
		
		for (int i=0; i<5; i++) {
			top[i] = new JButton();
			top[i].setFocusPainted(false);
			top[i].setName(""+i);
			top[i].addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent Button){
							
							String name = ((JButton)Button.getSource()).getName();
							int index = Integer.parseInt(name);
							frame.modLastNoteTo(notes[index]);
						}
					}
			);
		}
		
		top[0].setBounds(10, 10, (width-40)/2, height-70);
		top[1].setBounds(20+(width-40)/2, 10, (width-40)/4, (height-30)/2);
		top[2].setBounds(30+3*(width-40)/4, 10, (width-40)/4, (height-30)/2);
		top[3].setBounds(20+(width-40)/2, 20+(height-30)/2, (width-40)/4, (height-30)/2);
		top[4].setBounds(30+3*(width-40)/4, 20+(height-30)/2, (width-40)/4, (height-30)/2);
		for (int i=0; i<5; i++)
			add(top[i]);
		
		JButton cancel = new JButton("¡¶-  Çå³ý¸ÃÒô·û");
		cancel.setFocusPainted(false);
		cancel.setBounds(10, 25+(width-40)/2, (width-40)/2, 40);
		add(cancel);
		cancel.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent Button){
						
						frame.deleteLastNote();
					}
				}
		);
	}
	
	public void setSelection(NoteSimplified note1, NoteSimplified note2, NoteSimplified note3,
			NoteSimplified note4, NoteSimplified note5) {
		
		notes[0] = note1;
		notes[1] = note2;
		notes[2] = note3;
		notes[3] = note4;
		notes[4] = note5;
		drawNotes();
	}
	
	private void drawNotes() {
		
	}
}