package com.example.prod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.prod.dto.ProductDTO;
import com.example.prod.entities.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
	public Optional<Product> findByName(String name);
	
	@Query("SELECT u FROM Products u WHERE u.price = ?1")
	public Optional<Product> findUsingPrice(Double price);
}
