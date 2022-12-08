package com.springrest.springrest.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrest.springrest.entites.Products;

public interface ProductsDao extends JpaRepository<Products,Long> {

	//Optional<Products> getById(Products product);
	
	
	

}
