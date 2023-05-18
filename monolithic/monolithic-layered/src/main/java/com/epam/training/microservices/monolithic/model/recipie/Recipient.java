package com.epam.training.microservices.monolithic.model.recipie;

import com.google.common.collect.Sets;
import java.util.Set;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "recipients")
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
  @OneToMany(fetch = FetchType.LAZY)
  private Set<Recipe> recipes = Sets.newHashSet();
}