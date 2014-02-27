package edu.nju.healthClub.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="activity")
public class Activity {
	private Date date;
	private String imageUrl;
	private String paragraph;
	
	private String id;
	private String title;
	private String place;
	private String coach;
	private boolean isScheduled;
	
	private Set<User> users = new HashSet<>();
	
	private ArrayList<String> userIds;
	
	public ArrayList<String> getUserIds() {
		return userIds;
	}

	public void setUserIds(ArrayList<String> userIds) {
		this.userIds = userIds;
	}
	
	public Activity(){}

	public Activity(String id, Date date, String imageUrl, String paragraph) {
		this.id = id;
		this.date = date;
		this.imageUrl = imageUrl;
		this.paragraph = paragraph;
	}
	
	public Activity(String id, Date date, String imageUrl, String paragraph, String title, String place, String coach, boolean isScheduled) {
		this.id = id;
		this.date = date;
		this.imageUrl = imageUrl;
		this.paragraph = paragraph;
		this.title = title;
		this.place = place;
		this.coach = coach;
		this.isScheduled = isScheduled;
	}
	//NEED
	public Activity(String id, Date date, String imageUrl, String paragraph, String title, String place, String coach) {
		this.id = id;
		this.date = date;
		this.imageUrl = imageUrl;
		this.paragraph = paragraph;
		this.title = title;
		this.place = place;
		this.coach = coach;
	}
	
	public Activity(Date date, String paragraph, String title, String place, String coach) {
		this.date = date;
		this.paragraph = paragraph;
		this.title = title;
		this.place = place;
		this.coach = coach;
	}
	
	public Activity(String id, Date date, String imageUrl, String title, String place, String coach, ArrayList<String> userIds) {
		this.id = id;
		this.date = date;
		this.imageUrl = imageUrl;
		this.title = title;
		this.place = place;
		this.coach = coach;
		this.userIds = userIds;
	}
	
	@Id
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Date getDate () {
		return date;
	}
	
	public String getImageUrl () {
		return imageUrl;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public boolean getIsScheduled() {
		return isScheduled;
	}

	public void setIsScheduled(boolean isScheduled) {
		this.isScheduled = isScheduled;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}

	public String getParagraph () {
		return paragraph;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCoach() {
		return coach;
	}

	public void setCoach(String coach) {
		this.coach = coach;
	}

	@ManyToMany(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinTable(
			name="activityreserve",
			joinColumns=@JoinColumn(name="activityId", referencedColumnName="id"),
			inverseJoinColumns=@JoinColumn(name="userid", referencedColumnName="id")
			)
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	
}
