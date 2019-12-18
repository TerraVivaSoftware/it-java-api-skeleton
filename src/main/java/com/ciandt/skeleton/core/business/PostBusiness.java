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
   * Finds a {@link Post} by id (code).
   * @param code
   * @return post
   */
  public Post findPostById(Long code) {
    return this.postService.findById(code);
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
    // TODO: validations?
    return this.postService.update(post);
  }

  /**
   * Deletes a {@link Post}.
   * @param post
   */
  @Transactional
  public void delete(Post post) {
    this.postService.delete(post);
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
