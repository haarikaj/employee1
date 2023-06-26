package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @GetMapping("/{employeeId}")
    public Employee getEmployeeById(@PathVariable Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable Long employeeId, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        if (employee != null) {
       
            employee.setName(updatedEmployee.getName());
           

            return employeeRepository.save(employee);
        }
        return null;
    }

    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
