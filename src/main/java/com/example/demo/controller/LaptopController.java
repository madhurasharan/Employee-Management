package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.Laptop;

@RestController
public class LaptopController {

    @GetMapping("/laptop")
    public Laptop getLaptop() {

        Laptop l1 = new Laptop();

        l1.setLaptopId(101);
        l1.setLaptopName("Dell Inspiron");
        l1.setCost(65000);

        return l1;
    }

    @GetMapping("/laptopList")
    public List<Laptop> laptopList() {

        List<Laptop> list = new ArrayList<>();

        list.add(new Laptop(101, "Dell", 65000));
        list.add(new Laptop(102, "HP", 70000));
        list.add(new Laptop(103, "Lenovo", 60000));

        return list;
    }
}