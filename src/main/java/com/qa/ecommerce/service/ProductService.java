package com.qa.ecommerce.service;

import java.util.List;

import com.qa.ecommerce.exception.ProductAlreadyExistsException;
import com.qa.ecommerce.exception.ProductNotFoundException;
import com.qa.ecommerce.model.Product;

public interface ProductService {
	
	Product getProductById(int id) throws ProductNotFoundException;
	List<Product> getAllProducts();
	Product addProduct(Product product) throws ProductAlreadyExistsException;
	Product updateProduct(Product product) throws ProductNotFoundException;
	boolean deleteProduct(int id) throws ProductNotFoundException;

}
