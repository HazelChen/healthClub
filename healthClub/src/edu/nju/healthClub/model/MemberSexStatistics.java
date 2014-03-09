package edu.nju.healthClub.model;

public class MemberSexStatistics {
	private double maleCount;
	private double femaleCount;
	private String bestSex;
	
	public MemberSexStatistics (double maleCount, double femaleCount) {
		this.maleCount = maleCount;
		this.femaleCount = femaleCount;
		judgeBestSex();
	}

	public double getMaleCount() {
		return maleCount;
	}

	public void setMaleCount(double maleCount) {
		this.maleCount = maleCount;
	}

	public double getFemaleCount() {
		return femaleCount;
	}

	public void setFemaleCount(double femaleCount) {
		this.femaleCount = femaleCount;
	}

	public String getBestSex() {
		return bestSex;
	}

	public void setBestSex(String bestSex) {
		this.bestSex = bestSex;
	}
	
	private void judgeBestSex() {
		if (maleCount > femaleCount) {
			bestSex = "男";
		} else {
			bestSex = "女";
		}
	}
	
	
}	
