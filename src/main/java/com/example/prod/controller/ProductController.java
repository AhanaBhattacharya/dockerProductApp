package com.example.prod.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.prod.dto.ProductDTO;
import com.example.prod.entities.Product;
import com.example.prod.repository.ProductRepo;
import com.example.prod.service.ProdServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	ProdServiceImpl pServ;
	
	@GetMapping("/getAll")
	public ResponseEntity<List<ProductDTO>> getAll(){
		return pServ.getProducts();
	
	}
	
	@GetMapping("/get/{id}")
	public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
		return ResponseEntity.ok(pServ.getProductById(id));
		
	}
	
	@GetMapping("/getprod/{name}")
	public ResponseEntity<ProductDTO> getProductByName(@PathVariable String name) {
		return ResponseEntity.ok(pServ.getProductsByName(name));
	}
	
	@GetMapping("/getprice/{price}")
	public ResponseEntity<ProductDTO> getProductUsingCategory(@PathVariable Double price) {
		return ResponseEntity.ok(pServ.getProductsUsingCategory(price));
	}

	@PostMapping("/save")
	public ResponseEntity<ProductDTO> getProductUsingCategory(@RequestBody ProductDTO pro) {
		return ResponseEntity.ok(pServ.createProduct(pro));
	}

}
