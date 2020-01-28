package com.ciandt.skeleton.web.rest.v1.resource;

import com.ciandt.skeleton.data.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vidolima.ditiow.resource.AbstractResource;
import lombok.Data;

/**
<<<<<<< HEAD
 * This is the {@link UserEntity}'s resource representation.
 * This class is responsible for expose the entity as a rest resource including
 * resource validations.
=======
 * This is the {@link User}'s resource representation. This class is responsible for expose the
 * entity as a rest resource including resource validations.
>>>>>>> 76fb19f786703d2598b44481f28d34b2f41233fe
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
<<<<<<< HEAD
public class UserResource extends AbstractResource<UserEntity> {
=======
public class UserResource extends AbstractResource<User> {

>>>>>>> 76fb19f786703d2598b44481f28d34b2f41233fe
  private String login;
  private String name;
}
