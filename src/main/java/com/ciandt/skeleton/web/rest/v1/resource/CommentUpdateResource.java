package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.Date;
import java.util.UUID;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

/**
 * This is the {@link Comment}'s resource representation for update.
 * This class is responsible for expose the entity as a rest resource including
 * resource validations.
 *
 * @author mvidolin
 * @since Dez 18, 2019
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommentUpdateResource {
  private UUID uuid;
  @NotEmpty
  @Min(value = 1)
  @Max(value = 200)
  private String text;
}
