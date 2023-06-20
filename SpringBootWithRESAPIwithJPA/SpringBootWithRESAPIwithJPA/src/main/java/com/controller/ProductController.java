package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.Product;
import com.service.ProductService;

@RestController
@RequestMapping("product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping(value = "storeProduct",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String storeProduct(@RequestBody() Product product) {
		System.out.println(product);
		return productService.storeProduct(product);
	}
	
	//@PutMapping
	
	@PatchMapping(value = "updateProduct",
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public String updateProduct(@RequestBody() Product product) {
		System.out.println(product);
		return productService.updateProduct(product);
	}
	
	@DeleteMapping(value = "deleteProduct/{pid}")
	public String updateProduct(@PathVariable() int pid) {
		return productService.deleteProduct(pid);
	}
	
	// http://localhost:8080/product/findProduct/101
	// http://localhost:8080/product/findProduct/1000

	@GetMapping(value = "findProduct/{pid}",produces = MediaType.APPLICATION_JSON_VALUE)
	public Product findProduct(@PathVariable("pid") int pid) {
		return productService.findProduct(pid);
	}
	// http://localhost:8080/product/findAllProduct
	@GetMapping(value = "findAllProduct",produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Product> findAllProduct() {
		return productService.findAllProduct();
	}
	// http://localhost:8080/product/findAllProductNames
	@GetMapping(value = "findAllProductNames")
	public List<String> findAllProductNames() {
		return productService.findProductNames();
	}
	// http://localhost:8080/product/findAllProductNamesAndPrice
	@GetMapping(value = "findAllProductNamesAndPrice")
	public List<Object[]> findAllProductNamesAndPrice() {
		return productService.findAllProductNameAndPrice();
	}
	
	@GetMapping(value = "joinQuery")
	public List<Object[]> joinQuery() {
		return productService.productJoinQuery();
	}
	
}







