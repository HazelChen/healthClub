package edu.nju.healthClub.model;

public class ClubCoachColumn {
	private String coach;
	private int count;

	public ClubCoachColumn (String coach, int count) {
		this.coach = coach;
		this.count = count;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
