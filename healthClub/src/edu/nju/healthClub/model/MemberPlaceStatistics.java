package edu.nju.healthClub.model;

import java.util.ArrayList;

public class MemberPlaceStatistics {

	private ArrayList<MemberPlaceColumn> memberPlaceColumns;
	private String bestPlace;
	
	public MemberPlaceStatistics (String bestPlace) {
		memberPlaceColumns = new ArrayList<>();
		this.bestPlace = bestPlace;
	}
	
	public void add (MemberPlaceColumn column) {
		memberPlaceColumns.add(column);
	}

	public ArrayList<MemberPlaceColumn> getMemberPlaceColumns() {
		return memberPlaceColumns;
	}

	public void setMemberPlaceColumns(
			ArrayList<MemberPlaceColumn> memberPlaceColumns) {
		this.memberPlaceColumns = memberPlaceColumns;
	}

	public String getBestPlace() {
		return bestPlace;
	}

	public void setBestPlace(String bestPlace) {
		this.bestPlace = bestPlace;
	}
	
	
}
