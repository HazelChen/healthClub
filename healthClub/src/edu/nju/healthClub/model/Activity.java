package edu.nju.healthClub.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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

	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
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
