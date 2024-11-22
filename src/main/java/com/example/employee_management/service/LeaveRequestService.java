package com.example.employee_management.service;

import com.example.employee_management.model.LeaveRequest;
import com.example.employee_management.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    // Add leave request
    public LeaveRequest addLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    // Get all leave requests
    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    // Approve or reject leave request by updating its status
    public LeaveRequest updateLeaveStatus(Long id, String status) {
        LeaveRequest leaveRequest = leaveRequestRepository.findById(id).orElse(null);
        if (leaveRequest != null) {
            leaveRequest.setStatus(status);
            return leaveRequestRepository.save(leaveRequest);
        }
        return null;
    }
}
