package com.epam.training.microservices.service.recipes.service.load;

import lombok.Data;

@Data
public class RecipeLineLoadModel {

  private String drug;
  private Long amount;
  private String instruction;
}