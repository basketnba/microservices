package com.epam.training.microservices.service.drugs.model;

import com.google.common.collect.Sets;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

/**
 * Diseases.
 */
@Data
@Entity
@Table(name = "diseases")
public class Disease {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Name of the disease.
   */
  private String name;

  /**
   * Description of the disease.
   */
  private String description;

  /**
   * A collection of symptoms related to the disease.
   */
  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(
      name = "disease_symptoms",
      joinColumns = @JoinColumn(name = "disease_id"),
      inverseJoinColumns = @JoinColumn(name = "symptom_id")
  )
  private Set<Symptom> symptoms = Sets.newHashSet();
}