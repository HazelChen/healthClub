package view.mainframe_panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.soap.Node;

import logic.recognition.InputConfig;
import logic.recognition.Recognize;

public class Input extends JPanel {
	private static final long serialVersionUID = 342384641407647472L;
	
	private static final Color BACKGROUND_COLOR = Color.white;
	private static final Color FOREGROUND_COLOR = Color.black;
	private static final int GAP_TO_BORDER = 5;//五线谱两边留下的缝隙
	
	private JFrame frame;
	private InputConfig inputConfig;
	
	private Point previoisPoint;
	private int strokesCount; //第几划
	private ArrayList<Point> pointList;

	public Input(JFrame frame) {
		this.frame = frame;
		pointList = new ArrayList<Point>();
		
		panelInit();
		configInit();
		addMouseListeners();
	}
	
	private void panelInit() {
		int width = frame.getWidth() / 4;
		int height = 2 * frame.getHeight() / 3;
/* crq's
 * 		int width = frame.getScreenWidth()/4;
 * 		int height = 2*frame.getScreenHeight()/3;
 */
		
		this.setBackground(BACKGROUND_COLOR);
		this.setLayout(null);
		this.setSize(width, height);
	}
	
	private void configInit() {
		inputConfig = InputConfig.instance();
		
		int staveTop = this.getY() + this.getHeight() / 3;
		int staveBottom = this.getY() + this.getHeight() - this.getHeight() / 3;
		inputConfig.init(staveTop, staveBottom);
	}
	
	private void addMouseListeners () {
		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {
				Point newPoint = new Point(event.getX(), event.getY());
				pointList.add(newPoint);
				Graphics graphics = Input.this.getGraphics();
				graphics.drawLine(previoisPoint.x, previoisPoint.y, newPoint.x, newPoint.y);
				previoisPoint = newPoint;
			}
		});
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				Thread thread = new Thread(new Timer());
				thread.start();
			}
			
			@Override
			public void mousePressed(MouseEvent event) {
				strokesCount++;
				previoisPoint = new Point(event.getX(), event.getY());
				pointList.add(previoisPoint);
			}
		});
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g); 
		
		g.setColor(FOREGROUND_COLOR);
		
		int[] lineYs = inputConfig.getStaveYs();
		for(int i = 0;i < lineYs.length; i++){
			int lineY = lineYs[i];
			g.drawLine(this.getX() + GAP_TO_BORDER, lineY, this.getX() + this.getWidth() - GAP_TO_BORDER, lineY);
		}		
	}
	
	/**
	 * @author Hazel
	 * 用来计时，如果用户在WAIT_TIME内再也没有输入，则输入结束
	 */
	private class Timer implements Runnable {
		private static final int WAIT_TIME = 1000;//单位毫秒

		@Override
		public void run() {
			int nowStroke = strokesCount;
			try {
				Thread.sleep(WAIT_TIME);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//如果笔画数没有增多
			if (strokesCount == nowStroke) {
				repaint();
				//识别
				Recognize recognize = new Recognize();
				ArrayList<Node> similarNodes = recognize.excute(pointList);
				//TODO 加入到frame的选择区和直接添加音符
				pointList.clear();
			}
		}
		
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
	
}