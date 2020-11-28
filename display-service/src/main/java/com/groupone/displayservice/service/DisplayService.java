package com.groupone.displayservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.groupone.displayservice.exception.ProductNotFoundException;
import com.groupone.displayservice.feign.ProductProxy;
import com.groupone.displayservice.model.Product;

@Service
public class DisplayService
{
	@Autowired
	private ProductProxy productProxy;
	
	public Product getProduct(int id) throws ProductNotFoundException 
	{
		Product product = productProxy.getProduct(id);
		return product;
	}
}