package com.pms.pojo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Country")
public class Country {
@Id
@Column(name="countryId")
private int countryId;
@Column(name="countryName")
private String countryName;
@OneToMany(mappedBy="country")
private List<State> states;
public Integer getCountryId() {
	return countryId;
}
public void setCountryId(Integer countryId) {
	this.countryId = countryId;
}
public String getCountryName() {
	return countryName;
}
public void setCountryName(String countryName) {
	this.countryName = countryName;
}
public List<State> getStates() {
	return states;
}
public void setStates(List<State> states) {
	this.states = states;
}

}
