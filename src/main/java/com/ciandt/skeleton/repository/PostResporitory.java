package com.ciandt.skeleton.repository;

import com.ciandt.skeleton.core.domain.Post;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Post}'s persistence layer.
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Repository
public interface PostResporitory extends JpaRepository<Post, Long> {

  /**
   * Returns whether an entity with the given {@link UUID} exists.
   * @param uuid {@link UUID}
   * @return {@literal true} if an entity with the given {@link UUID} exists, {@literal false} otherwise.
   */
  boolean existsPostByUuid(UUID uuid);

}
