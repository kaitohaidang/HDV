package com.example.leave_service.service;

import com.example.leave_service.model.LeaveBalance;
import com.example.leave_service.repository.LeaveBalanceRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LeaveBalanceService {

    @Autowired
    private LeaveBalanceRepository leaveBalanceRepository;

    public LeaveBalance createLeaveBalance(LeaveBalance leaveBalance) {
        return leaveBalanceRepository.save(leaveBalance);
    }

    public Integer readCurrentYearBalanceByEmployeeId(Integer employeeId) {
        return leaveBalanceRepository.findCurrentYearBalanceByEmployeeId(employeeId).orElse(null);
    }

    @Transactional
    public Integer updateCurrentYearBalanceByEmployeeId(Integer employeeId, Integer newBalance) {
        System.out.println(employeeId + " " + newBalance);
        return leaveBalanceRepository.updateLeaveBalanceThisYear(employeeId, newBalance);
    }
}
