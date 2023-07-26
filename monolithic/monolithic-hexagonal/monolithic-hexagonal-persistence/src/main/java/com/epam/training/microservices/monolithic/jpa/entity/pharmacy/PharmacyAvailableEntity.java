package com.epam.training.microservices.monolithic.jpa.entity.pharmacy;

import com.epam.training.microservices.monolithic.jpa.entity.drug.DrugEntity;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pharmacy_available")
public class PharmacyAvailableEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JoinColumn(name = "pharmacy_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private PharmacyEntity pharmacy;

  @JoinColumn(name = "drug_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private DrugEntity drug;

  private Long amount;
}