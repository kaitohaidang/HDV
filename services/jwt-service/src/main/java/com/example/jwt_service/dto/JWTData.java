package com.example.jwt_service.dto;

public class JWTData {

    private Integer id;

    private String name;

    private Boolean is_manager;

    public JWTData() {
    }

    public JWTData(Integer id, String name, Boolean isManager) {
        this.id = id;
        this.name = name;
        this.is_manager = isManager;
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
        return is_manager;
    }

    public void setManager(Boolean manager) {
        is_manager = manager;
    }

    @Override
    public String toString() {
        return "JWTData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", is_manager=" + is_manager +
                '}';
    }
}