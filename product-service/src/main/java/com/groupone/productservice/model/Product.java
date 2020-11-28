package com.groupone.productservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	@NotEmpty(message = "Product Name canot be empty")
	@Pattern(regexp = "[A-z]+",message = "Product name must be a word")
	@Size(min = 1,max = 20)
	private String productName;
	@NotNull(message = "Product price must not be empty")
	@Min(value = 1,message = "Product price must be atleast 1 rupees")
	private int productUnitPrice; 
	@NotNull(message = "Product price must not be empty")
	@Min(value = 1,message = "Stock must be greater than zero")
	private int productStock;
}