package com.epam.training.microservices.monolithic.service;

import com.epam.training.microservices.monolithic.model.delivery.Delivery;
import com.epam.training.microservices.monolithic.repository.CrudRepository;
import com.epam.training.microservices.monolithic.repository.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService implements CrudService<Delivery> {

  @Autowired
  private DeliveryRepository deliveryRepository;

  @Override
  public CrudRepository<Delivery, Long> getRepository() {
    return deliveryRepository;
  }
}