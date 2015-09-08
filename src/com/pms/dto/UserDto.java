package com.pms.dto;

import org.codehaus.jackson.annotate.JsonProperty;


public class UserDto {
	private String userId;
	private String userName;
	private String dob;
	private String countryId;
	private String stateId;
	@JsonProperty("UserId")
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	@JsonProperty("UserName")
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	@JsonProperty("Dob")
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	@JsonProperty("CountryId")
	public String getCountryId() {
		return countryId;
	}
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}
	@JsonProperty("StateId")
	public String getStateId() {
		return stateId;
	}
	public void setStateId(String stateId) {
		this.stateId = stateId;
	}
	
}
