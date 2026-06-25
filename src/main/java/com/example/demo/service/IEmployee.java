package com.example.demo.service;

import java.util.List;
import com.example.demo.beans.Employee;
import com.example.demo.exception.EmployeeException;


public interface IEmployee {

    Employee addEmployee(Employee emp);

    Employee getEmployee(int empId) throws EmployeeException;

    List<Employee> getEmployees();

    Employee updateEmployee(int empId, Employee emp) throws EmployeeException;

    boolean deleteEmployee(int empId);

    List<Employee> getMaxSalary();
    List<Employee> getSecondMaxSalary();
}