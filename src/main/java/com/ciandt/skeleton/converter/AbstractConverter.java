package com.ciandt.skeleton.converter;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.stream.Collectors;

public class AbstractConverter<D, E> implements Converter<D, E> {

  private Class<D> domainClass;

  private Class<E> entityClass;

  private Mapper mapper;

  /**
   * Default constructor.
   */
  public AbstractConverter() {
    this.mapper = DozerBeanMapperBuilder.buildDefault();

    this.domainClass = ((Class<D>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[0]);

    this.entityClass = ((Class<E>) ((ParameterizedType) getClass()
        .getGenericSuperclass()).getActualTypeArguments()[1]);
  }

  public D toDomain(E entity) {
    return this.mapper.map(entity, this.domainClass);
  }

  public Collection<D> toDomain(Collection<E> entities) {
    return entities.stream().map(this::toDomain)
        .collect(Collectors.toList());
  }

  public E toEntity(D domain) {
    return this.mapper.map(domain, this.entityClass);
  }

  public Collection<E> toEntity(Collection<D> domains) {
    return domains.stream().map(this::toEntity)
        .collect(Collectors.toList());
  }

}
