package com.epam.training.microservices.monolithic.jpa.entity.recipie;

import com.google.common.collect.Sets;
import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

/**
 * A recipe to apply.
 */
@Data
@Entity
@Table(name = "recipes")
public class RecipeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * A doctor who issues the recipe.
   */
  @JoinColumn(name = "doctor_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private DoctorEntity doctor;

  /**
   * A recipient of the recipe.
   */
  @JoinColumn(name = "recipient_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private RecipientEntity recipient;

  /**
   * A content of the recipe.
   */
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "recipe", cascade = CascadeType.ALL)
  private Set<RecipeLineEntity> lines = Sets.newHashSet();

  /**
   * Issue date of the recipe.
   */
  private LocalDate issueDate;
}