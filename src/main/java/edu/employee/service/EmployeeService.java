package edu.employee.service;

import edu.employee.entity.Employee;
import edu.employee.model.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(EmployeeDto employeeDto);
    List<Employee> getAll();
    Employee searchByEmail(String email);
    Employee updateEmployeeByEmail(EmployeeDto employeeDto);
    Employee deleteByEmail(String email);
}
