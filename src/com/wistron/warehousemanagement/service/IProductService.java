package com.wistron.warehousemanagement.service;

import java.util.List;

import com.wistron.warehousemanagement.domain.Product;

public interface IProductService {
	public List<Product> queryProduct(Product product, int page);
	
	public void addProduct(Product product);
	
	public void updateProduct(Product product);
	
	public void deleteProduct(Product product);

	
	

}
