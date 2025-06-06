package com.epam.training.microservices.service.recipes.service.recipe;

import com.epam.training.microservices.service.recipes.model.OutgoingRecipe;
import com.epam.training.microservices.service.recipes.model.Recipe;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class OutgoingRecipeSender {

  @Autowired
  private OutgoingRecipeService outgoingRecipeService;

  @Autowired
  private StreamBridge streamBridge;

  @Transactional
  @Scheduled(initialDelay = 1_000, fixedDelay = 10_000)
  public Collection<Recipe> prepareForSend() {
    final List<Recipe> forSend = outgoingRecipeService.findUnprocessed()
        .stream()
        .map(outgoingRecipeService::markSent)
        .map(OutgoingRecipe::getRecipe)
        .collect(Collectors.toList());

    forSend.stream()
        .map(item -> MessageBuilder.withPayload(item).build())
        .forEach(message -> streamBridge.send("deliveryNotificator-out-0", message));

    return forSend;
  }
}