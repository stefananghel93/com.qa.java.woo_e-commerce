package com.qa.ecommerce.controller;

import java.util.List;

import com.qa.ecommerce.exception.ProductAlreadyExistsException;
import com.qa.ecommerce.exception.ProductNotFoundException;
import com.qa.ecommerce.model.Product;
import com.qa.ecommerce.service.ProductServiceImpl;

public class ProductController {

	ProductServiceImpl productService;
	
	public List<Product>getAllProducts(){
		return productService.getAllProducts();
		
	}
	
	public Product getProductById(int id) {
		Product product = null;
		try {
			product = productService.getProductById(id);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return product;
		
	}
	
	public Product addProduct(Product product){
		Product productToAdd = null;
		
		try {
			productToAdd = productService.addProduct(product);
		}catch(ProductAlreadyExistsException e) {
			System.out.println(e.getMessage());
		}
		
		return productToAdd;
	}
	
	public Product updateProduct(Product product){
		Product updatedProduct = null;
		
		try {
			updatedProduct = productService.updateProduct(product);
		}catch(ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return updatedProduct;
	}
	
	public boolean deleteProduct(int id){
		boolean isDeleted = false;
		
		try {
			isDeleted = productService.deleteProduct(id);
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		return isDeleted;
	}
	
}
