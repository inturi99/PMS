/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.dto;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class StateDtoResponse {
    
    
    private List<StateDto> options;
    
  
    public StateDtoResponse(List<StateDto> options) {
        this.options = options;
    }

   
       @JsonProperty("Options")
    public List<StateDto> getOptions() {
        return options;
    }

    public void setOptions(List<StateDto> options) {
        this.options = options;
    }

    
    
}
