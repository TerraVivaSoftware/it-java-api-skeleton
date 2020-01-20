package com.ciandt.skeleton.service;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.repository.PostResporitory;
import java.util.Collection;
import java.util.UUID;
import javax.persistence.EntityNotFoundException;
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
   * Search {@link Post}.
   * @return post {@link Post}
   */
  // TODO: filter by creation?
  public Collection<Post> search() {
    return this.postResporitory.findAll();
  }

  /**
   * Returns whether an entity with the given {@link UUID} exists.
   * @param uuid {@link UUID}
   * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
   */
  public boolean exists(UUID uuid) {
    if (uuid == null) {
      return false;
    }
    return this.postResporitory.existsPostByUuid(uuid);
  }

  /**
   * Finds a {@link Post} by {@link UUID}.
   * @param uuid {@link UUID}
   * @return {@link Post}
   */
  public Post findByUuid(UUID uuid) {
    Post post = this.postResporitory.findOnePostByUuid(uuid);
    if (post == null) {
      throw new EntityNotFoundException("No 'Post' found with uuid " + uuid);
    }
    return post;
  }

  /**
   * Creates a {@link Post}.
   * @param post
   * @return post
   */
  @Transactional
  public Post create(Post post) {
    // check "code" to ensure a creation (this is a infra check not a business validation).
    if (post.getCode() != null) {
      throw new IllegalArgumentException("This comment could not be created. The comment already have a code.");
    }
    return this.postResporitory.save(post);
  }

  /**
   * Updates a {@link Post}.
   * @param post
   * @return post
   */
  @Transactional
  public Post update(Post post) {
    // check "code" to ensure an update (this is a infra check not a business validation).
    if (post.getCode() == null) {
      throw new IllegalArgumentException("This comment could not be updated. The comment have no code.");
    }
    return this.postResporitory.save(post);
  }

  /**
   * Deletes a {@link Post}.
   * @param uuid
   */
  @Transactional
  public void delete(UUID uuid) {
    Post post = this.findByUuid(uuid);
    this.postResporitory.delete(post);
  }

}
