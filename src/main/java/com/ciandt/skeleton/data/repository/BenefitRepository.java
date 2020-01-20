package com.ciandt.skeleton.data.repository;

import com.ciandt.skeleton.data.entity.BenefitEntity;
import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BenefitRepository extends JpaRepository<BenefitEntity, Long> {

  @Query(value = "select * from dual", nativeQuery = true)
  Collection<BenefitEntity> findAllCurrent();

}
