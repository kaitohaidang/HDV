package com.example.employee_service.dto;

public class RawPassword {

    private String raw_password;

    public RawPassword() {
    }

    public RawPassword(String raw_password) {
        this.raw_password = raw_password;
    }

    public String getRaw_password() {
        return raw_password;
    }

    public void setRaw_password(String raw_password) {
        this.raw_password = raw_password;
    }

    @Override
    public String toString() {
        return "RawPassword{" +
                "raw_password='" + raw_password + '\'' +
                '}';
    }
}
