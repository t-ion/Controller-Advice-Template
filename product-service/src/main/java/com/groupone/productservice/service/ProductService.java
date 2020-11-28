package com.groupone.productservice.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.productservice.exception.ProductNotFoundException;
import com.groupone.productservice.model.Product;
import com.groupone.productservice.repository.ProductRepository;

@Service
public class ProductService 
{
	@Autowired
	private ProductRepository productRepository;
	
	public void saveProduct(Product product) 
	{
		productRepository.save(product);
	}
	
	public Product getProductById(int id) throws ProductNotFoundException 
	{
		Optional<Product> product = productRepository.findById(id);
		product.orElseThrow(() -> new ProductNotFoundException("Product Not Found"));
		return product.get();
	}
}