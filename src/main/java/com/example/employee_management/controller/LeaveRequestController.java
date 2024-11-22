package com.example.employee_management.controller;

import com.example.employee_management.model.LeaveRequest;
import com.example.employee_management.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave-requests")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    // Create a new leave request
    @PostMapping
    public ResponseEntity<LeaveRequest> addLeaveRequest(@RequestBody LeaveRequest leaveRequest) {
        LeaveRequest createdLeaveRequest = leaveRequestService.addLeaveRequest(leaveRequest);
        return new ResponseEntity<>(createdLeaveRequest, HttpStatus.CREATED);
    }

    // Get all leave requests
    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllLeaveRequests();
        return new ResponseEntity<>(leaveRequests, HttpStatus.OK);
    }

    // Update leave request status
    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveStatus(@PathVariable("id") Long id, @RequestParam("status") String status) {
        LeaveRequest updatedLeaveRequest = leaveRequestService.updateLeaveStatus(id, status);
        return updatedLeaveRequest != null ? new ResponseEntity<>(updatedLeaveRequest, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
