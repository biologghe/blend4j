package com.github.jmchilton.blend4j.galaxy.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class HistoryContents extends History {
  private String type;

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  
}
