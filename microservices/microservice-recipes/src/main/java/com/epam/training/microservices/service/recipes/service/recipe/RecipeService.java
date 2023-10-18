package com.epam.training.microservices.service.recipes.service.recipe;

import com.epam.training.microservices.service.recipes.model.Doctor;
import com.epam.training.microservices.service.recipes.model.Recipe;
import com.epam.training.microservices.service.recipes.model.Recipient;
import com.epam.training.microservices.service.recipes.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {

  private final RecipeRepository recipeRepository;
  private final StreamBridge streamBridge;

  public Recipe save(Recipe recipe) {
    final Message<Recipe> message = MessageBuilder.withPayload(recipe).build();
    streamBridge.send("deliveryNotificator-out-0", message);

    return recipeRepository.save(recipe);
  }

  public Optional<Recipe> find(Doctor doctor, Recipient recipient, LocalDate issueDate) {
    return recipeRepository.findRecipeByDoctorAndRecipientAndIssueDate(doctor, recipient,
        issueDate);
  }
}