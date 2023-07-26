package com.epam.training.microservices.monolithic.repository;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import java.util.Optional;

public interface DrugRepository extends CrudRepository<Drug, Long> {

  Optional<Drug> findDrugByName(String name);
}