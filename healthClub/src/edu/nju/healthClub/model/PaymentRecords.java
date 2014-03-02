package edu.nju.healthClub.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="payment")
public class PaymentRecords {
	private User user;
	private String reason;
	private int count;
	private Date date;
	
	public PaymentRecords(){}
	
	public PaymentRecords (String reason, int count, Date date) {
		this.reason = reason;
		this.count = count;
		this.date = date;
	}
	
	@EmbeddedId
	@ManyToOne(cascade=CascadeType.ALL,optional=false)
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@EmbeddedId
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

	@EmbeddedId
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
