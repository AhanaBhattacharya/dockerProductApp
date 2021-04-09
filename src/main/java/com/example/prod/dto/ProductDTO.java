package com.example.prod.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	
	private String name;;
	private String category;
	private Double price;
	private Date expiryDate;

}
