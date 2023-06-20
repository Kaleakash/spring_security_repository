package com.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity					//this class map to table Product 
public class Product {	// In orm Java bean class known as entity class 
@Id							// the column which contains pk.  
private int pid;

@Column(name = "pname")			// name must be map to pname column 
private String name;
@Column(name="price")			// column name 
private float price;			// varialbe 
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
@Override
public String toString() {
	return "Product [pid=" + pid + ", name=" + name + ", price=" + price + "]";
}

}
