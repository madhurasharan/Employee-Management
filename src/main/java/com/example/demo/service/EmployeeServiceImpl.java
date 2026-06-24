package com.example.demo.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.dao.EmployeeDAO;
import com.example.demo.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements IEmployee {

    @Autowired
    private EmployeeDAO dao;

    @Override
    public Employee addEmployee(Employee emp) {
        return dao.addEmployee(emp);
    }

    @Override
    public Employee getEmployee(int empId) throws EmployeeException {
        Employee e=dao.getEmployee(empId);
        if(e==null)
            throw new EmployeeException("Please enter correct id");

        return e;
    }

    @Override
    public List<Employee> getEmployees() {
        return dao.getEmployees();
    }

    @Override
    public Employee updateEmployee(int empId, Employee emp) {
        return dao.updateEmployee(empId, emp);
    }

    @Override
    public boolean deleteEmployee(int empId) {
        return dao.deleteEmployee(empId);
    }
}