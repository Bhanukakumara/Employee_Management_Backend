package edu.employee.service;

import edu.employee.entity.Employee;
import edu.employee.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto employeeDto);
    List<Employee> getAll();
    Employee searchEmployeeByEmail(String email);
    Employee updateEmployeeByEmail(EmployeeDto employeeDto);
    Employee deleteEmployeeByEmail(String email);
    Employee updateEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}
