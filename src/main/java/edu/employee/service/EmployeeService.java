package edu.employee.service;

import edu.employee.entity.Employee;
import edu.employee.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto employeeDto);
    List<EmployeeDto> getAll();
    EmployeeDto searchEmployeeByEmail(String email);
    EmployeeDto searchEmployeeById(Long id);
    EmployeeDto updateEmployeeByEmail(EmployeeDto employeeDto);
    EmployeeDto deleteEmployeeByEmail(String email);
    EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto);
    void deleteEmployeeById(Long id);
}
