package edu.nju.healthClub.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateChangeService {
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	
	public String dateToString (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		String dateString = sdf.format(date);
		return dateString;
	}
	
	public Date StringToDate (String dateString) {
		if (dateString == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		Date date = Calendar.getInstance().getTime();
		try {
			date = sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
