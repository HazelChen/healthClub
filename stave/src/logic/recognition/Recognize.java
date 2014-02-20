package logic.recognition;

import java.awt.Point;
import java.util.ArrayList;

import javax.xml.soap.Node;

public class Recognize {

	public ArrayList<Node> excute (ArrayList<Point> pointList) {
		//TODO 
		RecongizePitch recongizePitch = new RecongizePitch();
		int pitch = recongizePitch.excute(pointList);
		System.out.println(pitch);
		return null;
	}
	
}
