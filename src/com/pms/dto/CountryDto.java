/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class CountryDto {
    private String countryId;
    
    private String countryName;

    public CountryDto(String countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;
    }

    @JsonProperty("CountryId")
    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
    @JsonProperty("CountryName")
	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
    

    }
