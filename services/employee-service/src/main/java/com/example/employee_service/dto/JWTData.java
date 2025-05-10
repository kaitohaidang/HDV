package com.example.employee_service.dto;

public class JWTData {

    private Integer id;

    private String name;

    private Boolean isManager;

    public JWTData() {
    }

    public JWTData(Integer id, String name, Boolean isManager) {
        this.id = id;
        this.name = name;
        this.isManager = isManager;
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

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    @Override
    public String toString() {
        return "JWTData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isManager=" + isManager +
                '}';
    }
}
