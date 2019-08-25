package io.github.ahenteti.java.springbootjpademo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "T_CARS")
public class Car {

  @Id
  private Long id;

  private String model;

  @ManyToOne
  @JsonIgnore
  @JoinColumn(name="USER_ID")
  private User user;

}