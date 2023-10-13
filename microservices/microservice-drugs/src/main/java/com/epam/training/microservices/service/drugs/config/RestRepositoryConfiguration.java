package com.epam.training.microservices.service.drugs.config;

import com.epam.training.microservices.service.drugs.model.Drug;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Configuration
public class RestRepositoryConfiguration implements RepositoryRestConfigurer {

  @Override
  public void configureRepositoryRestConfiguration(
      RepositoryRestConfiguration config, CorsRegistry cors) {
    config.exposeIdsFor(Drug.class);
  }
}