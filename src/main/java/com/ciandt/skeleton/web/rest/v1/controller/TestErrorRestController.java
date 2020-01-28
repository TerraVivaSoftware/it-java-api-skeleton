package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.exception.BusinessException;
import javax.persistence.EntityNotFoundException;
import javax.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for exception handler test purpose.
 *
 * @author mvidolin
 * @since Jan 24, 2020
 */
@RestController
public class TestErrorRestController extends RestControllerBase {

  @GetMapping(path = "/error")
  public ResponseEntity<?> error(@PathParam("code") int code) throws Exception {
    if (code == 1) {
      throw new BusinessException("It's a BusinessException!!!");
    } else if (code == 2) {
      throw new EntityNotFoundException("It's a EntityNotFoundException!!!");
    }
    throw new Exception("It's a generic. Exception");
  }

}
