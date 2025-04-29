package edu.employee.service.impl;

import edu.employee.entity.Employee;
import edu.employee.model.EmployeeDto;
import edu.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return List.of();
    }

    @Override
    public Employee searchByEmail(String email) {
        return null;
    }

    @Override
    public Employee updateEmployeeByEmail(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public Employee deleteByEmail(String email) {
        return null;
    }
}
