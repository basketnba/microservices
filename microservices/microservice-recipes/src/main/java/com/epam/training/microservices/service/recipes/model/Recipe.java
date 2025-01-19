package com.epam.training.microservices.service.recipes.model;

import com.google.common.collect.Sets;
import lombok.Data;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

/**
 * A recipe to apply.
 */
@Data
@Entity
@Table(name = "recipes")
public class Recipe {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A doctor who issues the recipe.
   */
  @JoinColumn(name = "doctor_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Doctor doctor;

  /**
   * A recipient of the recipe.
   */
  @JoinColumn(name = "recipient_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Recipient recipient;

  /**
   * A content of the recipe.
   */
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipe", cascade = CascadeType.ALL)
  private Set<RecipeLine> lines = Sets.newHashSet();

  /**
   * Issue date of the recipe.
   */
  private LocalDate issueDate;
}