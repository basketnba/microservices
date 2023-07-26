package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import java.util.Optional;

public interface SymptomRepository extends CrudRepository<Symptom, Long> {

  Optional<Symptom> findSymptomByName(String name);
}