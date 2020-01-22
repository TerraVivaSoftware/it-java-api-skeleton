package com.ciandt.skeleton.web.rest.advise;

import lombok.Data;

@Data
public class ErrorMessageResource {

  private int status;
  private String error;
  private String message;
  private String path;

  public ErrorMessageResource(int status, String error, String message, String path) {
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

}
