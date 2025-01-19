package com.epam.training.microservices.service.recipes.service.recipe;

import static com.google.common.base.Preconditions.checkArgument;

import com.epam.training.microservices.service.recipes.model.Doctor;
import com.epam.training.microservices.service.recipes.model.OutgoingRecipe;
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
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class RecipeService {

  private final RecipeRepository recipeRepository;
  private final OutgoingRecipeService outgoingRecipeService;
//  private final StreamBridge streamBridge;

  @Transactional
  public Recipe save(Recipe recipe) {
//    final Message<Recipe> message = MessageBuilder.withPayload(recipe).build();
//    streamBridge.send("deliveryNotificator-out-0", message);

    final Recipe savedRecipe = recipeRepository.save(recipe);

    final OutgoingRecipe outgoingRecipe = outgoingRecipeService.findOrCreate(savedRecipe);
    checkArgument(outgoingRecipe != null, "Outgoing recipe wasn't created");

    return savedRecipe;
  }

  public Optional<Recipe> find(Doctor doctor, Recipient recipient, LocalDate issueDate) {
    return recipeRepository.findRecipeByDoctorAndRecipientAndIssueDate(doctor, recipient,
        issueDate);
  }
}