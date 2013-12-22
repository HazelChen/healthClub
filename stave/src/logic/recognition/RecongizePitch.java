package logic.recognition;

import java.awt.Point;
import java.util.ArrayList;

public class RecongizePitch {
	private int[] pitchLocation;//记录音阶位置，从大到小，表驱动法
	private int[] pointInLineCount;//计算每个音阶上有多少个点

	public RecongizePitch () {
		InputConfig inputConfig = InputConfig.instance();
		ArrayList<Integer> lineYs = inputConfig.getStaveYs();
		int staveGap = inputConfig.getGap();
		
		pointInLineCount = new int[lineYs.size() * 2 + 1];
		initPitchLocation(lineYs, staveGap);
	}
	
//	public int excute (ArrayList<Point> points) {
//		
//	}
	
	private void initPitchLocation (ArrayList<Integer> lineYs, int staveGap) {
		pitchLocation = new int[pointInLineCount.length - 1];
		for (int i = 0; i < pitchLocation.length; i++) {
			if (i % 2 == 0) {
				pitchLocation[i] = lineYs.get(i / 2);
			} else {
				pitchLocation[i] = lineYs.get((i - 1) / 2) + staveGap / 2; 
			}
			System.out.println(pitchLocation[i]);
		}
	}
}
