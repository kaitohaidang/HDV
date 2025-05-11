package com.example.employee_service.controller;

import com.example.employee_service.dto.LoginData;
import com.example.employee_service.model.Employee;
import com.example.employee_service.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/register")
    public Employee register(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginData employee) {
        return employeeService.getJWT(employee.getUsername(), employee.getPassword());
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Integer id) {
        return employeeService.readEmployeeById(id);
    }

    @GetMapping("/teamId/{teamId}")
    public List<Employee> getEmployeeByTeamId(@PathVariable Integer teamId) {
        return employeeService.readListEmployeeByTeamId(teamId);
    }

    @GetMapping("/managerId/{managerId}")
    public List<Integer> getEmployeeByManagerId(@PathVariable Integer managerId) {
        return employeeService.readListEmployeeIdByManagerId(managerId);
    }

}
