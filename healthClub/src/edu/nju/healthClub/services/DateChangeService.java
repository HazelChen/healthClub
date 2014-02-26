package edu.nju.healthClub.services;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChangeService {
	
	public String dateToString (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = sdf.format(date);
		return dateString;
	}
}
