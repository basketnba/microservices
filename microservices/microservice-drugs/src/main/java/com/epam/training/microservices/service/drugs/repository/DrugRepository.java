package com.epam.training.microservices.service.drugs.repository;

import com.epam.training.microservices.service.drugs.model.Drug;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface DrugRepository extends CrudRepository<Drug, Long> {

  Optional<Drug> findDrugByName(@Param("name") String name);
}