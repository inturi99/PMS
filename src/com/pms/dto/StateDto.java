/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class StateDto {
    private String stateId;
    
    private String stateName;

    public StateDto(String stateId, String stateName) {
        this.stateId = stateId;
        this.stateName = stateName;
    }

    @JsonProperty("StateId")
    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }
    @JsonProperty("StateName")
	public String getStateName() {
		return stateName;
	}

	public void setstateName(String stateName) {
		this.stateName = stateName;
	}
    

    }
