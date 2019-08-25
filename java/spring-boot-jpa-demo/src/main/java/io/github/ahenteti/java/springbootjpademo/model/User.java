package io.github.ahenteti.java.springbootjpademo.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_USERS")
public class User {

  @Id
  private Long id;

  private String username;

  @OneToMany(cascade = CascadeType.ALL)
  Collection<Car> cars;
}