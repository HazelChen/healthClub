package edu.nju.healthClub.model;

public class MemberSexStatistics {
	private double maleCount;
	private double femaleCount;
	private String bestSex;
	
	public MemberSexStatistics (double maleCount, double femaleCount, String bestSex) {
		this.maleCount = maleCount;
		this.femaleCount = femaleCount;
		this.bestSex = bestSex;
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
	
	
	
	
}	
