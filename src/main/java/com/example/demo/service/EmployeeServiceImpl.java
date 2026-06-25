package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.dao.EmployeeRepositary;
import com.example.demo.exception.EmployeeException;

@Service
public class EmployeeServiceImpl implements IEmployee {

    @Autowired
    private EmployeeRepositary dao;

    // ADD
    @Override
    public Employee addEmployee(Employee emp) {
        return dao.save(emp);
    }

    // GET BY ID
    @Override
    public Employee getEmployee(int empId) throws EmployeeException {

        return dao.findById(empId)
                .orElseThrow(() ->
                        new EmployeeException("Employee not found with id: " + empId));
    }

    // GET ALL
    @Override
    public List<Employee> getEmployees() {
        return dao.findAll();
    }

    // UPDATE
    @Override
    public Employee updateEmployee(int empId, Employee emp) throws EmployeeException {

        Employee e= dao.findById(empId)
                .orElseThrow(() ->
                        new EmployeeException("Employee not found with id: " + empId));

        e.setEmpName(emp.getEmpName());
        e.setSalary(emp.getSalary());

        return dao.save(e);
    }

    // DELETE
    @Override
    public boolean deleteEmployee(int empId) {

        if (dao.existsById(empId)) {
            dao.deleteById(empId);
            return true;
        }
        return false;
    }
    
    //MAX SALARY
    @Override
    public List<Employee> getMaxSalary() {
    return dao.getMaxSalary();
    }

    //SEC MAX SALARY
    @Override
    public List<Employee> getSecondMaxSalary(){
    return dao.getSecondMaxSalary();
    }
}