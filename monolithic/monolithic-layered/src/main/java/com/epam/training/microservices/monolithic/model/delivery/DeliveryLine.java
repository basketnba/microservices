package com.epam.training.microservices.monolithic.model.delivery;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "delivery_line")
public class DeliveryLine {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JoinColumn(name = "delivery_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Delivery delivery;

  /**
   * A drug to deliver.
   */
  @JoinColumn(name = "drug_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Drug drug;

  /**
   * Amount of drug to deliver.
   */
  private Long amount;
}