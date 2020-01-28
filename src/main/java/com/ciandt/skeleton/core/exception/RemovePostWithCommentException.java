package com.ciandt.skeleton.core.exception;

/**
 * This error happens in an attempt to remove a {@link com.ciandt.skeleton.core.domain.Post} with
 * {@link com.ciandt.skeleton.core.domain.Comment}.
 *
 * @author mvidolin
 * @since Dez 24, 2019
 */
public class RemovePostWithCommentException extends BusinessException {

  public RemovePostWithCommentException(String message) {
    super(message);
  }

  public RemovePostWithCommentException(String message, Throwable cause) {
    super(message, cause);
  }

}
