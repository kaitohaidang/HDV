package com.example.leave_service.repository;

import com.example.leave_service.model.LeaveBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {

    // Read Leave Balance having crateDate in this year by Employee's id
    @Query("SELECT lb FROM LeaveBalance lb WHERE lb.employeeId = :employeeId AND YEAR(lb.createDate) = YEAR(CURRENT_DATE)")
    Optional<LeaveBalance> findCurrentYearLeaveBalanceByEmployeeId(@Param("employeeId") Integer employeeId);

    // Read balance of Leave Balance having crateDate in this year by Employee's id
    @Query("SELECT lb.balance FROM LeaveBalance lb WHERE lb.employeeId = :employeeId AND YEAR(lb.createDate) = YEAR(CURRENT_DATE)")
    Optional<Integer> findCurrentYearBalanceByEmployeeId(@Param("employeeId") Integer employeeId);

    // Update balance of Leave Balance having crateDate in this year by Employee's id
    @Modifying
    @Query("UPDATE LeaveBalance lb SET lb.balance = :newBalance WHERE lb.employeeId = :employeeId AND YEAR(lb.createDate) = YEAR(CURRENT_DATE)")
    int updateCurrentYearBalanceByEmployeeId(@Param("employeeId") Integer employeeId, @Param("newBalance") Integer newBalance);

}
