package com.example.prod.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.prod.dto.ProductDTO;
import com.example.prod.entities.Product;
import com.example.prod.repository.ProductRepo;

@Service
public class ProdServiceImpl {
	
	@Autowired
	ProductRepo pRepo;
	
	public ResponseEntity<List<ProductDTO>> getProducts(){
		List<Product> product=pRepo.findAll();
		if(product.isEmpty()) {
			Product p = new Product();
			return new ResponseEntity<List<ProductDTO>>(new ArrayList(product), HttpStatus.NO_CONTENT);
		}
		else {
		List<ProductDTO> pdto= product
		.stream()
		.map(prod -> {
			ProductDTO pDto = new ProductDTO();
			BeanUtils.copyProperties(prod, pDto); 
			return pDto;
		}).collect(Collectors.toList());
		return new ResponseEntity<List<ProductDTO>>(pdto, HttpStatus.OK);
		}
		}
	
	
	public ProductDTO getProductById(@PathVariable Long id) {
		
		ProductDTO pDto = new ProductDTO();
	BeanUtils.copyProperties(pRepo.findById(id).get(), pDto);   
	return pDto;
		
	}
	
	public ProductDTO getProductsByName(@PathVariable String name){
		/*return pRepo.findByName(name)
		.stream()
		.map(prod -> {
			ProductDTO pDto = new ProductDTO();
			BeanUtils.copyProperties(prod, pDto); 
			return pDto;
		}).collect(Collectors.toList());*/
		ProductDTO pDto = new ProductDTO();
		BeanUtils.copyProperties(pRepo.findByName(name).get(), pDto);   
		return pDto;
			
		}
	
	
	public ProductDTO getProductsUsingCategory(@PathVariable Double price){
		/*return pRepo.findByName(name)
		.stream()
		.map(prod -> {
			ProductDTO pDto = new ProductDTO();
			BeanUtils.copyProperties(prod, pDto); 
			return pDto;
		}).collect(Collectors.toList());*/
		ProductDTO pDto = new ProductDTO();
		BeanUtils.copyProperties(pRepo.findUsingPrice(price).get(), pDto);   
		return pDto;
			
		}

   public ProductDTO createProduct(ProductDTO prodDTO) {
	   Product pro = new Product();
		BeanUtils.copyProperties(prodDTO, pro); 
		pRepo.save(pro);
		return prodDTO;
   }

}


