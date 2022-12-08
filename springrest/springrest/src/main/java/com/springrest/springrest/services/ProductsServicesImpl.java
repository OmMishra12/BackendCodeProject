package com.springrest.springrest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.dao.ProductsDao;
import com.springrest.springrest.entites.Products;
import com.springrest.springrest.exception.ProductNotFoundException;

@Service
public class ProductsServicesImpl implements ProductsServices {

	//remove
	//temp store of data
	//List<Products> list;
	
	//injection(constructor based injection)
	@Autowired
	private ProductsDao productsDao;
	
	public ProductsServicesImpl() {
		//remove
//		list = new ArrayList<>();
//		list.add(new Products(21,"Flat","This flat is near Talwade office in 500 meters"));
//		list.add(new Products(1,"PG","This P.G is near Talwade office in 1 K.M"));

	}
	
	@Override
	public List<Products> GetProducts() {
		// TODO Auto-generated method stub
		return productsDao.findAll();
	}

	//to get products using id 
	@Override
	public Products GetProducts(long ProductId) {
		// TODO Auto-generated method stub
//		Products c = null;
//		for(Products products:list)
//		{
//			if(products.getId() == ProductId)
//			{
//				c = products;
//				break;
//			}
//		}
		
		//old
		//return productsDao.getOne(ProductId);
		
		//29 nov
		//new(lambda)
		return this.productsDao.findById(ProductId).orElseThrow(() -> 
		new ProductNotFoundException("Products","ProductId",ProductId));
	}
	
	//to add the products
	@Override
	public Products addProducts(Products products) {
		// TODO Auto-generated method stub
		//list.add(products);
		productsDao.save(products);
		return products;
	}

	//to update a product
	@Override
	public Products updateProducts(Products products,long ProductId) {
		// TODO Auto-generated method stub
		//lambda function
	
//		list.forEach(e -> {
//			if(e.getId() == product.getId()) {
//				e.setType(product.getType());
//				e.setDescription(product.getDescription());
//			}
//		});
		
		//work
		//old
		//if product is present then it will update that products and 
		//if it is not present in the database it will add that data in database
		//productsDao.save(product);
		//old
		//	return product;
		
		//------
		//new
//		Products existingUser = this.productsDao.getById(product)
//				.orElseThrow(() -> new ResourceNotFoundException("User not found with id :" + userId));
//			 existingUser.setId(product.getId());
//			 existingUser.setType(product.getType());
//			 existingUser.setDescription(product.getDescription());
//			 return this.productsDao.save(existingUser);
//		
		//----22nov
		Products existingProducts = productsDao.findById(ProductId).orElseThrow(
				() -> new ProductNotFoundException("Products","ProductId",ProductId)); 
		
		existingProducts.setId(products.getId());
		existingProducts.setType(products.getType());
		existingProducts.setDescription(products.getDescription());
		// save existing Products to DB
		productsDao.save(existingProducts);
		return existingProducts;
		
	}

	@Override
	public void deleteProducts(long id) {
		// TODO Auto-generated method stub
		//list=this.list.stream().filter(e ->e.getId()!=parseLong).collect(Collectors.toList());
		//old working
//		Products entity = productsDao.getOne(parseLong);
//		productsDao.delete(entity);
		
		
		//new 
		productsDao.findById(id).orElseThrow(() -> 
		new ProductNotFoundException("Products","id",id));
		
		productsDao.deleteById(id);
	}
}


////
//list.forEach(e ->{
//	if(e.getId() == product.getId()) {
//		e.setType(product.getType());
//		e.setDescription(product.getDescription());
//	}
//});
//return product;




//public static void UpdateDetails(long id,String type, String Description) {
//long Newid = id;
//String NewType = type;
//String NewDescription = Description;
//
////return {Newid,NewType,NewDescription};
//}

//new 
//@Override
//public Products updateProducts(long ProductId) {
//// TODO Auto-generated method stub
//
//}


//@Override
//public Products UPProducts(Products products) {
//// TODO Auto-generated method stub
//list.add(products);
//return products;
//}