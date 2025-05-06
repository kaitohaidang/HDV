package com.example.employee_service.service;

import com.example.employee_service.model.Employee;
import com.example.employee_service.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create new Employee
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Read Employee by id
    public Employee readEmployeeById(Integer id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.orElse(null);
    }

    // Read list Employee by id
    public List<Employee> readListEmployeeByTeamId(Integer teamId) {
        return employeeRepository.findByTeamId(teamId);
    }
}
