package edu.nju.healthClub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
@Entity()
@Table(name="user")
public class User {
	private String id;
	private String password;
	private String headerUrl;
	private String username;
	private String email;
	private String type;
	private int childCount;
	private Bank bank;
	private boolean isActive;
	
	private Set<Activity> activities = new HashSet<>();
	
	public User(){}
	public User(String id, String headerUrl, String username, String email, String type, int childCount, boolean isActive) {
		this.id = id;
		this.headerUrl = headerUrl;
		this.username = username;
		this.email = email;
		this.type = type;
		this.childCount = childCount;
		this.isActive = isActive;
	}
	
	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHeaderUrl() {
		return headerUrl;
	}

	public void setHeaderUrl(String headerUrl) {
		this.headerUrl = headerUrl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getChildCount() {
		return childCount;
	}

	public void setChildCount(int childCount) {
		this.childCount = childCount;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	@ManyToMany(mappedBy="users")
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id")
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	
	
	
}
