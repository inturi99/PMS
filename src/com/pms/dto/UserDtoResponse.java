package com.pms.dto;

import org.codehaus.jackson.annotate.JsonProperty;

public class UserDtoResponse {
    
    
    private UserDto records;
    
    
    public UserDtoResponse(){}

   

    public UserDtoResponse(UserDto records) {
           this.records = records;
    }

    @JsonProperty("data")
    public UserDto getRecords() {
        return records;
    }

    public void setRecords(UserDto records) {
        this.records = records;
    }   

   }
