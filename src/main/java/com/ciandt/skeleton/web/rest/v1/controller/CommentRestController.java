package com.ciandt.skeleton.web.rest.v1.controller;

import com.ciandt.skeleton.core.business.CommentBusiness;
import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.web.rest.v1.resource.CommentCreateResource;
import com.ciandt.skeleton.web.rest.v1.resource.CommentGetResource;
import com.ciandt.skeleton.web.rest.v1.resource.CommentUpdateResource;
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
 * REST controller that specifies the {@link Comment} operations through HTTP REST.
 *
 * @author mvidolin
 * @since Jul 31, 2019
 */
@RestController
public class CommentRestController extends RestControllerBase {

  private CommentBusiness commentBusiness;
  private CurrentUserUtil currentUserUtil;

  @Autowired
  public CommentRestController(CommentBusiness commentBusiness, CurrentUserUtil currentUserUtil) {
    this.commentBusiness = commentBusiness;
    this.currentUserUtil = currentUserUtil;
  }

  /**
   * Gets all {@link Comment}s from a {@link Post}.
   * @return ResponseEntity {@link CommentCreateResource}
   */
  @GetMapping(path = "/posts/{postUuid}/comments")
  @ResponseResource(CommentGetResource.class)
  public ResponseEntity<?> getAllByPost(@PathVariable UUID postUuid) {
    Collection<Comment> comments = this.commentBusiness.findAllByPost(postUuid);
    return ResponseEntity.ok(comments);
  }

  /**
   * Creates a {@link Comment}.
   * @return ResponseEntity {@link CommentCreateResource}
   */
  @PostMapping(path = "/posts/{postUuid}/comments")
  @ResponseResource(CommentGetResource.class)
  public ResponseEntity<?> create(@PathVariable UUID postUuid, @RequestBody @Valid CommentCreateResource resource) {
    Comment comment = resource.toDomain();
    comment.setAuthor(this.currentUserUtil.getUser());
    return ResponseEntity.ok(this.commentBusiness.create(postUuid, comment));
  }

  /**
   * Updates a {@link Comment}.
   * @return ResponseEntity {@link CommentCreateResource}
   */
  @PutMapping(path = "/comments/{uuid}")
  @ResponseResource(CommentGetResource.class)
  public ResponseEntity<?> update(@PathVariable UUID uuid, @RequestBody @Valid CommentUpdateResource resource) {
    Comment comment = resource.toDomain();
    comment.setAuthor(this.currentUserUtil.getUser());
    return ResponseEntity.ok(this.commentBusiness.update(uuid, comment));
  }

  /**
   * Deletes a {@link Comment}.
   */
  @DeleteMapping(path = "/comments/{uuid}")
  public ResponseEntity<?> delete(@PathVariable UUID uuid) {
    this.commentBusiness.delete(uuid);
    return ResponseEntity.noContent().build();
  }

}
