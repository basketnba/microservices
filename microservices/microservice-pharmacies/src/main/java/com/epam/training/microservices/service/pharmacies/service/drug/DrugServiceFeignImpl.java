package com.epam.training.microservices.service.pharmacies.service.drug;

import com.epam.training.microservices.service.pharmacies.model.DrugModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.stereotype.Component;

@Component
public class DrugServiceFeignImpl implements DrugService {

  @Autowired
  private DrugServiceFeignClient feignClient;

  @Override
  public Optional<Long> getDrugIdByName(String drugName) {
    return Optional.ofNullable(feignClient.findDrugByName(drugName))
        .map(EntityModel::getContent)
        .map(DrugModel::getId);
  }
}