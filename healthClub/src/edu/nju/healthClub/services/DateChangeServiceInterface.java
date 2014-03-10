package edu.nju.healthClub.services;

import java.util.Calendar;
import java.util.Date;

public interface DateChangeServiceInterface {

	/** 将日期转为yyyy-MM-dd格式的string
	 */
	public abstract String normalDateToString(Date date);

	/**
	 * 将yyyy-MM-dd的String转为date
	 * @param dateString
	 * @return 
	 */
	public abstract Date StringToNormalDate(String dateString);

	/**
	 * 输入日期格式为yyyy.MM,得到这个月的第一天
	 */
	public abstract Calendar getFirstDayCalendar(String managerDateString);

}