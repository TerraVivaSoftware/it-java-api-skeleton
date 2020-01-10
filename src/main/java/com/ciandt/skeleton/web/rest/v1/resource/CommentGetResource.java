package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vidolima.ditiow.resource.AbstractResource;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentGetResource extends AbstractResource<Comment> {
  private UUID uuid;
  private UserResource author;
  private Date publishedAt;
  private String content;

  public CommentGetResource() {
    super(Comment.class);
  }
}
