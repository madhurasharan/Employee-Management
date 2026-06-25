package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.beans.Laptop;

public interface LaptopRepositary extends JpaRepository<Laptop,Integer>{
    
}
