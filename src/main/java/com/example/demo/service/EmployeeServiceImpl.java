package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.Employee;
import com.example.demo.beans.Laptop;
import com.example.demo.dao.EmployeeRepositary;
import com.example.demo.dao.LaptopRepositary;
import com.example.demo.exception.EmployeeException;
import com.example.demo.exception.LaptopException;

@Service
public class EmployeeServiceImpl implements IEmployee {

    @Autowired
    private EmployeeRepositary dao;

    @Autowired
    private LaptopRepositary laptopDao;

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

    //ADD LAPTOP
    @Override
    public Laptop addLaptop(Laptop laptop) {
    return laptopDao.save(laptop);
    }

    //Get Laptop
    @Override
    public Laptop getLaptop(int laptopId) throws LaptopException {

    return laptopDao.findById(laptopId)
            .orElseThrow(() ->
                new LaptopException("Laptop not found"));
    }

    //Get ALL LAPTOPS
    @Override
    public List<Laptop> getLaptops() {
    return laptopDao.findAll();
    }

    //UPDATE LAPTOP
    @Override
    public Laptop updateLaptop(int laptopId, Laptop laptop)
        throws LaptopException {

    Laptop l = laptopDao.findById(laptopId)
            .orElseThrow(() ->
                new LaptopException("Laptop not found"));

    l.setLaptopName(laptop.getLaptopName());
    l.setCost(laptop.getCost());

    return laptopDao.save(l);
    }

    //Delete Laptop
    @Override
public boolean deleteLaptop(int laptopId) {

    Laptop laptop = laptopDao.findById(laptopId).orElse(null);

    if (laptop == null) {
        return false;
    }

    List<Employee> employees = dao.findAll();

    for (Employee emp : employees) {

        if (emp.getLaptop() != null &&
                emp.getLaptop().getLaptopId() == laptopId) {

            emp.setLaptop(null);
            dao.save(emp);
        }
    }

    laptopDao.delete(laptop);

    return true;
}

    @Override
    public Employee assignLaptop(int empId, int laptopId)
        throws EmployeeException, LaptopException {

    Employee employee = dao.findById(empId)
            .orElseThrow(() ->
                new EmployeeException("Employee not found"));

    Laptop laptop = laptopDao.findById(laptopId)
            .orElseThrow(() ->
                new LaptopException("Laptop not found"));

    employee.setLaptop(laptop);

    return dao.save(employee);
    }

    @Override
    public Employee deallocateLaptop(int empId) throws EmployeeException {

    Employee employee = dao.findById(empId)
            .orElseThrow(() ->
                    new EmployeeException("Employee not found"));

    employee.setLaptop(null);

    return dao.save(employee);
    }

   @Override
public Map<String, Long> getLaptopAvailability() {

    long totalLaptops = laptopDao.count();

    List<Employee> employees = dao.findAll();

    long assignedLaptops = employees.stream()
            .filter(e -> e.getLaptop() != null)
            .map(e -> e.getLaptop().getLaptopId())
            .distinct()
            .count();

    long notAssignedLaptops = totalLaptops - assignedLaptops;

    Map<String, Long> result = new HashMap<>();
    result.put("totalLaptops", totalLaptops);
    result.put("assignedLaptops", assignedLaptops);
    result.put("notAssignedLaptops", notAssignedLaptops);

    return result;
}
}