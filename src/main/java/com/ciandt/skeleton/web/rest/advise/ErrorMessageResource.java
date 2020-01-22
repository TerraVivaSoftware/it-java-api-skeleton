package com.ciandt.skeleton.web.rest.advise;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorMessageResource {

  private int status;
  private String error;
  private String message;
  private String path;

}
