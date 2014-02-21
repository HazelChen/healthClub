package edu.nju.healthClub.model;

public class ClubMemberStatistics {
	private int[] dayCount;
	private int totalCount;
	
	public ClubMemberStatistics (int[] dayCount, int totalCount) {
		this.dayCount = dayCount;
		this.totalCount = totalCount;
	}
	
	
	public int[] getDayCount() {
		return dayCount;
	}

	public void setDayCount(int[] dayCount) {
		this.dayCount = dayCount;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	
}
