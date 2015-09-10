/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


public class UserDtoListResponse {
    
   
    private List<UserDto> records;
    
    private int totalRecordCount;
    
       public UserDtoListResponse(List<UserDto> records,int totalRecordCount) {
        this.records = records;
        this.totalRecordCount = totalRecordCount;
    }

    

    @JsonProperty("data")
    public List<UserDto> getRecords() {
        return records;
    }

    public void setRecords(List<UserDto> records) {
        this.records = records;
    }

    @JsonProperty("recordsTotal")
    public int getTotalRecordCount() {
        return totalRecordCount;
    }

    public void setTotalRecordCount(int totalRecordCount) {
        this.totalRecordCount = totalRecordCount;
    } 

   
}
