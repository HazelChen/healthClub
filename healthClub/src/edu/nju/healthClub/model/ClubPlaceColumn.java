package edu.nju.healthClub.model;

public class ClubPlaceColumn {
	private String place;
	private int count;
	
	public ClubPlaceColumn (String place, int count) {
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
	
	
}
