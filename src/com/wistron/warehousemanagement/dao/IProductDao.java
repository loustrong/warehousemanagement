package com.wistron.warehousemanagement.dao;

import java.util.ArrayList;
import java.util.List;

import com.wistron.warehousemanagement.domain.Product;

public interface IProductDao {

	/**
	 * �霂Ｚ挽憭�
	 */
	List<Product> query(Product product);

	/**
	 * 瘛餃�挽憭�
	 */
	void add(Product product);
	
	/**��霈曉��
	 */
	

	
	/**��霈曉��
	 */
	
	


	void delete(Product product);

	void update(Product product);

	List<Product> query(Product product, int page);


	
}
