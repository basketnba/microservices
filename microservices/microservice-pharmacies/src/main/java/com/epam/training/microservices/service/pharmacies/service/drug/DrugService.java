package com.epam.training.microservices.service.pharmacies.service.drug;

import java.util.Optional;
import org.springframework.stereotype.Component;

@Component
public interface DrugService {

  Optional<Long> getDrugIdByName(String drugName);
}