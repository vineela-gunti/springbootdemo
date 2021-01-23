package com.example.demo.repos;

import com.example.demo.entities.PersistableEmployee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<PersistableEmployee, String> {
}