package com.epam.training.microservices.service.recipes.model;

import com.google.common.collect.Sets;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import javax.persistence.*;
import java.util.Set;

/**
 *
 */
@Data
@Entity
@Table(name = "recipients")
@ToString(exclude = {"recipes"})
@EqualsAndHashCode(exclude = {"recipes"})
public class Recipient {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * Recipient name, etc.
   */
  private String firstName;

  private String lastName;

  /**
   * A collection of recipes associated with this recipient.
   */
  @OneToMany(fetch = FetchType.EAGER, mappedBy = "recipient", cascade = CascadeType.ALL)
  private Set<Recipe> recipes = Sets.newHashSet();
}