package com.epam.training.microservices.monolithic.model.delivery;

import com.epam.training.microservices.monolithic.model.pharmacy.Pharmacy;
import com.google.common.collect.Sets;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Stores information about the delivery.
 */
@Data
@Entity
@Table(name = "deliveries")
@EqualsAndHashCode(exclude = {"pharmacy", "content"})
public class Delivery {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Address of the delivery.
   */
  private String addressLine;

  /**
   * Status of the delivery.
   */
  private DeliveryStatus status;

  /**
   * Where from.
   */
  @JoinColumn(name = "pharmacy_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Pharmacy pharmacy;

  /**
   * Content of the delivery.
   */
  @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "delivery")
  private Set<DeliveryLine> content = Sets.newHashSet();
}