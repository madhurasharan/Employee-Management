package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.beans.Laptop;
import com.example.demo.exception.LaptopException;
import com.example.demo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/laptops")
public class LaptopController {

    @Autowired
    private EmployeeServiceImpl service;

    @PostMapping("/addLaptop")
    public Laptop addLaptop(@RequestBody Laptop laptop) {
        return service.addLaptop(laptop);
    }

    @GetMapping("/getLaptop/{laptopId}")
    public Laptop getLaptop(@PathVariable int laptopId)
            throws LaptopException {

        return service.getLaptop(laptopId);
    }

    @GetMapping("/getLaptops")
    public List<Laptop> getLaptops() {
        return service.getLaptops();
    }

    @PutMapping("/updateLaptop/{laptopId}")
    public Laptop updateLaptop(@PathVariable int laptopId,
                               @RequestBody Laptop laptop)
            throws LaptopException {

        return service.updateLaptop(laptopId, laptop);
    }

    @DeleteMapping("/deleteLaptop/{laptopId}")
    public boolean deleteLaptop(@PathVariable int laptopId) {
        return service.deleteLaptop(laptopId);
    }
}