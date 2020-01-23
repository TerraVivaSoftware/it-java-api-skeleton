package com.ciandt.skeleton.service;

import com.ciandt.skeleton.converter.benefit.BenefitConverter;
import com.ciandt.skeleton.core.domain.Benefit;
import com.ciandt.skeleton.data.entity.BenefitEntity;
import com.ciandt.skeleton.data.repository.BenefitRepository;
import java.util.Collection;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

public class BenefitService {

  private BenefitRepository repository;
  private BenefitConverter converter;

  @Autowired
  public BenefitService(BenefitRepository repository, BenefitConverter converter) {
    this.repository = repository;
    this.converter = converter;
  }

  public Collection<Benefit> findAllCurrent() {
    Collection<BenefitEntity> entities = this.repository.findAllCurrent();
    return this.converter.toDomain(entities);
  }

}
