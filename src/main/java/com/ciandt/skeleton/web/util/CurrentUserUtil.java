package com.ciandt.skeleton.web.util;

import com.ciandt.skeleton.data.entity.UserEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CurrentUserUtil {

  /**
   * Gets the current user from request.
   * @return User
   */
  public UserEntity getUser() {
    UserEntity user = new UserEntity();
    user.setLogin("soandso");
    user.setName("So and So");
    user.setEmail("soandso@ciandt.com");
    return user;
  }

}
