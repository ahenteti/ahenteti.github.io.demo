package io.github.ahenteti.java.springbootjpademo.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import io.github.ahenteti.java.springbootjpademo.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

  @Query(value = "SELECT * FROM T_CARS c where c.USER_ID = :id", nativeQuery = true)
  Collection<Car> findByUserId(@Param("id") Long id);

}