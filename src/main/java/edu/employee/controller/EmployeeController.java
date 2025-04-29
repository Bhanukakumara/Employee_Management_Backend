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

    @PostMapping("/createEmployee")
    Employee createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping("/employees")
    List<EmployeeDto> getAll(){
        return employeeService.getAll();
    }

    @PutMapping("/employees/{id}")
    EmployeeDto updateEmployeeById(@PathVariable Long id, @RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployeeById(id, employeeDto);
    }

    @DeleteMapping("/employees/{id}")
    void deleteEmployeeById(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }
}
