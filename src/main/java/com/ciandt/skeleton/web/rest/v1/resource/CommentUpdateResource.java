package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vidolima.ditiow.resource.AbstractResource;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * This is the {@link Comment}'s resource representation for update. This class is responsible for
 * expose the entity as a rest resource including resource validations.
 *
 * @author mvidolin
 * @since Dez 18, 2019
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentUpdateResource extends AbstractResource<Comment> {

  @NotEmpty()
  @Length(min = 5, max = 300)
  private String content;
}
