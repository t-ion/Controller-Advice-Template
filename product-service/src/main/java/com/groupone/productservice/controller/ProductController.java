package com.groupone.productservice.controller;


import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.groupone.productservice.exception.ProductNotFoundException;
import com.groupone.productservice.model.Product;
import com.groupone.productservice.model.Response;
import com.groupone.productservice.service.ProductService;

@RestController
public class ProductController 
{
	@Autowired
	private ProductService productService;
	
	@PostMapping("/addProduct")
	public ResponseEntity<?> addProduct(@RequestBody Product product)
	{
		productService.saveProduct(product);
		return ResponseEntity.ok(new Response("Product added successfully",LocalDateTime.now()));
	}
	
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable("id") int id) throws ProductNotFoundException 
	{
		return productService.getProductById(id);
	}
}