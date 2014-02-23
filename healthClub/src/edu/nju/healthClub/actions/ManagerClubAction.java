package edu.nju.healthClub.actions;

import java.util.ArrayList;

import edu.nju.healthClub.model.ClubCoachColumn;
import edu.nju.healthClub.model.ClubMemberStatistics;
import edu.nju.healthClub.model.ClubPlaceColumn;

public class ManagerClubAction extends BaseAction{
	private static final long serialVersionUID = 1146621566194268753L;
	
	private ClubMemberStatistics clubMemberStatistics;
	private ArrayList<ClubPlaceColumn> placeColumns;
	private ArrayList<ClubCoachColumn> coachColumns;
	
	@Override
	public String execute () {
		int[] dayCount = new int[]{2,3,4,5,1,4,2,5,3,6,8,6,4,7,6,7,6,2,1,5,7,5,2,3,5,2,3,5,3,8,9};
		clubMemberStatistics = new ClubMemberStatistics(dayCount, 50);
		
		placeColumns = new ArrayList<>();
		ClubPlaceColumn placeColumn1 = new ClubPlaceColumn("霍格沃茨", 5);
		ClubPlaceColumn placeColumn2 = new ClubPlaceColumn("霍格沃茨", 5);
		ClubPlaceColumn placeColumn3 = new ClubPlaceColumn("霍格沃茨", 5);
		ClubPlaceColumn placeColumn4 = new ClubPlaceColumn("霍格沃茨", 5);
		ClubPlaceColumn placeColumn5 = new ClubPlaceColumn("霍格沃茨", 5);
		ClubPlaceColumn placeColumn6 = new ClubPlaceColumn("霍格沃茨", 5);
		placeColumns.add(placeColumn1);
		placeColumns.add(placeColumn2);
		placeColumns.add(placeColumn3);
		placeColumns.add(placeColumn4);
		placeColumns.add(placeColumn5);
		placeColumns.add(placeColumn6);
		
		coachColumns = new ArrayList<>();
		ClubCoachColumn coachColumn1 = new ClubCoachColumn("伏地魔", 7);
		ClubCoachColumn coachColumn2 = new ClubCoachColumn("伏地魔", 7);
		ClubCoachColumn coachColumn3 = new ClubCoachColumn("伏地魔", 7);
		ClubCoachColumn coachColumn4 = new ClubCoachColumn("伏地魔", 7);
		ClubCoachColumn coachColumn5 = new ClubCoachColumn("伏地魔", 7);
		ClubCoachColumn coachColumn6 = new ClubCoachColumn("伏地魔", 7);
		ClubCoachColumn coachColumn7 = new ClubCoachColumn("伏地魔", 7);
		coachColumns.add(coachColumn1);
		coachColumns.add(coachColumn2);
		coachColumns.add(coachColumn3);
		coachColumns.add(coachColumn4);
		coachColumns.add(coachColumn5);
		coachColumns.add(coachColumn6);
		coachColumns.add(coachColumn7);
		return SUCCESS;
	}

	public ClubMemberStatistics getClubMemberStatistics() {
		return clubMemberStatistics;
	}

	public void setClubMemberStatistics(ClubMemberStatistics clubMemberStatistics) {
		this.clubMemberStatistics = clubMemberStatistics;
	}

	public ArrayList<ClubPlaceColumn> getPlaceColumns() {
		return placeColumns;
	}

	public void setPlaceColumns(ArrayList<ClubPlaceColumn> placeColumns) {
		this.placeColumns = placeColumns;
	}

	public ArrayList<ClubCoachColumn> getCoachColumns() {
		return coachColumns;
	}

	public void setCoachColumns(ArrayList<ClubCoachColumn> coachColumns) {
		this.coachColumns = coachColumns;
	}
	
	
	
}
