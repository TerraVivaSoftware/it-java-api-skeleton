package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.core.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the {@link User}'s resource representation.
 * This class is responsible for expose the entity as a rest resource including
 * resource validations.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResource {
  private String login;
  private String name;
}
