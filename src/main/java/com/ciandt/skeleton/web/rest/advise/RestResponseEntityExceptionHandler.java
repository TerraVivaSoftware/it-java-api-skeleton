package com.ciandt.skeleton.web.rest.advise;

import com.ciandt.skeleton.core.exception.BusinessException;
import com.ciandt.skeleton.core.exception.RemovePostWithCommentException;
import java.time.LocalDateTime;
import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler for APIs.
 *
 * @author mvidolin
 * @since Jan 21, 2020
 */
@Slf4j
@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private ResponseEntity<?> getStandardErrorHandler(final HttpStatus httpStatus, final Exception ex
      , final HttpServletRequest request) {

    CustomErrorMessageResource errorMessage = new CustomErrorMessageResource(
        LocalDateTime.now(),
        httpStatus.value(),
        httpStatus.getReasonPhrase(),
        ex.getMessage(),
        request.getRequestURI());

    return ResponseEntity.status(httpStatus.value()).body(errorMessage);
  }

  /**
   * The 409 (Conflict) status code indicates that the request could not be completed due to a
   * conflict with the current state of the target resource. This code is used in situations where
   * the user might be able to resolve the conflict and resubmit the request.
   *
   * @param ex the exception
   * @param request the given request
   * @return returns a message with error
   */
  @ExceptionHandler(value = {
      BusinessException.class,
      RemovePostWithCommentException.class
  })
  public ResponseEntity<?> handleConflict(Exception ex, HttpServletRequest request) {
    return this.getStandardErrorHandler(HttpStatus.CONFLICT, ex, request);
  }

  /**
   * The 404 (Not Found) status code indicates that the resource was not found.
   *
   * @param ex the exception
   * @param request the given request
   * @return returns a message with error
   */
  @ExceptionHandler(value = EntityNotFoundException.class)
  public ResponseEntity<?> handleNotFound(EntityNotFoundException ex, HttpServletRequest request) {
    return ResponseEntity.notFound().build();
  }

}
