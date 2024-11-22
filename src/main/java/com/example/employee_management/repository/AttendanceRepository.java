package com.example.employee_management.repository;

import com.example.employee_management.model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // Custom query methods can be added here
}
