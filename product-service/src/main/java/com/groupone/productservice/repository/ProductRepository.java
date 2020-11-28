package com.groupone.productservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.groupone.productservice.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
