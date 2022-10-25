package com.qa.ecommerce.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder




public class Product {
	private  int id;
	private  String name;
	private  double price;
	private  String category;
	private  boolean inStock;
	private  double discountPercentage;
	private  String deliveryMode;
	private  boolean isReturnAccepted;
	private  String sellerName;

}
