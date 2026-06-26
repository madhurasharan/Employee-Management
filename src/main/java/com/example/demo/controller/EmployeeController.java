package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.beans.Employee;
import com.example.demo.exception.EmployeeException;
import com.example.demo.exception.LaptopException;
import com.example.demo.service.EmployeeServiceImpl;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee emp) {
        return service.addEmployee(emp);
    }

    @GetMapping("/getEmployee/{empId}")
    public Employee getEmployee(@PathVariable int empId) throws EmployeeException {
        return service.getEmployee(empId);
    }

    @GetMapping("/getEmployees")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @PutMapping("/updateEmployee/{empId}")
    public Employee updateEmployee(
        @PathVariable int empId,
        @RequestBody Employee emp) throws EmployeeException {

    return service.updateEmployee(empId, emp);
    }

    @DeleteMapping("/deleteEmployee/{empId}")
    public boolean deleteEmployee(@PathVariable int empId) {
        return service.deleteEmployee(empId);
    }

    @GetMapping("/maxSalary")
    public List<Employee> getMaxSalary() {
    return service.getMaxSalary();
}

@GetMapping("/secondMaxSalary")
public List<Employee> getSecondMaxSalary() {
    return service.getSecondMaxSalary();
}

@PutMapping("/assignLaptop/{empId}/{laptopId}")
public Employee assignLaptop(@PathVariable int empId,
                             @PathVariable int laptopId)
        throws EmployeeException, LaptopException {

    return service.assignLaptop(empId, laptopId);
}

@PutMapping("/deallocateLaptop/{empId}")
public Employee deallocateLaptop(@PathVariable int empId)
        throws EmployeeException {

    return service.deallocateLaptop(empId);
}

@GetMapping("/laptopAvailability")
public Map<String, Long> getLaptopAvailability() {
    return service.getLaptopAvailability();
}
}