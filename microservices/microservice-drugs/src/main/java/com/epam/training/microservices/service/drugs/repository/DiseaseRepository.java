package com.epam.training.microservices.service.drugs.repository;

import com.epam.training.microservices.service.drugs.model.Disease;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface DiseaseRepository extends CrudRepository<Disease, Long> {

  Optional<Disease> findDiseaseByName(@Param("name") String name);
}