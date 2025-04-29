package edu.employee.controller;

import edu.employee.entity.Employee;
import edu.employee.dto.EmployeeDto;
import edu.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class EmployeeController {

    final EmployeeService employeeService;

    @PostMapping("/create-employee")
    Employee createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/all-employees")
    List<EmployeeDto> getAll(){
        return employeeService.getAll();
    }

    @GetMapping("/search-by-email/{email}")
    EmployeeDto searchEmployeeByEmail(String email){
        return employeeService.searchEmployeeByEmail(email);
    }

    @GetMapping("/search-by-id/{id}")
    EmployeeDto searchEmployeeById(Long id){
        return employeeService.searchEmployeeById(id);
    }

    @PutMapping("/update-employee-by-id/{id}")
    EmployeeDto updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployeeById(id, employeeDto);
    }

    @DeleteMapping("/delete-employee-by-id/{id}")
    void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
}
