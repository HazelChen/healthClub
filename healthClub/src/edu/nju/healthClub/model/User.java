package edu.nju.healthClub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
	private int suspendCount;
	
	private Set<PaymentRecords> paymentRecords = new HashSet<>();
	private Set<Activity> activities = new HashSet<>();
	
	public void cancelReverse(Activity activity) {
		activities.remove(activity);
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

	
	public int getSuspendCount() {
		return suspendCount;
	}
	public void setSuspendCount(int suspendCount) {
		this.suspendCount = suspendCount;
	}
	
	@ManyToMany(mappedBy="users", fetch=FetchType.EAGER)
	public Set<Activity> getActivities() {
		return activities;
	}

	public void setActivities(Set<Activity> activities) {
		this.activities = activities;
	}
	
	@OneToOne(optional = true, cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name = "bank")
	public Bank getBank() {
		return bank;
	}
	public void setBank(Bank bank) {
		this.bank = bank;
	}
	
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
	public Set<PaymentRecords> getPaymentRecords() {
		return paymentRecords;
	}
	public void setPaymentRecords(Set<PaymentRecords> paymentRecords) {
		this.paymentRecords = paymentRecords;
	}
}
