package com.epam.training.microservices.service.pharmacies.model;

import lombok.Data;

@Data
public class DrugModel {

  private Long id;
  private String name;
  private String description;
  private String available;
}