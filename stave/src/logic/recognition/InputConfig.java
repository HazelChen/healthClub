package logic.recognition;

import java.awt.geom.Line2D;
import java.util.ArrayList;

import javax.sound.sampled.Line;

/**
 * @author Hazel
 * 记录input panel中五线谱的具体位置
 */
public class InputConfig {
	private static InputConfig instance;
	
	private static final int STAVE_COUNT = 5;
	
	private int staveTop;
	private int staveBottom;
	private int staveGap;
	
	private InputConfig(){}

	public static InputConfig instance () {
		if (instance == null) {
			instance = new InputConfig();
		}
		return instance;
	}
	
	public void init (int top, int bottom) {
		this.staveTop = top;
		this.staveBottom = bottom;
		staveGap = (staveBottom - staveTop) / STAVE_COUNT;
	}
	
	/**
	 * @return 每条五线谱的纵坐标
	 */
	public ArrayList<Integer> getStaveYs () {
		ArrayList<Integer> ys = new ArrayList<>();
		
		for(int i = 0;i < STAVE_COUNT; i++){
			int lineY = staveTop + staveGap * i;
			ys.add(lineY);
		}	
		return ys;
	}
	
	public int getGap () {
		return staveGap;
	}
	
}
