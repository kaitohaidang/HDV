package com.example.leave_service.repository;

import com.example.leave_service.model.LeaveBalance;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LeaveBalanceRepository extends JpaRepository<LeaveBalance, Integer> {

    @Query(value = """
        SELECT lb.balance 
        FROM leave_balance lb 
        WHERE lb.employee_id = :employeeId 
        AND YEAR(lb.create_date) = YEAR(CURDATE())
        """, nativeQuery = true)
    Optional<Integer> findCurrentYearBalanceByEmployeeId(
            @Param("employeeId") Integer employeeId
    );

    @Transactional
    @Modifying
    @Query(value = """
        UPDATE leave_balance
        SET balance = :newBalance
        WHERE employee_id = :employeeId
        AND YEAR(create_date) = YEAR(CURRENT_DATE)
        """, nativeQuery = true)
    int updateLeaveBalanceThisYear(
            @Param("employeeId") Integer employeeId,
            @Param("newBalance") Integer newBalance
    );

}
