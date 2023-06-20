package com.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Table("employee")
public class Employee implements Persistable<Long>{
@Id
private Long id;
private String name;
private float salary;

@Transient				// this variable or property ignored in database.
@JsonIgnoreProperties
private boolean isNew=true;

@Override
public boolean isNew() {
	// TODO Auto-generated method stub
	System.out.println("this method called...");
	return isNew || id==null;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}

}
