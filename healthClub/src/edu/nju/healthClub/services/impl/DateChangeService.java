package edu.nju.healthClub.services.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import edu.nju.healthClub.services.DateChangeServiceInterface;

public class DateChangeService implements DateChangeServiceInterface {
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.DateChangeServiceInterface#normalDateToString(java.util.Date)
	 */
	@Override
	public String normalDateToString (Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		String dateString = sdf.format(date);
		return dateString;
	}
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.DateChangeServiceInterface#StringToNormalDate(java.lang.String)
	 */
	@Override
	public Date StringToNormalDate (String dateString) {
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
	
	/* (non-Javadoc)
	 * @see edu.nju.healthClub.services.impl.DateChangeServiceInterface#getFirstDayCalendar(java.lang.String)
	 */
	@Override
	public Calendar getFirstDayCalendar(String managerDateString) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		if (managerDateString == null) {
			return calendar;
		}
		int year = Integer.parseInt(managerDateString.substring(0,4));
		int month = 0;
		if (managerDateString.length() > 6) {
			month = Integer.parseInt(managerDateString.substring(5,7));
		} else {
			month = Integer.parseInt(managerDateString.substring(5,6));
		}
		calendar.set(Calendar.YEAR, year);
		calendar.set(Calendar.MONTH, month - 1);
		return calendar;
	}
}
