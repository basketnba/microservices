package com.epam.training.microservices.service.recipes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RecipesServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(RecipesServiceApplication.class, args);
  }

//    @Bean
//    public Consumer<String> deliveryNotificator() {
//        return (recipe) -> {};
//    }
}