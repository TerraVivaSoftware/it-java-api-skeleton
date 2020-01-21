package com.ciandt.skeleton.web.rest.advise;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ErrorResource {

  private int status;
  private String error;
  private String message;
  private String path;

  public ErrorResource(int status, String error, String message, String path) {
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }

}
