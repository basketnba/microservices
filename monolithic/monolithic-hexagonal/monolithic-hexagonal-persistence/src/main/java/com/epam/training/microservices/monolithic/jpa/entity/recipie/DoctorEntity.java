package com.epam.training.microservices.monolithic.jpa.entity.recipie;

import javax.persistence.*;
import lombok.Data;

/**
 * An entity to store information about doctors who issue the recipes.
 */
@Data
@Entity
@Table(name = "doctors")
public class DoctorEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Doctor's name.
   */
  private String firstName;

  private String lastName;
}