package com.epam.training.microservices.service.recipes.service.load;

import com.google.common.collect.Lists;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class RecipeLoadModel {

  private LocalDate issueDate;
  private Person recipient;
  private List<RecipeLineLoadModel> content = Lists.newArrayList();
}