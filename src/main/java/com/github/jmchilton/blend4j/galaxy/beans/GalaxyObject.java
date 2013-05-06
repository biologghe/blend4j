package com.github.jmchilton.blend4j.galaxy.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class GalaxyObject {
  private String id;
  private String url;
  
  @JsonProperty("id")
  public void setId(String id) {
    this.id = id;
  }

  @JsonProperty("url")
  public void setUrl(String url) {
    this.url = url;
  }

  @JsonIgnore
  public String getUrl() {
    return url;
  }
  
  @JsonIgnore
  public String getId() {
    return id;
  }
  
}
