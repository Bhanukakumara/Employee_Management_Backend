package edu.employee.entity;

import edu.employee.utill.Department;

import java.time.LocalDateTime;

public class Employee {
    private Long id;
    private String name;
    private String email;
    private Department department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
