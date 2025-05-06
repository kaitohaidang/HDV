package com.example.employee_service.repository;

import com.example.employee_service.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Read Employee by UserName
    Optional<Employee> findByUsername(String username);

    // Read Employees by Team's id
    List<Employee> findByTeamId(Integer teamId);

}
