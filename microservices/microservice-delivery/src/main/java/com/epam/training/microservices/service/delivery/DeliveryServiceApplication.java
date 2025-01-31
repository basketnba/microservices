package com.epam.training.microservices.service.delivery;

import com.epam.training.microservices.service.delivery.model.message.RecipeModel;
import com.epam.training.microservices.service.delivery.service.RecipeProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@EnableDiscoveryClient
@SpringBootApplication
public class DeliveryServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(DeliveryServiceApplication.class, args);
  }

  @Autowired
  private RecipeProcessor recipeProcessor;

  @Bean
  public Consumer<RecipeModel> deliveryNotificator() {
    return (recipe) -> {
      recipeProcessor.process(recipe);
    };
  }
}