package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.Post;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.UUID;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

/**
 * This is the {@link Post}'s resource representation.
 * This class is responsible for expose the entity as a rest resource including
 * resource validations.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostResource {
  private UUID uuid;
  @NotEmpty
  @Length(min = 50, max = 300)
  private String text;
}
