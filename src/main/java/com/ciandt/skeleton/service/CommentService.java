package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.repository.CommentRepository;
import java.util.Collection;
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
   * Finds all {@link Comment}s by a given {@link Post}.
   * @param post
   * @return comments
   */
  public Collection<Comment> findByPost(final Post post) {
    return this.commentRepository.findByPost(post);
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
   * @param comment
   */
  @Transactional
  public void delete(Comment comment) {
    this.commentRepository.delete(comment);
  }

}