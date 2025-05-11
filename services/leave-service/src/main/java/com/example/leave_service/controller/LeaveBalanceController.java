package com.example.leave_service.controller;

import com.example.leave_service.dto.BalanceUpdateData;
import com.example.leave_service.model.LeaveBalance;
import com.example.leave_service.service.LeaveBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/leave")
public class LeaveBalanceController {

    @Autowired
    LeaveBalanceService leaveBalanceService;

    @PostMapping
    public LeaveBalance createLeaveBalance(@RequestBody LeaveBalance leaveBalance) {
        leaveBalance.setCreateDate(LocalDate.now());
        return leaveBalanceService.createLeaveBalance(leaveBalance);
    }

    @PostMapping("/balance")
    public Integer updateBalance(@RequestBody BalanceUpdateData balanceUpdateData) {
        return leaveBalanceService.updateCurrentYearBalanceByEmployeeId(
                balanceUpdateData.getEmployeeId(),
                balanceUpdateData.getNewBalance()
        );
    }

    @GetMapping("/balance/employeeId/{employeeId}")
    public Integer readBalance(@PathVariable Integer employeeId) {
        System.out.println(employeeId);
        return leaveBalanceService.readCurrentYearBalanceByEmployeeId(employeeId);
    }

}
