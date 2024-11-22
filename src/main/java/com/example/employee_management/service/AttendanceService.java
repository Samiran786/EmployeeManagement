package com.example.employee_management.service;

import com.example.employee_management.model.Attendance;
import com.example.employee_management.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Add attendance record
    public Attendance addAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Get all attendance records
    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}
