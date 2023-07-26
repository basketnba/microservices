package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.disease.Symptom;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.SymptomRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SymptomService implements CrudService<Symptom> {

  @Autowired
  private SymptomRepository symptomRepository;

  @Override
  public CrudRepository<Symptom, Long> getRepository() {
    return symptomRepository;
  }

  public Optional<Symptom> findByName(String name) {
    return symptomRepository.findSymptomByName(name);
  }
}