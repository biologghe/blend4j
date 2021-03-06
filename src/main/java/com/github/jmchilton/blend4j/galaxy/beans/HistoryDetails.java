package com.github.jmchilton.blend4j.galaxy.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HistoryDetails extends History {
  private String state;
  private Map<String, List<String>> stateIds = new HashMap<String, List<String>>();

  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }
  
  @JsonProperty("state_ids")
  public void setStateIds(final Map<String, List<String>> stateIds) {
    this.stateIds = stateIds;
  }
  
  public Map<String, List<String>> getStateIds() {
    return stateIds;
  }

  
}
