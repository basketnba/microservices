package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.recipie.Recipient;
import java.util.Optional;

public interface RecipientRepository extends CrudRepository<Recipient, Long> {

  Optional<Recipient> findRecipientByFirstNameAndLastName(String firstName, String lastName);
}