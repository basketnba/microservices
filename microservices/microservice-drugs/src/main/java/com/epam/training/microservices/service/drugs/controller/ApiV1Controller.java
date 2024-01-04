package com.epam.training.microservices.service.drugs.controller;

import java.util.UUID;
import javax.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/info")
public class ApiV1Controller {

  private String serviceId;

  @PostConstruct
  public void init() {
    serviceId = UUID.randomUUID().toString();
  }

  @GetMapping
  public String getServiceId() {
    return serviceId;
  }
}