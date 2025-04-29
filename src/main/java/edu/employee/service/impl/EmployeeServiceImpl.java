package edu.employee.service.impl;

import edu.employee.entity.Employee;
import edu.employee.dto.EmployeeDto;
import edu.employee.repository.EmployeeRepository;
import edu.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    final EmployeeRepository employeeRepository;
    final ModelMapper modelMapper;

    @Override
    public Employee createEmployee(EmployeeDto employeeDto) {
        if (searchEmployeeByEmail(employeeDto.getEmail()) == null) {
            return employeeRepository.save(modelMapper.map(employeeDto, Employee.class));
        }
        throw new RuntimeException("This email already has an employee");
    }

    @Override
    public List<EmployeeDto> getAll() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeeRepository.findAll().forEach(employee ->
                employeeDtoList.add(modelMapper.map(employee, EmployeeDto.class))
        );
        return employeeDtoList;
    }

    @Override
    public EmployeeDto searchEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return (employee != null) ? modelMapper.map(employee, EmployeeDto.class) : null;
    }

    @Override
    public EmployeeDto searchEmployeeById(Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        return employeeOptional.map(employee -> modelMapper.map(employee, EmployeeDto.class)).orElse(null);
    }

    @Override
    public EmployeeDto updateEmployeeByEmail(String email, EmployeeDto employeeDto) {
        Employee existingEmployee = employeeRepository.findByEmail(email);
        if (existingEmployee == null) {
            throw new RuntimeException("Employee with email " + email + " not found");
        }

        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setDepartment(employeeDto.getDepartment());
        existingEmployee.setEmail(employeeDto.getEmail());

        employeeRepository.save(existingEmployee);

        return modelMapper.map(existingEmployee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto deleteEmployeeByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        if (employee == null) {
            throw new RuntimeException("Employee with email " + email + " not found");
        }

        employeeRepository.delete(employee);
        return modelMapper.map(employee, EmployeeDto.class);
    }

    @Override
    public EmployeeDto updateEmployeeById(Long id, EmployeeDto employeeDto) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isEmpty()) {
            throw new RuntimeException("Employee with ID " + id + " not found");
        }

        Employee existingEmployee = optionalEmployee.get();
        existingEmployee.setName(employeeDto.getName());
        existingEmployee.setDepartment(employeeDto.getDepartment());
        existingEmployee.setEmail(employeeDto.getEmail());

        employeeRepository.save(existingEmployee);
        return modelMapper.map(existingEmployee, EmployeeDto.class);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee with ID " + id + " not found");
        }
        employeeRepository.deleteById(id);
    }
}
