package io.github.ahenteti.java.springbootjpademo.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.ahenteti.java.springbootjpademo.model.Car;
import io.github.ahenteti.java.springbootjpademo.repository.CarRepository;


@RestController
class UserController {

  @Autowired
  private CarRepository carRepository;

  @GetMapping("/users/{id}/cars")
  public ResponseEntity<Collection<Car>> getAllCarsByUserId(@PathVariable("id") Long id) {
      return ResponseEntity.ok(carRepository.findByUserId(id));
  }

}