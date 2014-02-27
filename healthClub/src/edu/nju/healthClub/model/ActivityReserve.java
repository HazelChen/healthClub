package edu.nju.healthClub.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="activityReserve")
public class ActivityReserve implements Serializable{
	private User user;
	private Activity activity;
	private Date date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="userId")
	@EmbeddedId
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="activityId")
	@EmbeddedId
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
