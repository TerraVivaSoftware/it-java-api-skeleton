package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.repository.CommentRepository;
import java.util.Collection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the {@link Comment}'s service layer. The service layer is responsible for handling
 * infrastructure code such as: repository, cache, ftp, queue, sms, etc.
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
   * Finds a {@link Comment} by UUID.
   *
   * @param uuid {@link UUID}
   * @return Comment
   */
  public Comment findByUuid(UUID uuid) {
    return this.commentRepository.findOneByUuid(uuid);
  }

  /**
   * Creates a {@link Comment}.
   *
   * @return comment
   */
  @Transactional
  public Comment create(Comment comment) {
    // check "code" to ensure a creation (this is a infra check not a business validation).
    if (comment.getCode() != null) {
      throw new IllegalArgumentException(
          "This comment could not be created. The comment already have a code.");
    }
    return this.commentRepository.save(comment);
  }

  /**
   * Updates a {@link Comment}.
   *
   * @return comment
   */
  @Transactional
  public Comment update(Comment comment) {
    // check "code" to ensure an update (this is a infra check not a business validation).
    if (comment.getCode() == null) {
      throw new IllegalArgumentException(
          "This comment could not be updated. The comment have no code.");
    }
    return this.commentRepository.save(comment);
  }

  /**
   * Deletes a {@link Comment}.
   *
   * @param uuid {@link UUID}
   */
  @Transactional
  public void delete(UUID uuid) {
    Comment comment = this.findByUuid(uuid);
    this.commentRepository.delete(comment);
  }

  /**
   * Finds all {@link Comment}s from a {@link Post}.
   *
   * @param post {@link UUID}
   * @return collection of {@link Comment}
   */
  public Collection<Comment> findAllByPost(final Post post) {
    return this.commentRepository.findAllByPostCode(post.getCode());
  }
}