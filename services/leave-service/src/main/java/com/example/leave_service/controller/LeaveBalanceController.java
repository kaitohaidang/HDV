package com.example.leave_service.controller;

import com.example.leave_service.model.LeaveBalance;
import com.example.leave_service.service.LeaveBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
public class LeaveBalanceController {

    @Autowired
    LeaveBalanceService leaveBalanceService;

    @PostMapping
    public LeaveBalance createLeaveBalance(@RequestBody LeaveBalance leaveBalance) {
        return leaveBalanceService.createLeaveBalance(leaveBalance);
    }

    @GetMapping("/employeeId/{employeeId}")
    public LeaveBalance readLeaveBalance(@PathVariable Integer employeeId) {
        return leaveBalanceService.readCurrentYearLeaveBalanceLeaveBalanceByEmployeeId(employeeId);
    }

    @PutMapping("/balance")
    public Integer updateBalance(@RequestParam Integer employeeId, @RequestParam Integer newBalance) {
        return leaveBalanceService.updateCurrentYearBalanceByEmployeeId(employeeId, newBalance);
    }

    @GetMapping("/balance/employeeId/{employeeId}")
    public Integer readBalance(@PathVariable Integer employeeId) {
        return leaveBalanceService.readCurrentYearBalanceByEmployeeId(employeeId);
    }

}
