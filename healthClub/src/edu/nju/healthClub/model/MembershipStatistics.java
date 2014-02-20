package edu.nju.healthClub.model;

public class MembershipStatistics {
	private int newCount;
	private int suspendCount;
	private int stopCount;
	private double newPercent;
	private double suspendPercent;
	private double stopPercent;
	private int netGrowthCount;
	
	public MembershipStatistics (int newCount, int suspendCount, int stopCount) {
		this.newCount = newCount;
		this.suspendCount = suspendCount;
		this.stopCount = stopCount;
		netGrowthCount = newCount - suspendCount - stopCount;
		calculatePercent();
	}
	
	private void calculatePercent() {
		double total = newCount + suspendCount + stopCount;
		newPercent = newCount / total;
		suspendPercent = suspendCount / total;
		stopPercent = stopCount / total;
	}
	
	public int getNewCount() {
		return newCount;
	}
	public void setNewCount(int newCount) {
		this.newCount = newCount;
	}
	public int getSuspendCount() {
		return suspendCount;
	}
	public void setSuspendCount(int suspendCount) {
		this.suspendCount = suspendCount;
	}
	public int getStopCount() {
		return stopCount;
	}
	public void setStopCount(int stopCount) {
		this.stopCount = stopCount;
	}

	public int getNetGrowthCount() {
		return netGrowthCount;
	}

	public void setNetGrowthCount(int netGrowthCount) {
		this.netGrowthCount = netGrowthCount;
	}

	public double getNewPercent() {
		return newPercent;
	}

	public void setNewPercent(double newPercent) {
		this.newPercent = newPercent;
	}

	public double getSuspendPercent() {
		return suspendPercent;
	}

	public void setSuspendPercent(double suspendPercent) {
		this.suspendPercent = suspendPercent;
	}

	public double getStopPercent() {
		return stopPercent;
	}

	public void setStopPercent(double stopPercent) {
		this.stopPercent = stopPercent;
	}
	
	
	
}
