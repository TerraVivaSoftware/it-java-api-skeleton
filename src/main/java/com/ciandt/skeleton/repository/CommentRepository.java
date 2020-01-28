package com.ciandt.skeleton.repository;

import com.ciandt.skeleton.core.domain.Comment;
import com.ciandt.skeleton.core.domain.Post;
import java.util.Collection;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link Comment}'s persistence layer.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

  /**
   * Finds a {@link Comment} by UUID.
   *
   * @param uuid {@link UUID}
   * @return Comment
   */
  Comment findOneByUuid(UUID uuid);

  /**
   * Finds all {@link Comment}s from a {@link Post} code.
   *
   * @return collection of {@link Comment}
   */
  Collection<Comment> findAllByPostCode(Long code);

}
