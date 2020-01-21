package com.ciandt.skeleton.web.rest.advise;

import com.ciandt.skeleton.core.exception.BusinessException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Global exception handler for APIs.
 *
 * @author mvidolin
 * @since Jan 21, 2020
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  private ErrorResource getErrorResource(final WebRequest request, final Exception ex) {
    HttpServletRequest req = ((ServletWebRequest) request).getRequest();
    String path = req.getRequestURI();
    int httpStatusCode = HttpStatus.CONFLICT.value();
    return new ErrorResource(httpStatusCode, ex.getCause().toString(), ex.getMessage(), path);
  }

  /**
   * The 409 (Conflict) status code indicates that the request could not be completed due to a
   * conflict with the current state of the target resource. This code is used in situations where
   * the user might be able to resolve the conflict and resubmit the request.
   */
  @ExceptionHandler(value = {BusinessException.class})
  @ResponseStatus(value = HttpStatus.CONFLICT)
  protected ResponseEntity<Object> handleConflict(Exception ex, WebRequest request) {
    ErrorResource error = getErrorResource(request, ex);
    return handleExceptionInternal(ex, error, new HttpHeaders(), HttpStatus.CONFLICT, request);
  }

}
