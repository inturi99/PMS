/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class CountryDtoResponse {
    
    
    private List<CountryDto> options;
    
  
    public CountryDtoResponse(List<CountryDto> options) {
        this.options = options;
    }

   
       @JsonProperty("Options")
    public List<CountryDto> getOptions() {
        return options;
    }

    public void setOptions(List<CountryDto> options) {
        this.options = options;
    }

    
    
}
