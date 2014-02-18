package edu.nju.healthClub.actions;

import java.util.ArrayList;
import java.util.Calendar;

import edu.nju.healthClub.model.PlaceUseShow;

public class PlaceAction extends BaseAction{
	private static final long serialVersionUID = -7452893292012390954L;
	
	private ArrayList<PlaceUseShow> placeUseShows;
	
	@Override
	public String execute() {
		Calendar calendar = Calendar.getInstance();
		PlaceUseShow placeUseShow1 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow2 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow3 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow4 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow5 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow6 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow7 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow8 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow9 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		PlaceUseShow placeUseShow10 = new PlaceUseShow("上海体育馆", "123", "习近平复信患白血病村官：你要保重身体", calendar.getTime());
		
		placeUseShows = new ArrayList<>();
		placeUseShows.add(placeUseShow1);
		placeUseShows.add(placeUseShow2);
		placeUseShows.add(placeUseShow3);
		placeUseShows.add(placeUseShow4);
		placeUseShows.add(placeUseShow5);
		placeUseShows.add(placeUseShow6);
		placeUseShows.add(placeUseShow7);
		placeUseShows.add(placeUseShow8);
		placeUseShows.add(placeUseShow9);
		placeUseShows.add(placeUseShow10);
		
		return SUCCESS;
	}

	public ArrayList<PlaceUseShow> getPlaceUseShows() {
		return placeUseShows;
	}

	public void setPlaceUseShows(ArrayList<PlaceUseShow> placeUseShows) {
		this.placeUseShows = placeUseShows;
	}
	
	
}
