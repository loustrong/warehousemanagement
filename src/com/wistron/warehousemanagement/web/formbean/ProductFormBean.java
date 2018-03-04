package com.wistron.warehousemanagement.web.formbean;

import java.util.HashMap;
import java.util.Map;

import com.wistron.warehousemanagement.domain.Product;

public class ProductFormBean {
	/**
	 * id | type | name   | price | modifiedTime | keeper | location  | quantity
	 * 
	 */
//	public ProductFormBean ProductFormBean(Product product) {
//		this.id = product.getId();
//		this.type=product.getType();
//		this.name = product.getName();
//		this.keeper=product.getKeeper();
//		this.location=product.getLocation();
//		this.modifiedTime=product.getModifiedTime();
//		this.price=product.getPrice();
//		this.quantity=product.getQuantity();
//		return this;
//	}
	private String id;
	private String type;
	private String name;
	private String price;
	private String modifiedTime;
	private String keeper;
	private String location;
	private int quantity;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	public String getKeeper() {
		return keeper;
	}
	public void setKeeper(String keeper) {
		this.keeper = keeper;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	private Map<String, String> errors = new HashMap<String, String>();

	public Map<String, String> getErrors() {
		return errors;
	}

	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	
	public boolean validate() {

		boolean isOk = true;

		if (this.id == null || this.id.trim().equals("")) {
			isOk = false;
			errors.put("id", "id不能为空！");
		} 
		if (this.type == null || this.type.trim().equals("")) {
			isOk = false;
			errors.put("type", "type不能为空！");
		}
		if (this.name == null || this.name.trim().equals("")) {
			isOk = false;
			errors.put("name", "id不能为空！");
		}
		if (this.price == null || this.price.trim().equals("")) {
			isOk = false;
			errors.put("price", "price不能为空！");
		}
		if (this.modifiedTime == null || this.modifiedTime.trim().equals("")) {
			isOk = false;
			errors.put("modifiedTime", "modifiedTime不能为空!");
		}
		if (this.keeper == null || this.keeper.trim().equals("")) {
			isOk = false;
			errors.put("keeper", "keeper不能为空！");
		}
		if (this.location == null || this.location.trim().equals("")) {
			isOk = false;
			errors.put("location", "location不能为空！");
		}
		if (this.quantity == 0 ) {
			isOk = false;
			errors.put("quantity", "quantity不能为0或quantity不能为空！");
		}
		
		return isOk;
	}
	
	
	
	

}
