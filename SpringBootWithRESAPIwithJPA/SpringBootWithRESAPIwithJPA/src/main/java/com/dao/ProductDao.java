package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Product;

@Repository
public class ProductDao {

	@Autowired
	EntityManagerFactory emf;			// like a connection 
	
	//@Autowired
	//SessionFactory sf;					// Hibernate 
	// Session = EntityManager 
	// session.save(p);		manager.save(p);
	
	public int storeProduct(Product product) {
		// without spring framework. 
		// persistence.xml file contains database details drivername,url,username and pasword. 
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("dbtest"); // persistenc.xml
		try {
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		EntityTransaction tran =manager.getTransaction();
		tran.begin();
			manager.persist(product);			// insert query like save 
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
		}
	
	public int updateProduct(Product product) {	// id and new price 
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		EntityTransaction tran =manager.getTransaction();
		Product p	= manager.find(Product.class, product.getPid());
		if(p==null) {
			return 0;
		}else {
			p.setPrice(product.getPrice());
			tran.begin();
				manager.merge(p);		// update query using pk 
			tran.commit();
			return 1;
		}
	}	
	public int deleteProduct(int pid) {	// using pk  
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		EntityTransaction tran =manager.getTransaction();
		Product p	= manager.find(Product.class, pid);
		if(p==null) {
			return 0;
		}else {		
			tran.begin();
				manager.remove(p);		// delete query using pk 
			tran.commit();
			return 1;
		}
	}
	
	public Product findProduct(int pid) {	// using pk  
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		Product p	= manager.find(Product.class, pid);
		return p;
	}
	
	public List<Product> findAllProduct() {	// using pk  
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		Query qry	 = manager.createQuery("select p from Product p");		//JPQL 
		//Query qry	 = manager.createNativeQuery("select * from product");	// SQL 
		List<Product> listOfProduct = qry.getResultList();
		return listOfProduct;
	}
	
	public List<String> findAllProductNames() {	// using pk  
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		Query qry	 = manager.createQuery("select p.name from Product p");
		List<String> listOfPname = qry.getResultList();
		return listOfPname;
	}
	
	public List<Object[]> findAllProductNamesAndPrice() {	// using pk  
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		Query qry	 = manager.createQuery("select p.name,p.price from Product p");
		List<Object[]> listOfPname = qry.getResultList();
		return listOfPname;
	}
	
	public List<Object[]> joinQuery() {	// using pk  
		EntityManager manager = emf.createEntityManager();// like a statement or prepared statement 
		Query qry	 = manager.createNativeQuery("select p.pname,p.price,o.emailid from product p, orders o where p.pid = o.pid");
		List<Object[]> listOfPname = qry.getResultList();
		return listOfPname;
	}
}



