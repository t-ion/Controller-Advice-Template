package com.groupone.displayservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.groupone.displayservice.exception.ProductNotFoundException;
import com.groupone.displayservice.model.Product;
import com.groupone.displayservice.service.DisplayService;

@RestController
public class DisplayController 
{
	@Autowired
	private DisplayService displayService;
	
	@GetMapping("/getProduct/{id}")
	public Product getProduct(@PathVariable("id") int id) throws ProductNotFoundException 
	{
		 return displayService.getProduct(id);
	}
}