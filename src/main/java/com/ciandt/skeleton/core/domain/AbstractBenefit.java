package com.ciandt.skeleton.core.domain;

public class AbstractBenefit implements Benefit {

  private double value;
  private int quantity;

  @Override
  public double getTotal() {
    return value * quantity;
  }

}
