package com.example.demo.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.beans.Employee;

public interface EmployeeRepositary extends JpaRepository<Employee, Integer>{
     
      @Query("SELECT e FROM Employee e where e.salary=(select max(e.salary) from Employee e)")
    public List<Employee> getMaxSalary();

      @Query("SELECT e FROM Employee e WHERE e.salary=(SELECT MAX(e2.salary) FROM Employee e2 WHERE e2.salary < ( SELECT MAX(e3.salary) FROM Employee e3) )")
    public List<Employee> getSecondMaxSalary();

}
