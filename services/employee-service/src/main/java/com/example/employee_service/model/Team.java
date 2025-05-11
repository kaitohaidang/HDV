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

    public Team() {
    }

    public Team(String name, String detail) {
        this.name = name;
        this.detail = detail;
    }

    public Team(Integer id, String name, String detail) {
        this.id = id;
        this.name = name;
        this.detail = detail;
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

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
