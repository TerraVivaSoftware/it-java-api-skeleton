package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.business.PostBusiness;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.web.rest.v1.assembler.PostAssembler;
import com.ciandt.skeleton.web.rest.v1.resource.PostResource;
import java.util.UUID;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
  private PostAssembler postAssembler;

  @Autowired
  public PostRestController(PostBusiness postBusiness, PostAssembler postAssembler) {
    this.postBusiness = postBusiness;
    this.postAssembler = postAssembler;
  }

  /**
   * Gets a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @GetMapping(path = "/posts/{uuid}")
  public ResponseEntity get(@PathVariable  UUID uuid) {
    Post post = this.postBusiness.findPostByUuid(uuid);
    return ResponseEntity.ok(this.postAssembler.fromDomain(post));
  }

  /**
   * Creates a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @PostMapping(path = "/posts")
  public ResponseEntity create(@Valid @RequestBody PostResource resource) {
    Post domain = this.postAssembler.fromResource(resource);
    Post post = this.postBusiness.create(domain);
    return ResponseEntity.ok(this.postAssembler.fromDomain(post));
  }

  /**
   * Updates a {@link Post}.
   * @return ResponseEntity {@link PostResource}
   */
  @PutMapping(path = "/posts/{uuid}")
  public ResponseEntity update(@PathVariable UUID uuid, @RequestBody @Valid PostResource resource) {
    resource.setUuid(uuid);
    Post domain = this.postAssembler.fromResource(resource);
    Post post = this.postBusiness.update(domain);
    return ResponseEntity.ok(this.postAssembler.fromDomain(post));
  }

  /**
   * Deletes a {@link Post}.
   */
  @DeleteMapping(path = "/posts/{uuid}")
  public ResponseEntity delete(@PathVariable UUID uuid) {
    this.postBusiness.delete(uuid);
    return ResponseEntity.noContent().build();
  }

}
