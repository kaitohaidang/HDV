package com.example.approval_service.repository;

import com.example.approval_service.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Integer> {
    
    // Find requests by employee ID
    List<LeaveRequest> findByEmployeeId(Integer employeeId);
    
    // Find requests by manager ID
    List<LeaveRequest> findByManagerId(Integer managerId);
    
    // Find requests by employee ID and status
    List<LeaveRequest> findByEmployeeIdAndStatus(Integer employeeId, String status);
    
    // Find requests by manager ID and status
    List<LeaveRequest> findByManagerIdAndStatus(Integer managerId, String status);
    
    // Find pending requests
    List<LeaveRequest> findByStatus(String status);
}