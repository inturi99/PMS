package com.pms.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="State")
public class State {
@Id
@Column(name="stateId")
private Integer stateId;
@Column(name="stateName")
private String stateName;
@ManyToOne
private Country country;
public Integer getStateId() {
	return stateId;
}
public void setStateId(Integer stateId) {
	this.stateId = stateId;
}
public String getStateName() {
	return stateName;
}
public void setStateName(String stateName) {
	this.stateName = stateName;
}
public Country getCountry() {
	return country;
}
public void setCountry(Country country) {
	this.country = country;
}

}
