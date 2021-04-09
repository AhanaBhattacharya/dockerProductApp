package com.example.prod;

import java.time.LocalDate;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.prod.entities.Product;
import com.example.prod.repository.ProductRepo;

@SpringBootApplication
public class ProductAppApplication {
	
	@Autowired
    ProductRepo prepo;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductAppApplication.class, args);
	}

    @PostConstruct
	public void setUp() {
		prepo.save(new Product("prod1", "c1", 100.0, new Date()));
		prepo.save(new Product("prod2", "C2", 200.0, new Date()));
		prepo.save(new Product("prod3", "c3", 300.0, new Date()));
	}
}
