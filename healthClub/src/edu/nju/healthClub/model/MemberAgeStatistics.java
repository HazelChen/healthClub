package edu.nju.healthClub.model;

public class MemberAgeStatistics {
	private double[] percents;
	private String bestAge;
	
	public MemberAgeStatistics (double[] percents,String bestAge) {
		this.percents = percents;
		this.bestAge = bestAge;
	}

	public double[] getPercents() {
		return percents;
	}

	public void setPercents(double[] percents) {
		this.percents = percents;
	}

	public String getBestAge() {
		return bestAge;
	}

	public void setBestAge(String bestAge) {
		this.bestAge = bestAge;
	}
	
	
}
