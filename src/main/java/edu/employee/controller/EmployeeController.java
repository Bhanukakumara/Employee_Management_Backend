package edu.employee.controller;

import edu.employee.entity.Employee;
import edu.employee.model.EmployeeDto;
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

    @PostMapping("/createEmployee")
    Employee createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/employees")
    List<Employee> getAll(){
        return employeeService.getAll();
    }

    @PutMapping("/employees/{id}")
    Employee updateEmployeeById(@PathVariable Long id){
        return employeeService.updateEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
}
