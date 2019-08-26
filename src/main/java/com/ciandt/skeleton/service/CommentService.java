package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the {@link Comment}'s service layer.
 * The service layer is responsible for handling infrastructure code such as:
 * repository, cache, ftp, queue, sms, etc.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Service
public class CommentService {

  private CommentRepository commentRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository) {
    this.commentRepository = commentRepository;
  }

  /**
   * Finds a {@link Comment} by id.
   * @param code
   * @return
   */
  public Comment findById(Long code) {
    return this.commentRepository.getOne(code);
  }

  /**
   * Creates a {@link Comment}.
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment create(Comment comment) {
    // check "code" to ensure a creation (this is a infra check not a business validation).
    if (comment.getCode() != null) {
      throw new IllegalArgumentException("This comment could not be created. The comment already have a code.");
    }
    return this.commentRepository.save(comment);
  }

  /**
   * Updates a {@link Comment}.
   * @param comment
   * @return comment
   */
  @Transactional
  public Comment update(Comment comment) {
    // check "code" to ensure an update (this is a infra check not a business validation).
    if (comment.getCode() == null) {
      throw new IllegalArgumentException("This comment could not be updated. The comment have no code.");
    }
    return this.commentRepository.save(comment);
  }

  /**
   * Deletes a {@link Comment}.
   * @param code
   */
  @Transactional
  public void delete(Long code) {
    this.commentRepository.deleteById(code);
  }

}