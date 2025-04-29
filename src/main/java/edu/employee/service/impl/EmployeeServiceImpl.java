package edu.employee.service.impl;

import edu.employee.entity.Employee;
import edu.employee.model.EmployeeDto;
import edu.employee.repository.EmployeeRepository;
import edu.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        return employeeRepository.save(modelMapper.map(employeeDto, Employee.class));
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeRepository.findAll().forEach(employee -> {
            employeeDtoList.add(modelMapper.map(employee, EmployeeDto.class));
        });
        return employeeDtoList;
    }

    @Override
    public EmployeeDto searchEmployeeByEmail(String email) {
        modelMapper.map(employeeRepository.findByEmail(email), EmployeeDto.class);
        return null;
    }

    @Override
    public EmployeeDto updateEmployeeByEmail(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public EmployeeDto deleteEmployeeByEmail(String email) {
        return null;
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id) {
        return null;
    }

    @Override
    public void deleteEmployeeById(Long id) {

    }
}
