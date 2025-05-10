package com.example.leave_service.dto;

public class BalanceUpdateData {

    private Integer employeeId;

    private Integer newBalance;

    public BalanceUpdateData() {}

    public BalanceUpdateData(Integer employeeId, Integer newBalance) {
        this.employeeId = employeeId;
        this.newBalance = newBalance;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getNewBalance() {
        return newBalance;
    }

    public void setNewBalance(Integer newBalance) {
        this.newBalance = newBalance;
    }

    @Override
    public String toString() {
        return "BalanceUpdateData{" +
                "employeeId=" + employeeId +
                ", newBalance=" + newBalance +
                '}';
    }
}
