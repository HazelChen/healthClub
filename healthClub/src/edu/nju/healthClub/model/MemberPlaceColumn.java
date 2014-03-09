package edu.nju.healthClub.model;

public class MemberPlaceColumn {
	private String place;
	private int count;
	private double percent;
	
	public  MemberPlaceColumn (String place, int count) {
		this.place = place;
		this.count = count;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}
	
	
}
