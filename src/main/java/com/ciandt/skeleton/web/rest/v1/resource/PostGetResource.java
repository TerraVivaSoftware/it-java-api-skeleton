package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.Post;
import com.ciandt.skeleton.core.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vidolima.ditiow.resource.AbstractResource;
import java.util.Date;
import java.util.UUID;
import lombok.Data;

/**
 * This is the {@link Post}'s resource representation for visualization.
 * This class is responsible for expose the entity as a rest resource including.
 *
 * @author mvidolin
 * @since Dez 19, 2019
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostGetResource extends AbstractResource<Post> {
  private UUID uuid;
  private User author;
  private String title;
  private String content;
  private Date publishedAt;
  private Date editedAt;

  public PostGetResource() {
    super(Post.class);
  }
}
