package com.qa.ecommerce.service;

import java.util.List;
import java.util.Optional;

import com.qa.ecommerce.exception.ProductAlreadyExistsException;
import com.qa.ecommerce.exception.ProductNotFoundException;
import com.qa.ecommerce.model.Product;
import com.qa.ecommerce.repository.Repository;

public interface ProductServiceImpl extends ProductService {
	
	Repository repository = new Repository();

	

	@Override
	default Product getProductById(int id) throws ProductNotFoundException {
		Product product = ProductServiceImpl.repository.getProductById(id);
		if(product == null)
			throw new ProductNotFoundException("Product not found with the id :" + id);
		else
			return product;
	}

	@Override
	default List<Product> getAllProducts() {
		
		return repository.getAllProducts();
	}

	@Override
	default Product addProduct(Product product) throws ProductAlreadyExistsException {
		return Optional.ofNullable(repository.addProduct(product)).orElseThrow(()-> new ProductAlreadyExistsException("Product already in database"));
	}

	@Override
	default Product updateProduct(Product product) throws ProductNotFoundException {
		return Optional.ofNullable(repository.updateProduct(product)).orElseThrow(()-> new ProductNotFoundException("Product to be updated doesnt exist in database"));
	}

	@Override
	default boolean deleteProduct(int id) throws ProductNotFoundException {
        boolean isDeleted = repository.deleteProduct(id);
		
		if(!isDeleted) {
			throw new ProductNotFoundException("Product doesnt exist in database, nothing to delete");
		}
		
		return isDeleted;
	}
}
	
	


