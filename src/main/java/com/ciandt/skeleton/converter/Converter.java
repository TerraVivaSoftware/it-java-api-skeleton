package com.ciandt.skeleton.converter;

import java.util.Collection;

public interface Converter<D, E> {

  D toDomain(E entity);

  Collection<D> toDomain(Collection<E> entity);

  E toEntity(D domain);

  Collection<E> toEntity(Collection<D> domain);

}