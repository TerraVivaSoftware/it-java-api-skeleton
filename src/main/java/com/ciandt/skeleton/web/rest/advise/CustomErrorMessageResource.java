package com.ciandt.skeleton.web.rest.advise;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomErrorMessageResource {

  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  LocalDateTime timestamp;
  private int status;
  private String error;
  private String message;
  private String path;

}
