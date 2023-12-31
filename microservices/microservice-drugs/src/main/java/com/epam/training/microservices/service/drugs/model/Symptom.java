package com.epam.training.microservices.service.drugs.model;

import lombok.Data;
import javax.persistence.*;

/**
 * Symptom of the particular disease.
 */
@Data
@Entity
@Table(name = "symptoms")
public class Symptom {

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