package com.ciandt.skeleton.config;

import com.vidolima.ditiow.aspect.DitiowAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configures a bean to enable Ditiow lib in the project. Ditiow will works as an aspect.
 *
 * @author Marcos A. Vidolin de Lima
 * @since Jan 13, 2020
 */
@Configuration
public class DitiowAspectConfig {

  /**
   * Configures the Ditiow aspect bean.
   *
   * @return Ditiow aspect
   */
  @Bean
  public DitiowAspect ditiow() {
    return new DitiowAspect();
  }

}
