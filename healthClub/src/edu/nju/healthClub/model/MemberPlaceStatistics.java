package edu.nju.healthClub.model;

import java.util.ArrayList;

public class MemberPlaceStatistics {

	private ArrayList<MemberPlaceColumn> memberPlaceColumns;
	private String bestPlace;
	
	public MemberPlaceStatistics (ArrayList<MemberPlaceColumn> columns) {
		memberPlaceColumns = columns;
		percentsAndBestHandle();
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
	
	private void percentsAndBestHandle() {
		int total = 0;
		int maxCount = 0;
		for (int i = 0; i < memberPlaceColumns.size(); i++) {
			MemberPlaceColumn column = memberPlaceColumns.get(i);
			total += column.getCount();
			if (column.getCount() > maxCount) {
				maxCount = column.getCount();
				bestPlace = column.getPlace();
			}
		}
		
		for (int i = 0; i < memberPlaceColumns.size(); i++) {
			MemberPlaceColumn column = memberPlaceColumns.get(i);
			int count = column.getCount();
			column.setPercent((double)count / total);
		}
		
	}
	
}
