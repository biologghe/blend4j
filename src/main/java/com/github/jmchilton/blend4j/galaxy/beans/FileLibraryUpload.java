package com.github.jmchilton.blend4j.galaxy.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.File;


public class FileLibraryUpload extends LibraryUpload {
  private File file;
  
  public FileLibraryUpload() {
    super("upload_file");
  }
  
  public void setFile(final File file) {
    this.file = file;
  }
  
  @JsonIgnore
  public File getFile() {
    return file;
  }
  
}
