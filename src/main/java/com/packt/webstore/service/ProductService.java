package com.packt.webstore.service;

import java.util.List;
import java.util.Map;

import com.packt.webstore.domain.Product;

public interface ProductService {
	void updateAllStock();
	List <Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	List<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	Product getProductById(String productID);
	List<Product> filterProduct(String category, Map<String, String> price_band, String brand);
	void addProduct(Product product);
	
}
