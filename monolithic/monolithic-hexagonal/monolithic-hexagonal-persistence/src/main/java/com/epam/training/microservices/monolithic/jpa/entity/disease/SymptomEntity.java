package com.epam.training.microservices.monolithic.jpa.entity.disease;

import javax.persistence.*;
import lombok.Data;

/**
 * Symptom of the particular disease.
 */
@Data
@Entity
@Table(name = "symptoms")
public class SymptomEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Name of the symptom.
   */
  private String name;

  /**
   * Description of the symptom.
   */
  private String description;
}