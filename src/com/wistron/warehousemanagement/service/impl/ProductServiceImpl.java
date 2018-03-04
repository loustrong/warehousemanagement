package com.wistron.warehousemanagement.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.wistron.warehousemanagement.dao.IProductDao;
import com.wistron.warehousemanagement.dao.impl.ProductDaoImpl;
import com.wistron.warehousemanagement.domain.Product;
import com.wistron.warehousemanagement.service.IProductService;

public class ProductServiceImpl implements IProductService {
	
	private IProductDao productDao = new ProductDaoImpl();
	
	
	
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.add(product);
	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	@Override
	public void deleteProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.delete(product);
	}

	@Override
	public List<Product> queryProduct(Product product, int page) {
		// TODO Auto-generated method stub
		
		return productDao.query(product, page);
	}

}
