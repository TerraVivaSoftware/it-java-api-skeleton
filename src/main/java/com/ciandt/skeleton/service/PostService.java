package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.repository.PostResporitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the {@link Post}'s service layer.
 * The service layer is responsible for handling infrastructure code such as:
 * repository, cache, ftp, queue, sms, etc.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Service
public class PostService {

  private PostResporitory postResporitory;

  @Autowired
  public PostService(PostResporitory postResporitory) {
    this.postResporitory = postResporitory;
  }

  /**
   * Finds a {@link Post} by id (code).
   * @param code
   * @return post
   */
  public Post findById(Long code) {
    return this.postResporitory.getOne(code);
  }

  /**
   * Creates a {@link Post}.
   * @param post
   * @return post
   */
  @Transactional
  public Post create(Post post) {
    return this.postResporitory.save(post);
  }

  /**
   * Updates a {@link Post}.
   * @param post
   * @return post
   */
  @Transactional
  public Post update(Post post) {
    return this.postResporitory.save(post);
  }

  /**
   * Deletes a {@link Post}.
   * @param post
   */
  @Transactional
  public void delete(Post post) {
    this.postResporitory.delete(post);
  }

}
