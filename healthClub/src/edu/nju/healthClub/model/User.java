package edu.nju.healthClub.model;

public class User {
	private String id;
	private String headerUrl;
	private String username;
	private String email;
	private String type;
	private int childCount;
	private boolean isActive;
	
	public User(String id, String headerUrl, String username, String email, String type, int childCount, boolean isActive) {
		this.id = id;
		this.headerUrl = headerUrl;
		this.username = username;
		this.email = email;
		this.type = type;
		this.childCount = childCount;
		this.isActive = isActive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	
	
}
