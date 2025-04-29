package edu.employee.service.impl;

import edu.employee.entity.Employee;
import edu.employee.model.EmployeeDto;
import edu.employee.repository.EmployeeRepository;
import edu.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository employeeRepository;


    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {

        return null;
    }

    @Override
    public List<Employee> getAll() {

        return List.of();
    }

    @Override
    public Employee searchEmployeeByEmail(String email) {
        return null;
    }

    @Override
    public Employee updateEmployeeByEmail(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public Employee deleteEmployeeByEmail(String email) {
        return null;
    }

    @Override
    public Employee updateEmployeeById(Long id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long id) {

    }
}
