package com.epam.training.microservices.monolithic.model.pharmacy;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "pharmacy_available")
public class PharmacyAvailable {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JoinColumn(name = "pharmacy_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Pharmacy pharmacy;

  @JoinColumn(name = "drug_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Drug drug;

  private Long amount;
}