package com.groupone.displayservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.groupone.displayservice.exception.ProductNotFoundException;
import com.groupone.displayservice.model.Product;


@FeignClient(name = "product-service",url = "http://localhost:8080")
public interface ProductProxy
{
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable("id") int id) throws ProductNotFoundException;
}