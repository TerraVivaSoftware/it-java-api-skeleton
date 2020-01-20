package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.business.PostBusiness;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.core.exception.BusinessException;
import com.ciandt.skeleton.web.rest.v1.resource.PostCreateResource;
import com.ciandt.skeleton.web.rest.v1.resource.PostGetResource;
import com.ciandt.skeleton.web.rest.v1.resource.PostSearchResource;
import com.ciandt.skeleton.web.rest.v1.resource.PostUpdateResource;
import com.ciandt.skeleton.web.util.CurrentUserUtil;
import com.vidolima.ditiow.annotation.ResponseResource;
import java.util.Collection;
import java.util.UUID;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller that specifies the {@link Post} operations through HTTP REST.
 *
 * @author mvidolin
 * @since Jul 31, 2019
 */
@RestController
public class PostRestController extends RestControllerBase {

  private PostBusiness postBusiness;
  private CurrentUserUtil currentUserUtil;

  @Autowired
  public PostRestController(PostBusiness postBusiness, CurrentUserUtil currentUserUtil) {
    this.postBusiness = postBusiness;
    this.currentUserUtil = currentUserUtil;
  }

  /**
   * Gets a {@link Post}.
   * @return ResponseEntity {@link PostUpdateResource}
   */
  @GetMapping(path = "/posts/{uuid}")
  @ResponseResource(PostGetResource.class)
  public ResponseEntity<?> get(@PathVariable UUID uuid) {
    Post post = this.postBusiness.findPostByUuid(uuid);
    return ResponseEntity.ok(post);
  }

  /**
   * Gets a {@link Post}.
   * @return ResponseEntity {@link PostUpdateResource}
   */
  @GetMapping(path = "/posts")
  @ResponseResource(PostSearchResource.class)
  public ResponseEntity<?> search() {
    Collection<Post> posts = this.postBusiness.search();
    return ResponseEntity.ok(posts);
  }

  /**
   * Creates a {@link Post}.
   * @return ResponseEntity {@link PostUpdateResource}
   */
  @PostMapping(path = "/posts")
  @ResponseResource(PostGetResource.class)
  public ResponseEntity<?> create(@Valid @RequestBody PostCreateResource resource) {
    Post post = resource.toDomain();
    post.setAuthor(this.currentUserUtil.getUser());
    return ResponseEntity.ok(this.postBusiness.create(post));
  }

  /**
   * Updates a {@link Post}.
   * @return ResponseEntity {@link PostUpdateResource}
   */
  @PutMapping(path = "/posts/{uuid}")
  @ResponseResource(PostGetResource.class)
  public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody @Valid PostUpdateResource resource) {
    Post post = resource.toDomain();
    post.setUuid(uuid);
    post.setAuthor(this.currentUserUtil.getUser());
    return ResponseEntity.ok(this.postBusiness.update(post));
  }

  /**
   * Deletes a {@link Post}.
   */
  @DeleteMapping(path = "/posts/{uuid}")
  public ResponseEntity<?> delete(@PathVariable UUID uuid) throws BusinessException {
    this.postBusiness.delete(uuid);
    return ResponseEntity.noContent().build();
  }

}
