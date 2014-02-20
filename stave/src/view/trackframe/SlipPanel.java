package view.trackframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class SlipPanel extends JPanel {
	
	SlipPanel(final TrackFrame frame, final String[] fill) {
		
		this.setLayout(null);
		//this.setSize(260, 50);
		this.setBackground(Color.BLACK);
		
		for (int i=0; i<fill.length; i++) {
			JButton tmp = new JButton(fill[i]);
			tmp.setFocusPainted(false);
			tmp.setBounds(5+58*i, 0, 55, 30);
			tmp.setName(""+i);
			add(tmp);
			tmp.addActionListener(
					new ActionListener(){
						@Override
						public void actionPerformed(ActionEvent Button){
							
							String name = ((JButton)Button.getSource()).getName();
							int index = Integer.parseInt(name);
							String str = fill[index];
							
							if (Character.isDigit(str.charAt(0))) {
								String tmp[] = str.split("/");
								int i0 = Integer.parseInt(tmp[0]);
								int i1 = Integer.parseInt(tmp[1]);
								frame.setBeat(i0, i1, index);
							}
							else {
								frame.setToneMark(index);
							}
							
						}
					}
			);
		}
		this.setPreferredSize(new Dimension(fill.length*58+10, 50));
		this.setVisible(true);
	}
}