package com.springrest.springrest.controller;

import java.util.List; 

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.dao.ProductsDao;
import com.springrest.springrest.entites.Products;
import com.springrest.springrest.services.ProductsServices;

@RestController
//@RequestMapping("/api")
public class MyController {
	
	@Autowired
	private ProductsServices productServices;
	
	@GetMapping("/home")
	public String home() {
		
		return "this is home page Of YOUR'S 2'ND HOME ";
	}
	
	//get the PRODUCTS 
	@GetMapping("/Products")
	public List<Products> GetProducts()
	{
		
		return this.productServices.GetProducts();
		
	}
	
	//old
	//get the Products with products id
//	@GetMapping("/Products/{ProductId}")
//	public Products getProducs(@PathVariable String ProductId) {
//		return this.productServices.GetProducts(Long.parseLong(ProductId));
//	}
	
	//new 29 nov
	//get the Products with products id
	//working
	@GetMapping("/Products/{ProductId}")
	public ResponseEntity<Products> getProducts(@PathVariable("ProductId") long ProductId){
		return new ResponseEntity<Products>(productServices.GetProducts(ProductId), HttpStatus.OK);
		
	}
	
	
	//TO ADD THE PRODUCTS post mapping
	@PostMapping("/Products")
	public Products addProducts(@Valid @RequestBody Products products) {
			
		return this.productServices.addProducts(products);
	}
	
	//check
	//new for update 1
//	@PutMapping("/Products/{ProductId}")
//	public Products updateProducts(@PathVariable String ProductId) {
//		return this.productServices.GetProducts(Long.parseLong(ProductId));
//	}
	
	
	//update courses using PUT request
//	@PutMapping("/Products")
//	public Products updateProducts(@RequestBody Products product) {
//		return this.productServices.updateProducts(product);
//	}
	
	//NEW 22NOV &24 nov done on 29 nov
	@PutMapping("/Products/{ProductId}")
	public ResponseEntity<Products> updateProducts(@PathVariable("ProductId") long ProductId
			  ,@RequestBody Products products){
		try {
			return new ResponseEntity<Products>(productServices.updateProducts(products, ProductId), HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<Products>
			(productServices.updateProducts(products, ProductId), HttpStatus.INTERNAL_SERVER_ERROR);
		}

}

	
	
	//delete the course
	@DeleteMapping("/Products/{id}")
	public ResponseEntity<String> deleteProducts(@PathVariable("id") long id){
		
//		try {
//			this.productServices.deleteCourse(long id));
//			return new ResponseEntity<>(HttpStatus.OK);
//		}catch (Exception e){
//			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//		}
		
		//new 29 nov
		productServices.deleteProducts(id);
		
		return new ResponseEntity<String>("Products deleted successfully...!!!", HttpStatus.OK);
	}
}



//for delete the products 2
//@PutMapping("/Products")
//public Products DeleteProducts(@PathVariable String ProductId) {
//	return this.productServices.GetProducts(Long.parseLong(ProductId));
//}