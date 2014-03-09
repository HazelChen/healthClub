package edu.nju.healthClub.model;

import java.util.HashMap;
import java.util.Map;

public class MemberAgeStatistics {
	private double percent0;
	private double percent1;
	private double percent2;
	private double percent3;
	private double percent4;
	private String bestAge;
	
	public MemberAgeStatistics (double[] percents) {
		percent0 = percents[0];
		percent1 = percents[1];
		percent2 = percents[2];
		percent3 = percents[3];
		percent4 = percents[4];
		generateBest(percents);
	}
	
	public double getPercent0() {
		return percent0;
	}

	public void setPercent0(double percent0) {
		this.percent0 = percent0;
	}

	public double getPercent1() {
		return percent1;
	}

	public void setPercent1(double percent1) {
		this.percent1 = percent1;
	}

	public double getPercent2() {
		return percent2;
	}

	public void setPercent2(double percent2) {
		this.percent2 = percent2;
	}

	public double getPercent3() {
		return percent3;
	}

	public void setPercent3(double percent3) {
		this.percent3 = percent3;
	}

	public double getPercent4() {
		return percent4;
	}

	public void setPercent4(double percent4) {
		this.percent4 = percent4;
	}

	public String getBestAge() {
		return bestAge;
	}

	public void setBestAge(String bestAge) {
		this.bestAge = bestAge;
	}
	
	private void generateBest(double[] percents) {
		Map<Integer, String> bestStrings = new HashMap<Integer, String>();
		bestStrings.put(0, "0~20岁");
		bestStrings.put(1, "20~40岁");
		bestStrings.put(2, "40~60岁");
		bestStrings.put(3, "60~80岁");
		bestStrings.put(4, "80岁以上");
		
		double maxPercents = 0; 
		for(int i = 0;i < percents.length;i++) {
			if (percents[i] > maxPercents) {
				maxPercents = percents[i];
				bestAge = bestStrings.get(i);
			}
		}
	}
	
	
}
