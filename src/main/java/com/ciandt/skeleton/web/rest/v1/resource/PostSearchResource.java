package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vidolima.ditiow.resource.AbstractResource;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.Data;

/**
 * This is the {@link Post}'s resource representation for visualization. This class is responsible
 * for expose the entity as a rest resource including.
 *
 * @author mvidolin
 * @since Jan 15, 2020
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostSearchResource extends AbstractResource<Post> {

  private UUID uuid;
  private String title;
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd hh:mm:ss")
  private LocalDateTime publishedAt;
}
