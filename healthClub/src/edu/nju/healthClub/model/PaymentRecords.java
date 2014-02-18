package edu.nju.healthClub.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PaymentRecords {
	private String userId;
	private String reason;
	private int count;
	private Date date;
	
	public PaymentRecords (String reason, int count, Date date) {
		this.reason = reason;
		this.count = count;
		this.date = date;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateShort = dateFormat.format(date);
		return dateShort;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
