package com.pms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
@Id
@Column(name="userId")
private Integer userId;
@Column(name="userName")
private String userName;
@Column(name="dob")
private String dob;
@OneToOne
private Country country;
@OneToOne
private State state;
public User() {
}
User(int userId, String userName, String dob, Country country, State state) {
	this.userId = userId;
	this.userName = userName;
	this.dob = dob;
	this.country = country;
	this.state = state;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getDob() {
	return dob;
}
public void setDob(String dob) {
	this.dob = dob;
}
public Country getCountry() {
	return country;
}
public void setCountry(Country country) {
	this.country = country;
}
public State getState() {
	return state;
}
public void setState(State state) {
	this.state = state;
}


}
