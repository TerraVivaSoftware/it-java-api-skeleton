package com.ciandt.skeleton.core.business;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.core.exception.BusinessException;
import com.ciandt.skeleton.service.PostService;
import java.util.Collection;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * {@link Post}'s business layer.
 * The business layer is responsible for handling business logic such as:
 * ensure business flow, validations, throw business exceptions, etc.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Component
public class PostBusiness {

  private PostService postService;
  private CommentBusiness commentBusiness;

  @Autowired
  public PostBusiness(PostService postService, @Lazy CommentBusiness commentBusiness) {
    this.postService = postService;
    this.commentBusiness = commentBusiness;
  }

  /**
   * Search {@link Post}.
   * @return post {@link Post}
   */
  // TODO: filter by creation?
  public Collection<Post> search() {
    return this.postService.search();
  }

  /**
   * Finds a {@link Post} by {@link UUID}.
   * @param uuid {@link UUID}
   * @return post {@link Post}
   */
  public Post findPostByUuid(UUID uuid) {
    return postService.findByUuid(uuid);
  }

  /**
   * Creates a {@link Post}.
   * @param post
   * @return post
   */
  @Transactional
  public Post create(Post post) {
    // TODO: validations?
    return this.postService.create(post);
  }

  /**
   * Updates a {@link Post}.
   * @param post
   * @return post
   */
  @Transactional
  public Post update(Post post) {
    Post postToBeUpdated = this.findPostByUuid(post.getUuid());
    postToBeUpdated.applyValues(post);
    return this.postService.update(postToBeUpdated);
  }

  /**
   * Deletes a {@link Post}.
   * @param uuid
   */
  @Transactional
  public void delete(UUID uuid) throws BusinessException {
    if (this.hasComments(uuid)) {
      throw new BusinessException("The Post " + uuid + " has associated comments end cannot be removed.");
    }
    this.postService.delete(uuid);
  }

  /**
   * Checks if the given {@link Post} exist.
   * @param uuid {@link UUID}
   */
  public void checkExist(UUID uuid) {
    if (!this.postService.exists(uuid)) {
      throw new IllegalArgumentException("The Post " + uuid + " does not exist.");
    }
  }

  /**
   * Checks if the {@link Post} has any {@link Comment}.
   * @param uuid {@link UUID}
   * @return true if has comment
   */
  public boolean hasComments(UUID uuid) {
    Collection<Comment> comments = this.commentBusiness.findAllByPost(uuid);
    return !comments.isEmpty();
  }

}
