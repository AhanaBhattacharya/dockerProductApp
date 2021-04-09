package com.example.prod.entities;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity(name="Products")
public class Product {
	
	@Id
	@GeneratedValue
	private Long id;
	private String name;;
	private String category;
	private Double price;
	private Date expiryDate;
	
	public Product(String name, String category, Double price, Date expiryDate) {
		super();
		this.name = name;
		this.category = category;
		this.price = price;
		this.expiryDate = expiryDate;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
