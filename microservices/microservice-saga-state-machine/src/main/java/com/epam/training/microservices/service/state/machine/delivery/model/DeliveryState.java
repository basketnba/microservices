package com.epam.training.microservices.service.state.machine.delivery.model;

public enum DeliveryState {
  /**
   * The order is confirmed by a user, need to start a delivery.
   */
  CONFIRMED,
  /**
   * Not available, will not be delivered.
   */
  NOT_AVAILABLE,
  /**
   * Available, the delivery has been started.
   */
  DELIVERY,
  /**
   * The order has been delivered.
   */
  DELIVERED;
}