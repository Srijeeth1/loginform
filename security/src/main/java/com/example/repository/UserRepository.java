package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Employee;
@Repository
public interface UserRepository extends JpaRepository<Employee, Long> {

Optional<Employee>findByUsername(String username);
}
