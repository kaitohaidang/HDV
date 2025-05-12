package com.example.employee_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"username"}),
        @UniqueConstraint(columnNames = {"email"}),
        @UniqueConstraint(columnNames = {"phone_number"})
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate DOB;

    @Column(nullable = false, unique = true)
    private String phone_number;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Float salary;

    @Column(nullable = false)
    private Boolean is_manager;

    @Column(nullable = false)
    private Integer team_id;

    public Employee() {
    }

    public Employee(
            String name, String username, String password, LocalDate DOB,
            String phone_number, String email, String address, Float salary,
            Boolean is_manager, Integer team_id
    ) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.DOB = DOB;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.is_manager = is_manager;
        this.team_id = team_id;
    }

    public Employee(
            Integer id, String name, String username, String password,
            LocalDate DOB, String phone_number, String email, String address,
            Float salary, Boolean is_manager, Integer team_id
    ) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.DOB = DOB;
        this.phone_number = phone_number;
        this.email = email;
        this.address = address;
        this.salary = salary;
        this.is_manager = is_manager;
        this.team_id = team_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getDOB() {
        return DOB;
    }

    public void setDOB(LocalDate DOB) {
        this.DOB = DOB;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public Boolean getIs_manager() {
        return is_manager;
    }

    public void setIs_manager(Boolean is_manager) {
        this.is_manager = is_manager;
    }

    public Integer getTeam_id() {
        return team_id;
    }

    public void setTeam_id(Integer team_id) {
        this.team_id = team_id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", DOB=" + DOB +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", salary=" + salary +
                ", is_manager=" + is_manager +
                ", team_id=" + team_id +
                '}';
    }
}
