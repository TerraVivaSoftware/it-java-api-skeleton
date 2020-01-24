package com.ciandt.skeleton.core.business;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.service.CommentService;
import java.util.Collection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Comment}'s business layer. The business layer is responsible for handling business logic
 * such as: ensure business flow, validations, throw business exceptions, etc.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Component
public class CommentBusiness {

  private CommentService commentService;
  private PostBusiness postBusiness;

  @Autowired
  public CommentBusiness(CommentService commentService, PostBusiness postBusiness) {
    this.commentService = commentService;
    this.postBusiness = postBusiness;
  }

  /**
   * Finds all {@link Comment}s from a {@link Post}.
   *
   * @param postUuid {@link UUID}
   * @return collection of {@link Comment}
   */
  public Collection<Comment> findAllByPost(UUID postUuid) {
    Post post = this.postBusiness.findPostByUuid(postUuid);
    Collection<Comment> comments = this.commentService.findAllByPost(post);
    return comments;
  }

  /**
   * Creates a {@link Comment}.
   *
   * @param postUuid {@link UUID}
   * @param comment {@link Comment}
   * @return comment
   */
  @Transactional
  public Comment create(UUID postUuid, Comment comment) {
    Post post = this.postBusiness.findPostByUuid(postUuid);
    comment.setPostCode(post.getCode());
    return this.commentService.create(comment);
  }

  /**
   * Updates a {@link Comment}.
   *
   * @return comment
   */
  @Transactional
  public Comment update(UUID uuid, Comment comment) {
    Comment tobeUpdated = this.commentService.findByUuid(uuid);
    tobeUpdated.applyValues(comment);
    return this.commentService.update(tobeUpdated);
  }

  /**
   * Deletes a {@link Comment}.
   *
   * @param uuid {@link UUID}
   */
  @Transactional
  public void delete(UUID uuid) {
    this.commentService.delete(uuid);
  }

}
