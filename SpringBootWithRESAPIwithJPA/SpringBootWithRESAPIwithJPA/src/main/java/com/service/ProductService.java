package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Product;
import com.dao.ProductDao;

@Service
public class ProductService {

	@Autowired
	ProductDao productDao;
	
	public String storeProduct(Product product) {
		if(productDao.storeProduct(product)>0) {
			return "Product record stored successfully";
		}else {
			return "Product didn't store";
		}
	}
	
	public String updateProduct(Product product) {
		if(productDao.updateProduct(product)>0) {
			return "Product updated successfully";
		}else {
			return "Product didn't update";
		}
	}
	
	public String deleteProduct(int pid) {
		if(productDao.deleteProduct(pid)>0) {
			return "Product record deleted successfully";
		}else {
			return "Product not present";
		}
	}
	
	public Product findProduct(int pid) {
		return productDao.findProduct(pid);
	}
	
	public List<Product> findAllProduct() {
		return productDao.findAllProduct();
	}
	
	public List<String> findProductNames(){
		return productDao.findAllProductNames();
	}
	
	public List<Object[]> findAllProductNameAndPrice(){
		return productDao.findAllProductNamesAndPrice();
	}
	
	public List<Object[]> productJoinQuery(){
		return productDao.joinQuery();
	}
}



