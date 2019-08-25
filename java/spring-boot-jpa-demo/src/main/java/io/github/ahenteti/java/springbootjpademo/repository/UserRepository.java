package io.github.ahenteti.java.springbootjpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ahenteti.java.springbootjpademo.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}