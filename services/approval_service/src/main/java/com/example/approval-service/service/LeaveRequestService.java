package com.example.approval_service.service;

import com.example.approval_service.model.LeaveRequest;
import com.example.approval_service.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.we.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;
    
    @Autowired
    private WebClient.Builder webClientBuilder;
    
    @Value("${employee.service.url:http://employee-service:8080}")
    private String employeeServiceUrl;
    
    @Value("${leave.service.url:http://leave-service:8080}")
    private String leaveServiceUrl;

    // Create new leave request
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        // Set default values
        if (leaveRequest.getRequestDate() == null) {
            leaveRequest.setRequestDate(LocalDate.now());
        }
        
        if (leaveRequest.getStatus() == null || leaveRequest.getStatus().isEmpty()) {
            leaveRequest.setStatus("PENDING");
        }
        
        // Validate if employee has enough leave balance
        Integer employeeId = leaveRequest.getEmployeeId();
        long leaveDays = ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;
        
        // Get current leave balance from leave-service
        Integer currentBalance = getLeaveBalance(employeeId);
        
        if (currentBalance == null || currentBalance < leaveDays) {
            throw new RuntimeException("Employee does not have enough leave balance");
        }
        
        return leaveRequestRepository.save(leaveRequest);
    }

    // Get leave request by ID
    public LeaveRequest getLeaveRequestById(Integer id) {
        Optional<LeaveRequest> leaveRequest = leaveRequestRepository.findById(id);
        return leaveRequest.orElse(null);
    }
    
    // Get all leave requests for an employee
    public List<LeaveRequest> getLeaveRequestsByEmployeeId(Integer employeeId) {
        return leaveRequestRepository.findByEmployeeId(employeeId);
    }
    
    // Get all leave requests for a manager
    public List<LeaveRequest> getLeaveRequestsByManagerId(Integer managerId) {
        return leaveRequestRepository.findByManagerId(managerId);
    }
    
    // Get pending leave requests for a manager
    public List<LeaveRequest> getPendingLeaveRequestsByManagerId(Integer managerId) {
        return leaveRequestRepository.findByManagerIdAndStatus(managerId, "PENDING");
    }
    
    // Approve leave request
    public LeaveRequest approveLeaveRequest(Integer requestId, String comments) {
        LeaveRequest leaveRequest = getLeaveRequestById(requestId);
        
        if (leaveRequest == null) {
            throw new RuntimeException("Leave request not found");
        }
        
        if (!"PENDING".equals(leaveRequest.getStatus())) {
            throw new RuntimeException("Leave request is not pending");
        }
        
        leaveRequest.setStatus("APPROVED");
        leaveRequest.setComments(comments);
        
        // Update leave balance
        Integer employeeId = leaveRequest.getEmployeeId();
        long leaveDays = ChronoUnit.DAYS.between(leaveRequest.getStartDate(), leaveRequest.getEndDate()) + 1;
        
        // Get current balance and update it
        Integer currentBalance = getLeaveBalance(employeeId);
        
        if (currentBalance != null) {
            updateLeaveBalance(employeeId, currentBalance - (int)leaveDays);
        }
        
        return leaveRequestRepository.save(leaveRequest);
    }
    
    // Reject leave request
    public LeaveRequest rejectLeaveRequest(Integer requestId, String comments) {
        LeaveRequest leaveRequest = getLeaveRequestById(requestId);
        
        if (leaveRequest == null) {
            throw new RuntimeException("Leave request not found");
        }
        
        if (!"PENDING".equals(leaveRequest.getStatus())) {
            throw new RuntimeException("Leave request is not pending");
        }
        
        leaveRequest.setStatus("REJECTED");
        leaveRequest.setComments(comments);
        
        return leaveRequestRepository.save(leaveRequest);
    }
    
    // Get leave balance from leave-service
    private Integer getLeaveBalance(Integer employeeId) {
        try {
            return webClientBuilder.build()
                .get()
                .uri(leaveServiceUrl + "/leave/balance/employeeId/" + employeeId)
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
        } catch (Exception e) {
            // Log the error
            System.err.println("Error getting leave balance: " + e.getMessage());
            return null;
        }
    }
    
    // Update leave balance in leave-service
    private void updateLeaveBalance(Integer employeeId, Integer newBalance) {
        try {
            webClientBuilder.build()
                .put()
                .uri(leaveServiceUrl + "/leave/balance?employeeId=" + employeeId + "&newBalance=" + newBalance)
                .retrieve()
                .bodyToMono(Integer.class)
                .block();
        } catch (Exception e) {
            // Log the error
            System.err.println("Error updating leave balance: " + e.getMessage());
        }
    }
}