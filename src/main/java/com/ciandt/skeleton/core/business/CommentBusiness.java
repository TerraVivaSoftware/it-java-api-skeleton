package com.ciandt.skeleton.core.business;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.service.CommentService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Comment}'s business layer.
 * The business layer is responsible for handling business logic such as:
 * ensure business flow, validations, throw business exceptions, etc.
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
   * Creates a {@link Comment}.
   * @param postUuid {@link UUID}
   * @param comment {@link Comment}
   * @return comment
   */
  @Transactional
  public Comment create(UUID postUuid, Comment comment) {
    this.postBusiness.checkExist(postUuid);
    return this.commentService.create(comment);
  }

  /**
   * Updates a {@link Comment}.
   * @param comment
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
   * @param uuid {@link UUID}
   */
  @Transactional
  public void delete(UUID uuid) {
    this.commentService.delete(uuid);
  }

}
