package com.epam.training.microservices.service.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RecipesServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(RecipesServiceApplication.class, args);
  }
}