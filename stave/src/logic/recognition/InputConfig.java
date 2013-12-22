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
	private int[] lineYs = new int[STAVE_COUNT];//每条五线谱的纵坐标
	
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
		for(int i = 0;i < lineYs.length; i++){
			lineYs[i] = staveTop + staveGap * i;
		}	
	}
	
	public int[] getStaveYs () {
		return lineYs;
	}
	
	public int getGap () {
		return staveGap;
	}
	
}
