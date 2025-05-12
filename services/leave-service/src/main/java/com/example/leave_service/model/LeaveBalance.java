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

    private LocalDate create_date;

    @Column(nullable = false)
    private Integer balance;

    @Column(nullable = false)
    private Integer employee_id;

    public LeaveBalance() {
    }

    public LeaveBalance(
            Integer id, String detail, LocalDate createDate,
            Integer balance, Integer employeeId
    ) {
        this.id = id;
        this.detail = detail;
        this.create_date = createDate;
        this.balance = balance;
        this.employee_id = employeeId;
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
        return create_date;
    }

    public void setCreateDate(LocalDate createDate) {
        this.create_date = createDate;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getEmployeeId() {
        return employee_id;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employee_id = employeeId;
    }

    @Override
    public String toString() {
        return "LeaveBalance{" +
                "id=" + id +
                ", detail='" + detail + '\'' +
                ", create_date=" + create_date +
                ", balance=" + balance +
                ", employeeId=" + employee_id +
                '}';
    }

}