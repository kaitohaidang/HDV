package com.example.approval_service.controller;

import com.example.approval_service.model.LeaveRequest;
import com.example.approval_service.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/leave-request")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    // Submit a new leave request
    @PostMapping
    public ResponseEntity<?> submitLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        try {
            LeaveRequest savedRequest = leaveRequestService.createLeaveRequest(leaveRequest);
            return new ResponseEntity<>(savedRequest, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Get leave request by ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getLeaveRequestById(@PathVariable Integer id) {
        LeaveRequest leaveRequest = leaveRequestService.getLeaveRequestById(id);
        if (leaveRequest != null) {
            return new ResponseEntity<>(leaveRequest, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Leave request not found", HttpStatus.NOT_FOUND);
        }
    }

    // Get all leave requests for an employee
    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequestsByEmployeeId(@PathVariable Integer employeeId) {
        List<LeaveRequest> leaveRequests = leaveRequestService.getLeaveRequestsByEmployeeId(employeeId);
        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

    // Get all leave requests for a manager
    @GetMapping("/manager/{managerId}")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequestsByManagerId(@PathVariable Integer managerId) {
        List<LeaveRequest> leaveRequests = leaveRequestService.getLeaveRequestsByManagerId(managerId);
        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

    // Get pending leave requests for a manager
    @GetMapping("/manager/{managerId}/pending")
    public ResponseEntity<List<LeaveRequest>> getPendingLeaveRequestsByManagerId(@PathVariable Integer managerId) {
        List<LeaveRequest> leaveRequests = leaveRequestService.getPendingLeaveRequestsByManagerId(managerId);
        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

    // Approve a leave request
    @PutMapping("/{id}/approve")
    public ResponseEntity<?> approveLeaveRequest(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        try {
            String comments = request.getOrDefault("comments", "");
            LeaveRequest leaveRequest = leaveRequestService.approveLeaveRequest(id, comments);
            return new ResponseEntity<>(leaveRequest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    // Reject a leave request
    @PutMapping("/{id}/reject")
    public ResponseEntity<?> rejectLeaveRequest(@PathVariable Integer id, @RequestBody Map<String, String> request) {
        try {
            String comments = request.getOrDefault("comments", "");
            LeaveRequest leaveRequest = leaveRequestService.rejectLeaveRequest(id, comments);
            return new ResponseEntity<>(leaveRequest, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}