package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entites.Products;

public interface ProductsServices {

	public List<Products> GetProducts();
	
	public Products GetProducts(long ProductId);
	
	public Products addProducts(Products products);
	
	public Products updateProducts(Products product, long ProductId);

	public void deleteProducts(long id);

	
	
}

//public Products updateProducts(long ProductId);
//
//public Products DeleteProducts(long ProductsId);
