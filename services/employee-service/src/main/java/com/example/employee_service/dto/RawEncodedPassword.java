package com.example.employee_service.dto;

public class RawEncodedPassword {

    private String raw_password;

    private String encoded_password;

    public RawEncodedPassword() {
    }

    public RawEncodedPassword(String raw_password, String encoded_password) {
        this.raw_password = raw_password;
        this.encoded_password = encoded_password;
    }

    public String getRaw_password() {
        return raw_password;
    }

    public void setRaw_password(String raw_password) {
        this.raw_password = raw_password;
    }

    public String getEncoded_password() {
        return encoded_password;
    }

    public void setEncoded_password(String encoded_password) {
        this.encoded_password = encoded_password;
    }

    @Override
    public String toString() {
        return "RawEncodedPassword{" +
                "raw_password='" + raw_password + '\'' +
                ", encoded_password='" + encoded_password + '\'' +
                '}';
    }

}
