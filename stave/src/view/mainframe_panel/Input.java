package view.mainframe_panel;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Input extends JPanel {
	private static final int STAVE_COUNT = 5;
	private static final int GAP_TO_BORDER = 5;//五线谱两边留下的缝隙

	public Input(JFrame frame) {
		int width = frame.getWidth() / 4;
		int height = 2 * frame.getHeight() / 3;
/* crq's
 * 		int width = frame.getScreenWidth()/4;
 * 		int height = 2*frame.getScreenHeight()/3;
 */
		
		this.setBackground(Color.white);
		this.setLayout(null);
		this.setSize(width, height);
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(300, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		Input inputPanel = new Input(frame);
		frame.add(inputPanel);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		int staveTop = this.getY() + this.getHeight() / 3;
		int staveBottom = this.getY() + this.getHeight() - this.getHeight() / 3;
		int staveGap = (staveBottom - staveTop) / STAVE_COUNT;
		
		for(int i = 0;i < STAVE_COUNT; i++){
			g.setColor(Color.BLACK);
			int lineY = staveTop + staveGap * i;
			g.drawLine(this.getX() + GAP_TO_BORDER, lineY, this.getX() + this.getWidth() - GAP_TO_BORDER, lineY);
		}		
	}
	
}