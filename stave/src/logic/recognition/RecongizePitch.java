package logic.recognition;

import java.awt.Point;
import java.util.ArrayList;


public class RecongizePitch {
	private int[] pitchLocation;//记录音阶位置，从小到大，表驱动法
	private int[] pointInLineCount;//计算每个音阶上有多少个点

	public RecongizePitch () {
		InputConfig inputConfig = InputConfig.instance();
		int[] lineYs = inputConfig.getStaveYs();
		int staveGap = inputConfig.getGap();
		
		pointInLineCount = new int[lineYs.length * 2 + 2];
		initPitchLocation(lineYs, staveGap);
	}
	
	private void initPitchLocation (int[] lineYs, int staveGap) {
		pitchLocation = new int[pointInLineCount.length - 1];
		for (int i = 0; i < pitchLocation.length - 1; i++) {
			if (i % 2 == 0) {
				pitchLocation[i] = lineYs[i / 2] - staveGap / 2;
			} else {
				pitchLocation[i] = lineYs[(i - 1) / 2]; 
			}
		}
		
		int lastLocation = lineYs[lineYs.length - 1] + staveGap / 2;
		pitchLocation[pitchLocation.length - 1] = lastLocation;
	}
	
	public int excute (ArrayList<Point> pointList) {
		countPointsLocation(pointList);
		
		//find max and second
		int pointCountMaxIndex = 0;
		int pointCountSecondIndex = 0;
		for (int i = 1; i < pointInLineCount.length; i++) {
			if (pointInLineCount[i] > pointInLineCount[pointCountMaxIndex]) {
				pointCountSecondIndex = pointCountMaxIndex;
				pointCountMaxIndex = i;
			} else if (pointInLineCount[i] > pointInLineCount[pointCountSecondIndex]){
				pointCountSecondIndex = i;
			}
		}
		
		//find the pitch
		if (Math.abs(pointCountMaxIndex - pointCountSecondIndex) == 1) {
			return Math.min(pointCountMaxIndex, pointCountSecondIndex);
		} else {
			return pointCountMaxIndex;
		}
	}
	
	/**
	 * 计算在各个音阶的点
	 */
	private void countPointsLocation (ArrayList<Point> pointList) {
		for (int pointIndex = 0; pointIndex < pointList.size(); pointIndex++) {
			for (int pitchIndex = 0; pitchIndex < pitchLocation.length; pitchIndex++) {
				Point point = pointList.get(pointIndex);
				if (point.y < pitchLocation[pitchIndex]) {
					pointInLineCount[pitchIndex]++;
					break;
				}
			}
		}
	}
}
