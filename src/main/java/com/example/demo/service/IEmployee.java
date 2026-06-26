package com.example.demo.service;

import java.util.List;
import java.util.Map;

import com.example.demo.beans.Employee;
import com.example.demo.beans.Laptop;
import com.example.demo.exception.EmployeeException;
import com.example.demo.exception.LaptopException;


public interface IEmployee {

    Employee addEmployee(Employee emp);

    Employee getEmployee(int empId) throws EmployeeException;

    List<Employee> getEmployees();

    Employee updateEmployee(int empId, Employee emp) throws EmployeeException;

    boolean deleteEmployee(int empId);

    List<Employee> getMaxSalary();
    List<Employee> getSecondMaxSalary();

    Employee assignLaptop(int empId, int laptopId) throws EmployeeException, LaptopException;

    Laptop addLaptop(Laptop laptop);

    Laptop getLaptop(int laptopId) throws LaptopException;

    List<Laptop> getLaptops();

    Laptop updateLaptop(int laptopId, Laptop laptop) throws LaptopException;

    boolean deleteLaptop(int laptopId);

    Employee deallocateLaptop(int empId) throws EmployeeException;

    Map<String, Long> getLaptopAvailability();
}