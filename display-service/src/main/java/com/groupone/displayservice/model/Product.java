package com.groupone.displayservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product 
{
	private int productId;
	private String productName;
	private int productUnitPrice;
	private int productStock;
}