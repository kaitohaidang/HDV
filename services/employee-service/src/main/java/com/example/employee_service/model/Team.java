package com.example.employee_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "team", uniqueConstraints = {
@UniqueConstraint(columnNames = {"name"})
})
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String detail;

    @Column(nullable = false)
    private Integer managerId;

    public Team() {
    }

    public Team(String name, String detail, Integer managerId) {
        this.name = name;
        this.detail = detail;
        this.managerId = managerId;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", managerId=" + managerId +
                '}';
    }

}
