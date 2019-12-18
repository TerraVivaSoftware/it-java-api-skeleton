package com.ciandt.skeleton.core.business;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.service.PostService;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  public PostBusiness(PostService postService) {
    this.postService = postService;
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
  public void delete(UUID uuid) {
    this.postService.delete(uuid);
  }

  /**
   * Checks if the given {@link Post} exist.
   * @param uuid {@link UUID}
   */
  public void checkExist(UUID uuid) {
    if (!this.postService.exists(uuid)) {
      throw new IllegalArgumentException("The given Post does not exist.");
    }
  }

}
