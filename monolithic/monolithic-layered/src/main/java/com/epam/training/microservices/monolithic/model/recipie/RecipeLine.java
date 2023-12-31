package com.epam.training.microservices.monolithic.model.recipie;

import com.epam.training.microservices.monolithic.model.drug.Drug;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * One line of the recipe.
 */
@Data
@Entity
@EqualsAndHashCode(exclude = {"drug", "recipe"})
@Table(name = "recipe_lines")
public class RecipeLine {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @JoinColumn(name = "recipe_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Recipe recipe;

  /**
   * A drug to apply.
   */
  @JoinColumn(name = "drug_id")
  @ManyToOne(fetch = FetchType.EAGER)
  private Drug drug;

  /**
   * Amount of drug to apply.
   */
  private Long amount;

  /**
   * What exactly to be done.
   */
  private String instruction;
}