package edu.employee.dto;

import edu.employee.utill.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
    private String name;
    private String email;
    private Department department;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
