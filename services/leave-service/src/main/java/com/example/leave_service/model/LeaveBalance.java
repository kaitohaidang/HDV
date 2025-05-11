package com.example.leave_service.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_balance")
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String detail;

    private LocalDate createDate;

    @Column(nullable = false)
    private Integer balance;

    @Column(nullable = false)
    private Integer employeeId;

    public LeaveBalance() {
    }

    public LeaveBalance(String detail, Integer balance, Integer employeeId) {
        this.detail = detail;
        this.createDate = LocalDate.now();
        this.balance = balance;
        this.employeeId = employeeId;
    }

    public LeaveBalance(
            Integer id, String detail, LocalDate createDate,
            Integer balance, Integer employeeId
    ) {
        this.id = id;
        this.detail = detail;
        this.createDate = createDate;
        this.balance = balance;
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public String toString() {
        return "LeaveBalance{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", createDate=" + createDate +
                ", balance=" + balance +
                ", employeeId=" + employeeId +
                '}';
    }

}