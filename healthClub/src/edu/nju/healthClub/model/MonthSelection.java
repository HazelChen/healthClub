package edu.nju.healthClub.model;

public class MonthSelection {
	private String month;
	private boolean selected;
	
	public MonthSelection (String month, boolean selected) {
		this.month = month;
		this.selected = selected;
	}
	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public boolean getSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}
