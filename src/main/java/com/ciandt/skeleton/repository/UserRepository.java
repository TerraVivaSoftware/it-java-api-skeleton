package com.ciandt.skeleton.repository;

import com.ciandt.skeleton.core.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * {@link User}'s persistence layer.
 *
 * @author mvidolin
 * @since Jul 29, 2019
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

}
