package com.epam.training.microservices.service.state.machine.delivery.model;

import lombok.Data;

@Data
public class OrderEvent {

  private String orderId;
}