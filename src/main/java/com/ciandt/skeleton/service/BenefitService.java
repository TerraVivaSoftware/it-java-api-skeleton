package com.ciandt.skeleton.service;

import com.ciandt.skeleton.data.entity.BenefitEntity;
import com.ciandt.skeleton.data.repository.BenefitRepository;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;

public class BenefitService {

  private BenefitRepository repository;

  @Autowired
  public BenefitService(BenefitRepository repository) {
    this.repository = repository;
  }

  public Collection<BenefitEntity> findAllCurrent() {
    return this.repository.findAllCurrent();
  }

}
